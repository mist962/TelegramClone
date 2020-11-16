package com.sideki.telegramclonemvvm.ui.fragments

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider
import com.sideki.telegramclonemvvm.MainActivity
import com.sideki.telegramclonemvvm.R
import com.sideki.telegramclonemvvm.RegisterActivity
import com.sideki.telegramclonemvvm.utilites.*
import kotlinx.android.synthetic.main.fragment_enter_code.*

class EnterCodeFragment : Fragment(R.layout.fragment_enter_code) {

    private val args by navArgs<EnterCodeFragmentArgs>()
    private lateinit var mAuth: FirebaseAuth

    override fun onStart() {
        super.onStart()
        mAuth = FirebaseAuth.getInstance()
        register_input_code.addTextChangedListener(AppTextWatcher {
            val string = register_input_code.text.toString()
            if (string.length == 6) {
                enterCode()
            }
        })
    }

    private fun enterCode() {
        val credential =
            PhoneAuthProvider.getCredential(args.id, register_input_code.text.toString())
        mAuth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful) {
                val uid = AUTH.currentUser?.uid.toString()
                val dateMap = mutableMapOf<String, Any>()
                dateMap[CHILD_ID] = uid
                dateMap[CHILD_PHONE] = args.phone
                dateMap[CHILD_USERNAME] = uid

                REF_DATABASE_ROOT.child(NODE_USERS).child(uid).updateChildren(dateMap)
                    .addOnCompleteListener {task2 ->
                        if (task2.isSuccessful) {
                            showToast("Добро пожаловать")
                            (activity as RegisterActivity).replaceActivity(MainActivity())
                        } else showToast(task2.exception?.message.toString())

                    }
            } else showToast(it.exception?.message.toString())
        }
    }
}