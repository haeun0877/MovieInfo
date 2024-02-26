package com.example.boxoffice.utils.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.boxoffice.remote.model.DailyBoxOffice

object DailyBoxOfficeCallback : DiffUtil.ItemCallback<DailyBoxOffice>() {

    override fun areItemsTheSame(oldItem: DailyBoxOffice, newItem: DailyBoxOffice): Boolean {
        return oldItem.movieCd == newItem.movieCd
    }

    override fun areContentsTheSame(oldItem: DailyBoxOffice, newItem: DailyBoxOffice): Boolean {
        return oldItem == newItem
    }

}