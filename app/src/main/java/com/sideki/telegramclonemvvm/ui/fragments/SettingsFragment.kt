package com.sideki.telegramclonemvvm.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import com.sideki.telegramclonemvvm.R
import com.sideki.telegramclonemvvm.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }
}