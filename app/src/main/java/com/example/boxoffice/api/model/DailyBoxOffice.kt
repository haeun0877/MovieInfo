package com.example.boxoffice.api.model

import com.google.gson.annotations.SerializedName

data class DailyBoxOffice(
    @SerializedName("audiAcc")
    val audiAcc: String, // 누적 관객수
    @SerializedName("audiChange")
    val audiChange: String, // 전일 대비 관객수 증감 비율
    @SerializedName("audiCnt")
    val audiCnt: String, // 해당일의 관객수
    @SerializedName("audiInten")
    val audiInten: String, // 전일 대비 관객수 증감분
    @SerializedName("movieCd")
    val movieCd: String, // 영화의 대표 코드
    @SerializedName("movieNm")
    val movieNm: String, // 영화명(국문)
    @SerializedName("openDt")
    val openDt: String, // 영화의 개봉일
    @SerializedName("rank")
    val rank: String, // 해당일자의 박스 오피스 순위
    @SerializedName("rankInten")
    val rankInten: String, // 전일대비 순위의 증감분
    @SerializedName("rankOldAndNew")
    val rankOldAndNew: String, // 랭킹에 신규 진입여부 ("OLD":기존, "NEW": 신규)
    @SerializedName("rnum")
    val rnum: String, // 순번
    @SerializedName("salesAcc")
    val salesAcc: String, // 누적매출액
    @SerializedName("salesAmt")
    val salesAmt: String, // 해당일의 매출액
    @SerializedName("salesChange")
    val salesChange: String, // 전일 대비 매출액 증감 비율
    @SerializedName("salesInten")
    val salesInten: String, // 전일 대비 매출액 증감분
    @SerializedName("salesShare")
    val salesShare: String, //해당일자 상역작의 매출총액 대비 해당 영화의 매출 비율
    @SerializedName("scrnCnt")
    val scrnCnt: String, // 해당일자에 상영한 스크린 수
    @SerializedName("showCnt")
    val showCnt: String // 해당일자에 상영된 횟수
)