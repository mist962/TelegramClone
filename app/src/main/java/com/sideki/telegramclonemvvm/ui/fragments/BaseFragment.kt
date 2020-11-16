package com.sideki.telegramclonemvvm.ui.fragments

import androidx.fragment.app.Fragment
import com.sideki.telegramclonemvvm.MainActivity

open class BaseFragment(layout: Int) : Fragment(layout) {

    override fun onStart() {
        super.onStart()
        (activity as MainActivity).mAppDrawer.disableDrawer()
    }

    override fun onStop() {
        super.onStop()
        (activity as MainActivity).mAppDrawer.enableDrawer()
    }
}