package com.example.boxoffice.remote.api

import com.example.boxoffice.remote.model.BoxOfficeDailyItems
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //일별 박스오피스
    @GET("searchDailyBoxOfficeList.json")
    suspend fun getBoxOfficeList(
        @Query("key") key: String,                 // 발급받은 키 값 (필수)
        @Query("targetDt") targetDt: String,       // 조회하고자 하는 날짜 yyyymmdd 형식 (필수)
        @Query("itemPerPage") itemPerPage: String, // 결과 ROW의 개수 지정 (default 10, 최대 10)
        @Query("repNationCd") repNationCd: String, // 한국/외국 영화별 조회 (K 한국영화, F 외국영화, defult 전체)
        @Query("wideAreaCd") wideAreaCd:String,    // 상영 지역별 조회 (default 전체)
        ) : BoxOfficeDailyItems
}