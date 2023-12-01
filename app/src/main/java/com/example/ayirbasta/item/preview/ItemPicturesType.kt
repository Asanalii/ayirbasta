package com.example.ayirbasta.item.preview

import androidx.annotation.DrawableRes
import com.example.ayirbasta.R

enum class ItemPicturesType(@DrawableRes val image: Int) {
    FIRST(
        R.drawable.ic_onboarding_welcome),
    SECOND(
        R.drawable.ic_onboarding_load),
    THIRD(
        R.drawable.ic_onboarding_start)
}