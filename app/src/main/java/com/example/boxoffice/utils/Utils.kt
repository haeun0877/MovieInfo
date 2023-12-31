package com.example.boxoffice.utils

import android.content.Context
import android.widget.Toast

class Utils {

    companion object {
        fun showToast(context: Context, message: String, isShort: Boolean){
            if(isShort) Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            else Toast.makeText(context,message, Toast.LENGTH_LONG).show()
        }
    }
}