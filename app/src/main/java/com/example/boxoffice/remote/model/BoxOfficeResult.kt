package com.example.boxoffice.remote.model

import com.google.gson.annotations.SerializedName

data class BoxOfficeResult(

    @SerializedName("boxofficeType")
    val boxofficeType: String, //박스오피스 종류
    @SerializedName("dailyBoxOfficeList")
    val dailyBoxOfficeList: List<DailyBoxOffice>,
    @SerializedName("showRange")
    val showRange: String // 박스오피스 조회 일자
)