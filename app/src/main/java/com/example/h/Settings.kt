package com.example.h

import android.content.Context

class Settings(context: Context) {
    companion object {
        const val TEXT_SIZE = "TextSize"
    }

    private val prefs = context.getSharedPreferences("${context.packageName}.settings", Context.MODE_PRIVATE)

    fun decrementTextSize() {
        prefs.edit().putFloat(TEXT_SIZE, getTextSize()-2).apply()
    }

    fun incrementTextSize() {
        prefs.edit().putFloat(TEXT_SIZE, getTextSize()+2).apply()
    }

    fun getTextSize() : Float {
        return prefs.getFloat(TEXT_SIZE, 16f)
    }
}