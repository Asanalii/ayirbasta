package com.example.app_study_hilt.data.preferences

import android.content.SharedPreferences

interface SharedPreferencesUtils {
    fun saveToken(key: Preferences, value: String)
    fun saveInt(key: Preferences,value: Int)

    fun getToken(key: Preferences): String
    fun getInt(key: Preferences): Int
}

enum class Preferences{
    ACCESS_TOKEN
}

class SharedPreferencesUtilsImpl(
    private val preferences: SharedPreferences
): SharedPreferencesUtils {
    override fun saveToken(key: Preferences, value: String) {
        val editor = preferences.edit()
        editor.putString(key.name, value)
        editor.apply()
    }

    override fun saveInt(key: Preferences, value: Int) {
        val editor = preferences.edit()
        editor.putInt(key.name, value)
        editor.apply()
    }

    override fun getToken(key: Preferences): String {
        return preferences.getString(key.name, "").orEmpty()
    }

    override fun getInt(key: Preferences): Int {
        return preferences.getInt(key.name, 0)
    }
}

