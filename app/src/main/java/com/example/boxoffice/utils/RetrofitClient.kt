package com.example.boxoffice.utils

import com.example.boxoffice.remote.api.RetrofitBoxOfficeList
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val gson : Gson = GsonBuilder()
        .setLenient()
        .create()

    val instance : RetrofitBoxOfficeList by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
//            .addConverterFactory(ScalarsConverterFactory.create())
//            .addConverterFactory(TikXmlConverterFactory.create(TikXml.Builder().exceptionOnUnreadXml(false).build()))
            .build()
        retrofit.create(RetrofitBoxOfficeList::class.java)
    }
}