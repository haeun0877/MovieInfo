package com.example.boxoffice.remote.local

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtil(){

    companion object{
        lateinit var prefs: SharedPreferences
    }

    fun getString(key: String, defValue: String): String {
        return prefs.getString(key, defValue).toString()
    }

    fun setString(key: String, str: String) {
        prefs.edit().putString(key, str).apply()
    }

    fun setPref(context: Context){
        prefs = context.getSharedPreferences("MOVE_INFO", Context.MODE_PRIVATE)
    }
}