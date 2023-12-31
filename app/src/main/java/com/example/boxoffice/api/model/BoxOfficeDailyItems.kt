package com.example.boxoffice.api.model

import com.google.gson.annotations.SerializedName

data class BoxOfficeDailyItems(

    @SerializedName("boxOfficeResult")
    val boxOfficeResult: BoxOfficeResult
)