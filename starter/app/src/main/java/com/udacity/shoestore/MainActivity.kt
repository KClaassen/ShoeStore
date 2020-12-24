package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.fragment_shoe_list.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        val navController = findNavController(R.id.myNavHostFragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setOf(R.id.LoginFragment, R.id.welcomeFragment, R.id.instructionsFragment, R.id.shoeListFragment)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<Toolbar>(R.id.toolbar)
                .setupWithNavController(navController, appBarConfiguration)


    }

}
