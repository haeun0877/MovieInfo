package com.example.boxoffice.utils.diffUtils

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.example.boxoffice.remote.model.DailyBoxOffice

object DailyBoxOfficeCallback : DiffUtil.ItemCallback<DailyBoxOffice>() {

    override fun areItemsTheSame(oldItem: DailyBoxOffice, newItem: DailyBoxOffice): Boolean {
        Log.e("haeun","1")
        return oldItem.movieCd == newItem.movieCd
    }

    override fun areContentsTheSame(oldItem: DailyBoxOffice, newItem: DailyBoxOffice): Boolean {
        Log.e("haeun","2")
        return oldItem == newItem
    }

}