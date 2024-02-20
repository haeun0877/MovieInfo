package com.example.boxoffice.remote.model

import com.google.gson.annotations.SerializedName

data class BoxOfficeDailyItems(

    @SerializedName("boxOfficeResult")
    val boxOfficeResult: BoxOfficeResult
)