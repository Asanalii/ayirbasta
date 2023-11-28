package com.example.ayirbasta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.ayirbasta.data.MainViewModel
import com.example.ayirbasta.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.getHealthcheck()
        viewModel.getHealthcheckLiveData.observe(this) {
            binding.text.text = it.status
        }

//        binding.progressBar.progress = 30
    }
}