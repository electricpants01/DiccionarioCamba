package com.locotoDevTeam.diccionariocamba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.locotoDevTeam.diccionariocamba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding
    lateinit var navController: NavController

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