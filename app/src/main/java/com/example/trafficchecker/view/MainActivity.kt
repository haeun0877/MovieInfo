package com.example.trafficchecker.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.trafficchecker.R
import com.example.trafficchecker.databinding.ActivityMainBinding
import com.example.trafficchecker.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityMainBinding
    private val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mBinding.lifecycleOwner = this
        mBinding.viewModel = model
    }
}