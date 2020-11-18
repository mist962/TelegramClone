package com.sideki.telegramclone

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.sideki.telegramclone.ui.objects.AppDrawer
import com.sideki.telegramclone.utilites.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var mAppDrawer: AppDrawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(mainToolbar)
        APP_ACTIVITY = this
        initFirebase()
        initUser {
            initFields()
            initFunc()
        }
    }

    override fun onStart() {
        super.onStart()
        AppStates.updateState(AppStates.ONLINE)
    }

    override fun onStop() {
        super.onStop()
        AppStates.updateState(AppStates.OFFLINE)
    }

    private fun initFields() {
        navController = findNavController(R.id.main_container_fragment)
        //setupActionBarWithNavController(navController)
        mAppDrawer = AppDrawer(this, mainToolbar, navController)

    }

    private fun initFunc() {
        if (AUTH.currentUser != null) {
            mAppDrawer.create()
        } else {
            replaceActivity(RegisterActivity())
        }
    }

    override fun navigateUpTo(upIntent: Intent?): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}