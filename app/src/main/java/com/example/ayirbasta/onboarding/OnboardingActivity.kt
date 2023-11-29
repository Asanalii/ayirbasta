package com.example.ayirbasta.onboarding

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ayirbasta.adapters.ViewPagerAdapter
import com.example.ayirbasta.databinding.ActivityOnboardingBinding
import com.google.android.material.tabs.TabLayoutMediator

class OnboardingActivity: AppCompatActivity() {
    private val binding: ActivityOnboardingBinding by lazy { ActivityOnboardingBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val pagesList: MutableList<Fragment> = mutableListOf()
        OnboardingPagesType.values().forEach {
            pagesList.add(OnboardingFragment(it))
        }
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle, pagesList)

        binding.viewPager.adapter = adapter
        binding.viewPager.currentItem = 0

        TabLayoutMediator(binding.bottomTab, binding.viewPager){tab, position ->
            tab.view.isClickable = false



            if(OnboardingPagesType.values()[position].ordinal == 2) {
                binding.nextButton.setOnClickListener{
//                    Toast.makeText(this, "the last page", Toast.LENGTH_SHORT).show()
                    Toast.makeText(this, "${OnboardingPagesType.values()[position]}", Toast.LENGTH_SHORT).show()
                }
            }
        }.attach()

        binding.skip.setOnClickListener {
            Toast.makeText(this, "skip clicked", Toast.LENGTH_SHORT).show()
        }

    }
}