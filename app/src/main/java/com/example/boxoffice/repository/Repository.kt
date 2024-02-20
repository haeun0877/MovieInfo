package com.example.boxoffice.repository

import com.example.boxoffice.remote.api.ApiService
import javax.inject.Inject


class Repository @Inject constructor(
    private val apiService: ApiService
){
    suspend fun getBoxOfficeDailyList() = apiService.getBoxOfficeList("f5eef3421c602c6cb7ea224104795888", "20120101")
}