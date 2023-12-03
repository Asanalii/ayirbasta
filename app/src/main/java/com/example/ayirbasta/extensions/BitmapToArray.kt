package com.example.ayirbasta.extensions

import android.graphics.Bitmap
import java.io.ByteArrayOutputStream

fun Bitmap.toByteArray(): ByteArray {
    val stream = ByteArrayOutputStream()
    var quality = 100
    do {
        quality -= if (this.byteCount > 1024000) 2 else 0
        this.compress(Bitmap.CompressFormat.JPEG, quality, stream)
    } while (this.byteCount <= 1024000)

    return stream.toByteArray()
}