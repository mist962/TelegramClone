package com.sideki.telegramclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.sideki.telegramclone.databinding.ActivityRegisterBinding
import com.sideki.telegramclone.utilites.initFirebase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(registerToolbar)
        initFirebase()
    }

    override fun onStart() {
        super.onStart()
        navController = findNavController(R.id.register_container_fragment)
        setupActionBarWithNavController(navController)
    }

}