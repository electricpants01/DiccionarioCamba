package com.locotoDevTeam.diccionariocamba.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.locotoDevTeam.diccionariocamba.R
import com.locotoDevTeam.diccionariocamba.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        initBottomNavView()

    }

    private fun initBottomNavView(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.myNavController) as NavHostFragment
        val navController = navHostFragment.navController
        mainBinding.myBottomNavView.setupWithNavController(navController)
    }
}