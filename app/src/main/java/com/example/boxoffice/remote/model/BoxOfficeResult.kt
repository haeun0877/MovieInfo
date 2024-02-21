package com.example.boxoffice.remote.model

import com.google.gson.annotations.SerializedName

data class BoxOfficeResult(

    val boxofficeType: String, //박스오피스 종류
    val dailyBoxOfficeList: List<DailyBoxOffice>,
    val showRange: String // 박스오피스 조회 일자
)