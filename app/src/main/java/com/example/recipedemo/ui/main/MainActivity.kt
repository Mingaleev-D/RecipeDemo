package com.example.recipedemo.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.recipedemo.R
import com.example.recipedemo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
   private val binding by lazy {
      ActivityMainBinding.inflate(layoutInflater)
   }
   private lateinit var navController: NavController

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(binding.root)

      navController = binding.fragmentContainerView.getFragment<NavHostFragment>().navController
      NavigationUI.setupWithNavController(binding.btnNavView, navController)
   }
}