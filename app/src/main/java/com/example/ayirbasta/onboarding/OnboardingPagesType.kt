package com.example.ayirbasta.onboarding

import androidx.annotation.DrawableRes
import com.example.ayirbasta.R

enum class OnboardingPagesType(@DrawableRes val image: Int, val description: String, val mainText: String) {
    FIRST(
        R.drawable.ic_onboarding_welcome,
        "With our easy-to-use app, you can browse profiles and arrange meetups with other items owners in your area.",
        "Welcome to Ayirbasta!"),
    SECOND(
        R.drawable.ic_onboarding_load,
        "Include information about your items.",
        "Load your items to profile."),
    THIRD(
        R.drawable.ic_onboarding_start,
        "Once you've created your item’s profile, you can start swiping through potential matches.",
        "Start trading!")
}