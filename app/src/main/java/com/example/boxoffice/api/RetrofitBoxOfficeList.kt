package com.example.boxoffice.api

import com.example.boxoffice.api.model.BoxOfficeDailyItems
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitBoxOfficeList {

    @GET("searchDailyBoxOfficeList.json")
    suspend fun getBoxOfficeList(
        @Query("key") key: String,
        @Query("targetDt") targetDt: String
        ) : BoxOfficeDailyItems
}