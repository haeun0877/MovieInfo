package com.example.boxoffice.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.boxoffice.api.model.BoxOfficeDailyItems
import com.example.boxoffice.api.model.BoxOfficeResult
import com.example.boxoffice.api.model.DailyBoxOffice
import com.example.boxoffice.databinding.BoxOfficeDailyRowBinding

class BoxOfficeDailyAdapter() : RecyclerView.Adapter<BoxOfficeDailyAdapter.ViewHolder>() {

    var dailyBoxOffice = mutableListOf<DailyBoxOffice>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BoxOfficeDailyRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dailyBoxOffice.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dailyBoxOffice[position])
    }

    class ViewHolder(private val binding: BoxOfficeDailyRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(currentOffice: DailyBoxOffice){
                binding.tvTitle.text = currentOffice.movieNm
            }
    }
}