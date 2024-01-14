package com.example.boxoffice.view.activity

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import com.example.boxoffice.R
import com.example.boxoffice.base.BaseActivity
import com.example.boxoffice.databinding.ActivityMainBinding
import com.example.boxoffice.view.fragment.BoxOfficeDailyListFragment
import com.example.boxoffice.viewModel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this


        val dailyFragment = BoxOfficeDailyListFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, dailyFragment)
        transaction.commit()

        // 뒤로 가기 클릭 시 이벤트 구현
        onBackListener()
        // 뒤로 가기 두번 클릭 시 앱 종료
        viewModel.finishCheck.observe(this) { value ->
            if (value) {
                finish()
            }
        }
    }

    // 뒤로 가기 버튼 클릭 리스너
    private fun onBackListener() {

        // 두번 뒤로 가기 클릭 시 앱 종료
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                viewModel.checkBackPressed(this@MainActivity)
            }
        }

        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
    }
}