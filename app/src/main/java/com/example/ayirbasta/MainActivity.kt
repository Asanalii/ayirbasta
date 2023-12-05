package com.example.ayirbasta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import com.example.app_study_hilt.data.preferences.Preferences
import com.example.app_study_hilt.data.preferences.SharedPreferencesUtils
import com.example.ayirbasta.databinding.ActivityMainBinding
import com.example.ayirbasta.extensions.isBottomNavVisible
import com.example.ayirbasta.pages.WelcomeFragment
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

            navController.navigate(R.id.itemFragment)
        }



        navController.addOnDestinationChangedListener { _, destination, _ ->

            val isBottomNavigationVisible = destination.isBottomNavVisible()

            binding.bottomNavigation.post {
                binding.bottomNavigation.isVisible = isBottomNavigationVisible
            }
        }

    }
}