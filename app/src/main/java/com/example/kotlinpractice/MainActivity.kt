package com.example.kotlinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.message_icon_layout.*
import kotlinx.android.synthetic.main.museum_icon_layout.*
import kotlinx.android.synthetic.main.person_icon_layout.*
import kotlinx.android.synthetic.main.search_icon_layout.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = findNavController(R.id.fragment)

        val destinationMap = mapOf(
            R.id.messageFragment to messageMotionlayout,
            R.id.museumFragment to museumMotionlayout,
            R.id.searchFragment to searchMotionlayout,
            R.id.personFragment to personMotionlayout
        )

//        messageMotionlayout.setOnClickListener { navController.navigate(R.id.messageFragment) }
//        museumMotionlayout.setOnClickListener { navController.navigate(R.id.museumFragment) }
//        searchMotionlayout.setOnClickListener { navController.navigate(R.id.searchFragment) }
//        personMotionlayout.setOnClickListener { navController.navigate(R.id.personFragment) }
        destinationMap.forEach{map->
            map.value.setOnClickListener { navController.navigate(map.key) }

        }

        setupActionBarWithNavController(
            navController,
            //AppBarConfiguration(setOf(R.id.messageFragment,R.id.museumFragment,R.id.searchFragment,R.id.personFragment))
            AppBarConfiguration(destinationMap.keys)
        )

        navController.addOnDestinationChangedListener{controller, destination, arguments ->
            controller.popBackStack()
//            messageMotionlayout.progress = 0f
//            museumMotionlayout.progress = 0f
//            searchMotionlayout.progress = 0f
//            personMotionlayout.progress = 0f
            destinationMap.values.forEach{it.progress = 0f}
            destinationMap[destination.id]?.transitionToEnd()
//            when(destination.id) {
////                R.id.messageFragment -> messageMotionlayout.transitionToEnd()
////                R.id.museumFragment -> museumMotionlayout.transitionToEnd()
////                R.id.searchFragment -> searchMotionlayout.transitionToEnd()
////                else -> personMotionlayout.transitionToEnd()
////            }

        }
    }
}