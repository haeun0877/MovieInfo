package com.example.boxoffice.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.boxoffice.R
import com.example.boxoffice.api.base.BaseActivity
import com.example.boxoffice.api.model.BoxOfficeDailyItems
import com.example.boxoffice.databinding.ActivityMainBinding
import com.example.boxoffice.viewModel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this

        //TODO : haeun setFragment() 함수 구현해야함
        val dailyFragment = BoxOfficeDailyListFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, dailyFragment)
        transaction.commit()
    }
}