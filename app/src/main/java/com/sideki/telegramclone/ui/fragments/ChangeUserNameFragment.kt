package com.sideki.telegramclone.ui.fragments

import androidx.navigation.fragment.findNavController
import com.sideki.telegramclone.R
import com.sideki.telegramclone.utilites.*
import kotlinx.android.synthetic.main.fragment_change_user_name.*
import java.util.*

class ChangeUserNameFragment : BaseChangeFragment(R.layout.fragment_change_user_name) {

    lateinit var mNewUserName: String

    override fun onResume() {
        super.onResume()
        settings_input_username.setText(USER.username)
    }

    override fun change() {
        mNewUserName = settings_input_username.text.toString().toLowerCase(Locale.getDefault())
        if (mNewUserName.isEmpty()) {
            showToast("Поле пустое")
        } else {
            REF_DATABASE_ROOT.child(NODE_USERNAMES)
                .addListenerForSingleValueEvent(AppValuewEventListener {
                    if (it.hasChild(mNewUserName)) {
                        showToast("Пользователь с таким именем уже существует")
                    } else {
                        changeUsername()
                    }
                })
        }
    }

    private fun changeUsername() {
        REF_DATABASE_ROOT.child(NODE_USERNAMES).child(mNewUserName).setValue(UID)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    udateCurrentUsername()
                }
            }
    }

    private fun udateCurrentUsername() {
        REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_USERNAME).setValue(mNewUserName)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    showToast(getString(R.string.toast_data_update))
                    deleteOldUsername()
                } else {
                    showToast(it.exception?.message.toString())
                }
            }
    }

    private fun deleteOldUsername() {
        REF_DATABASE_ROOT.child(NODE_USERNAMES).child(USER.username).removeValue()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    showToast(getString(R.string.toast_data_update))
                    findNavController().navigateUp()
                    USER.username = mNewUserName
                } else {
                    showToast(it.exception?.message.toString())
                }
            }
    }

}