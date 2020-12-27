package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.fragment_shoe_list.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        val navController = findNavController(R.id.myNavHostFragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setSupportActionBar(findViewById(R.id.toolbar))
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

}
