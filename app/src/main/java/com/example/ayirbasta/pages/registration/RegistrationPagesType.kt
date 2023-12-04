package com.example.ayirbasta.pages.registration

import androidx.annotation.DrawableRes
import com.example.ayirbasta.R

enum class RegistrationPagesType(

    val mainText: String,
    val secondaryText: String,
    val firstInput:String,
    val secondaryInput:String,
    val thirdInput:String,
    val buttonText: String
) {
    FIRST(
        "Find your item",
        "Join Ayirbasta, the item trading app that helps you find items for both you and your furry friend.",
        "Email",
        "Password",
        "Password",
        "Continue"
    ),
    SECOND(
        "Tell us about yourself",
        "Before to help you find the perfect match for your item tell about yourself.",
        "Firstname",
        "Secondname",
        "",
        "Create account"
    )
}