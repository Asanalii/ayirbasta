package com.example.ayirbasta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ayirbasta.databinding.ActivityMainBinding
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


//        binding.progressBar.progress = 30
    }
}