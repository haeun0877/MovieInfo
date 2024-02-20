package com.example.boxoffice.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.github.demono.adapter.InfinitePagerAdapter
import org.json.JSONArray

class BannerViewPagerAdapter : InfinitePagerAdapter() {

    private lateinit var bannerItem : JSONArray

    override fun getItemCount(): Int {
        return bannerItem.length()
    }

    override fun getItemView(position: Int, convertView: View?, container: ViewGroup?): View {


        return convertView!!.rootView
    }
}