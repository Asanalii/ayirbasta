package com.example.ayirbasta.extensions

import androidx.navigation.NavDestination
import com.example.ayirbasta.NavigationFragmentLists

fun NavDestination.isBottomNavVisible(): Boolean {

    return when (this.getCurrentScreen()) {
        NavigationFragmentLists.HOME,
        NavigationFragmentLists.ITEM_LIST,
        NavigationFragmentLists.PROFILE -> true

        else -> false
    }
}

fun NavDestination.getCurrentScreen(): NavigationFragmentLists {
    return NavigationFragmentLists.values().firstOrNull {
        this.label == it.destinationName
    } ?: NavigationFragmentLists.UNKNOWN
}