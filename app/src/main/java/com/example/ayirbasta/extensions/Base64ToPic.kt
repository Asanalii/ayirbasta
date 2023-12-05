package com.example.ayirbasta.extensions

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64

fun base64toPic(item:String): Bitmap{
    val base64Image = item.toString()
    val imageBytes = Base64.decode(base64Image, Base64.DEFAULT)
    val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)

    return decodedImage
}