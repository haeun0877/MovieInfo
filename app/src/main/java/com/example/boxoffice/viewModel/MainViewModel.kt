package com.example.boxoffice.viewModel

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.boxoffice.utils.Utils

class MainViewModel : ViewModel() {

    // 뒤로 가기 리스너 관련 변수
    private val _finishCheck = MutableLiveData<Boolean>()
    val finishCheck: LiveData<Boolean>
        get() = _finishCheck
    lateinit var exitToast: Toast
    private var backPressed = false


    // 뒤로가기 버튼 클릭 시 체크
    fun checkBackPressed(){
        if(backPressed){
            _finishCheck.value = true
        }else{
            Utils.toastLiveData.value = "'뒤로'버튼을 한 번 더 누르시면 종료됩니다."

            backPressed = true

            // LENGTH_SHORT 길이(2초)의 Toast 메세지가 끝나면 backPressed를 다시 false로 변경해줌
            Handler(Looper.getMainLooper()).postDelayed({
                backPressed = false
            }, 2000)
        }
    }
}