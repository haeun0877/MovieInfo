package com.example.boxoffice.view.activity

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.boxoffice.R
import com.example.boxoffice.base.BaseActivity
import com.example.boxoffice.databinding.ActivityMainBinding
import com.example.boxoffice.utils.Utils
import com.example.boxoffice.view.fragment.BoxOfficeDailyListFragment
import com.example.boxoffice.viewModel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel : MainViewModel by viewModels()
    private lateinit var navController : NavController

    override fun init() {
        val navHostFragment =supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // 뒤로 가기 클릭 시 이벤트 구현
        onBackListener()
        // 뒤로 가기 두번 클릭 시 앱 종료
        viewModel.finishCheck.observe(this) { value ->
            if (value) {
                finish()
            }
        }

        // Toast 띄우기
        Utils.toastLiveData.observe(this, Observer { resultTxt ->
            if (resultTxt != null) {
                Utils.showToast(this, resultTxt)
            }
        })
    }

    // 뒤로 가기 버튼 클릭 리스너
    private fun onBackListener() {
        // 두번 뒤로 가기 클릭 시 앱 종료
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // 메인 프래그먼트일 경우 뒤로가기 체크
                if(navController.currentDestination!!.id==R.id.mainFragment){
                    viewModel.checkBackPressed()
                }else{ // 아닐 경우 일반적인 뒤로가기 구현
                    navController.popBackStack()
                }
            }
        }

        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
    }
}