package com.example.ayirbasta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.ayirbasta.databinding.ActivityMainBinding
import com.example.ayirbasta.extensions.isBottomNavVisible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /*viewModel.getHealthcheck()
        viewModel.getHealthcheckLiveData.observe(this) {
            binding.text.text = it.systemInfo?.environment
        }*/

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener{ _, destination, _ ->

            val isBottomNavigationVisible = destination.isBottomNavVisible()

            binding.bottomNavigation.post {
                binding.bottomNavigation.isVisible = isBottomNavigationVisible
            }
        }

    }
}