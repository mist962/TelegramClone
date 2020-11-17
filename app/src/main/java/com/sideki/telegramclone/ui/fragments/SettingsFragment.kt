package com.sideki.telegramclone.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.sideki.telegramclone.MainActivity
import com.sideki.telegramclone.R
import com.sideki.telegramclone.RegisterActivity
import com.sideki.telegramclone.utilites.AUTH
import com.sideki.telegramclone.utilites.USER
import com.sideki.telegramclone.utilites.replaceActivity
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
        initFields()

    }

    private fun initFields() {
        settings_bio.text = USER.bio
        settings_full_name.text = USER.fullname
        settings_phone_number.text = USER.phone
        settings_status.text = USER.status
        settings_username.text = USER.username

        settings_btn_change_username.setOnClickListener { findNavController().navigate(R.id.action_settingsFragment_to_changeUserNameFragment) }
        settings_btn_change_bio.setOnClickListener { findNavController().navigate(R.id.action_settingsFragment_to_changeBioFragment) }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings_menu_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
            R.id.settings_menu_change_name ->{
                findNavController().navigate(R.id.action_settingsFragment_to_changeNameFragment)
            }

        }
        return true
    }
}