package com.sideki.telegramclone.ui.fragments

import androidx.fragment.app.Fragment
import com.sideki.telegramclone.MainActivity
import com.sideki.telegramclone.utilites.APP_ACTIVITY

open class BaseFragment(layout: Int) : Fragment(layout) {

    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.mAppDrawer.disableDrawer()
    }
}