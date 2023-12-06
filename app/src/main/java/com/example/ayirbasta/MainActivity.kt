package com.example.ayirbasta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.app_study_hilt.data.preferences.Preferences
import com.example.app_study_hilt.data.preferences.SharedPreferencesUtils
import com.example.ayirbasta.databinding.ActivityMainBinding
import com.example.ayirbasta.extensions.isBottomNavVisible
import com.example.ayirbasta.pages.WelcomeFragment
import com.example.ayirbasta.pages.home.HomeFragment
import com.example.ayirbasta.pages.item.ItemFragment
import com.example.ayirbasta.pages.trades.TradesFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    @Inject
    lateinit var preferences: SharedPreferencesUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController

        val accessToken = preferences.getToken(Preferences.ACCESS_TOKEN)
        if (accessToken.isEmpty()) {

            navController.navigate(R.id.welcomeFragment)
        } else {

            navController.navigate(R.id.homeFragment)
        }


        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            // Determine which fragment to show based on the clicked item
            val selectedFragment: Fragment = when (item.itemId) {
                R.id.homeFragment -> HomeFragment()
                R.id.itemFragment -> ItemFragment()
                R.id.tradesFragment -> TradesFragment()
                // Add more cases for other menu items
                else -> return@setOnNavigationItemSelectedListener false
            }

            // Begin a transaction to replace the current fragment
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, selectedFragment) // Replace 'R.id.fragment_container' with your actual container ID
                .commit()

            true // Return true to indicate the click event was handled
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->

            val isBottomNavigationVisible = destination.isBottomNavVisible()

            binding.bottomNavigation.post {
                binding.bottomNavigation.isVisible = isBottomNavigationVisible
            }
        }

    }
}