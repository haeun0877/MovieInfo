package com.example.boxoffice.utils

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData

class Utils {

    companion object{

        lateinit var toast: Toast

        // 문구 표출(Toast) 관련 변수
        private val mToastLiveData = MutableLiveData<String?>()
        val toastLiveData: MutableLiveData<String?> = mToastLiveData

        fun showToast(context: Context, message: String){
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}