package com.locotoDevTeam.diccionariocamba.util

import android.content.Context

class SharedPrefs(context: Context) {

    val prefs =
        context.getSharedPreferences("com.locotoDevTeam.diccionariocamba", Context.MODE_PRIVATE)

    companion object {
        const val FIRST_LOAD = "first_load"
    }

    fun saveBoolean(key: String, value: Boolean) {
        prefs.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean {
        return prefs.getBoolean(key, false)
    }

}