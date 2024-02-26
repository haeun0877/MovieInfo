package com.example.boxoffice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.boxoffice.remote.model.DailyBoxOffice
import com.example.boxoffice.databinding.BoxOfficeDailyRowBinding
import com.example.boxoffice.utils.diffUtils.DailyBoxOfficeCallback

class BoxOfficeDailyAdapter() : ListAdapter<DailyBoxOffice, BoxOfficeDailyAdapter.BoxOfficeDailyViewHolder>(
    DailyBoxOfficeCallback
) {

    class BoxOfficeDailyViewHolder(binding: BoxOfficeDailyRowBinding) : RecyclerView.ViewHolder(binding.root) {
        private val tvTitle : TextView = binding.tvTitle
        private val tvOpenDate : TextView = binding.tvOpenDate
        private val tvNew : TextView = binding.tvNew

        fun bind(item: DailyBoxOffice){
            val openDate = item.openDt + " 개봉"
            tvTitle.text = item.movieNm
            tvOpenDate.text = openDate

            if(item.rankOldAndNew == "OLD"){
                tvNew.visibility = View.GONE
            }else{
                tvNew.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BoxOfficeDailyViewHolder {
        val binding = BoxOfficeDailyRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BoxOfficeDailyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BoxOfficeDailyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}