package com.example.boxoffice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.boxoffice.R
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
        private val ivNumber : ImageView = binding.ivNumber

        fun bind(item: DailyBoxOffice){
            val openDate = item.openDt + " 개봉"
            tvTitle.text = item.movieNm
            tvOpenDate.text = openDate

            if(item.rankOldAndNew == "OLD"){
                tvNew.visibility = View.GONE
            }else{
                tvNew.visibility = View.VISIBLE
            }

            when(bindingAdapterPosition){
                0 -> ivNumber.setImageResource(R.drawable.number1)
                1 -> ivNumber.setImageResource(R.drawable.number2)
                2 -> ivNumber.setImageResource(R.drawable.number3)
                3 -> ivNumber.setImageResource(R.drawable.number4)
                4 -> ivNumber.setImageResource(R.drawable.number5)
                5 -> ivNumber.setImageResource(R.drawable.number6)
                6 -> ivNumber.setImageResource(R.drawable.number7)
                7 -> ivNumber.setImageResource(R.drawable.number8)
                8 -> ivNumber.setImageResource(R.drawable.number9)
                9 -> ivNumber.setImageResource(R.drawable.number10)
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