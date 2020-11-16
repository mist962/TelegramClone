package com.sideki.telegramclonemvvm.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import com.sideki.telegramclonemvvm.MainActivity
import com.sideki.telegramclonemvvm.R
import com.sideki.telegramclonemvvm.RegisterActivity
import com.sideki.telegramclonemvvm.utilites.replaceActivity

class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    private lateinit var mAuth: FirebaseAuth

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)

        mAuth = FirebaseAuth.getInstance()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings_menu_exit -> {
                mAuth.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
        }
        return true
    }
}