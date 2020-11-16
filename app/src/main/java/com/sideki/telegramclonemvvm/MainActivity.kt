package com.sideki.telegramclonemvvm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.sideki.telegramclonemvvm.ui.objects.AppDrawer
import com.sideki.telegramclonemvvm.utilites.AUTH
import com.sideki.telegramclonemvvm.utilites.initFirebase
import com.sideki.telegramclonemvvm.utilites.replaceActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    lateinit var mAppDrawer: AppDrawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(mainToolbar)

    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFields() {
        navController = findNavController(R.id.main_container_fragment)
        //setupActionBarWithNavController(navController)
        mAppDrawer = AppDrawer(this, mainToolbar, navController)
        initFirebase()
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