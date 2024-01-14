package com.example.boxoffice.repository

import com.example.boxoffice.utils.RetrofitClient

class BoxOfficeDailyListRepository {
    private val client = RetrofitClient.instance

    suspend fun getBoxOfficeDailyList() = client.getBoxOfficeList("f5eef3421c602c6cb7ea224104795888", "20120101")
}