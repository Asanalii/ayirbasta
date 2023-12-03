package com.example.ayirbasta.extensions

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

inline fun <T> LifecycleOwner.observe(liveData: LiveData<T>, crossinline observer: (T) -> Unit) {
    liveData.observe(this) {
        try {
            it?.let(observer)
        } catch (e: Exception) {
            Log.e(">>>","Observe exception: ${e.message}")
        }
    }
}