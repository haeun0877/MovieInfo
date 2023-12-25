package com.example.boxoffice.retrofit

import com.example.boxoffice.retrofit.dataClass.BoxOfficeItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitBoxOfficeList {

    @GET("searchDailyBoxOfficeList.json")
    fun getBoxOfficeList(
        @Query("key") key: String,
        @Query("targetDt") targetDt: String
        ) : Call<BoxOfficeItem>
}