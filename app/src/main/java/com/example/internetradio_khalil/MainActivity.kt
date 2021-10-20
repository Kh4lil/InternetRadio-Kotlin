package com.example.internetradio_khalil

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.internetradio_khalil.databinding.ActivityMainBinding //Enabled in build gradle
import androidx.navigation.ui.setupWithNavController


class MainActivity : AppCompatActivity() {

    //Fragments:
    // CHANNEL
    //CONFIG
    //HOME
    private lateinit var bindingControl: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //set the control to inflate:
        bindingControl = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingControl.root) // root

        val navigation_View: BottomNavigationView = bindingControl.navView

        val navViewControl = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_config, R.id.navigation_channel // array
            )
        )

        // DEBUG

        setupActionBarWithNavController(navViewControl, appBarConfiguration)

        navigation_View.setupWithNavController(navViewControl)
    }
}