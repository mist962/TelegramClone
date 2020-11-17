package com.sideki.telegramclone.ui.fragments

import androidx.fragment.app.Fragment
import com.sideki.telegramclone.MainActivity

open class BaseFragment(layout: Int) : Fragment(layout) {

    override fun onStart() {
        super.onStart()
        (activity as MainActivity).mAppDrawer.disableDrawer()
    }
}