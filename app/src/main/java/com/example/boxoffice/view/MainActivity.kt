package com.example.boxoffice.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.boxoffice.R
import com.example.boxoffice.retrofit.RetrofitClient
import com.example.boxoffice.retrofit.dataClass.BoxOfficeItem
import com.example.boxoffice.databinding.ActivityMainBinding
import com.example.boxoffice.viewModel.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityMainBinding
    private val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mBinding.lifecycleOwner = this
        mBinding.viewModel = model

        RetrofitClient.instance.getBoxOfficeList("f5eef3421c602c6cb7ea224104795888", "20120101")
            .enqueue(object: Callback<BoxOfficeItem>{
                override fun onResponse(
                    call: Call<BoxOfficeItem>,
                    response: Response<BoxOfficeItem>
                ) {
                    Log.e("haeun", "response: ${response.toString()}")
                }

                override fun onFailure(call: Call<BoxOfficeItem>, t: Throwable) {
                    Log.e("haeun", "e: ${t.message}")
                }

            })

    }
}