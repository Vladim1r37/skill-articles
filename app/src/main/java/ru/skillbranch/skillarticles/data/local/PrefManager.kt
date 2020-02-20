package ru.skillbranch.skillarticles.data.local

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class PrefManager(context: Context) : PreferenceManager(context) {
    val preferences: SharedPreferences = context.getSharedPreferences("data", Context.MODE_PRIVATE)

    fun clearAll() {
        with(preferences.edit()) {
            clear()
            commit()
        }
    }
}