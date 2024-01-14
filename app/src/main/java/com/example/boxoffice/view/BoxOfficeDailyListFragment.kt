package com.example.boxoffice.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.boxoffice.R
import com.example.boxoffice.adapter.BoxOfficeDailyAdapter
import com.example.boxoffice.base.BaseFragment
import com.example.boxoffice.databinding.FragmentBoxOfficeDailyListBinding
import com.example.boxoffice.viewModel.BoxOfficeDailyViewModel

class BoxOfficeDailyListFragment : BaseFragment<FragmentBoxOfficeDailyListBinding>() {

    private lateinit var boxOfficeDailyAdapter: BoxOfficeDailyAdapter

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBoxOfficeDailyListBinding {
        return FragmentBoxOfficeDailyListBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[BoxOfficeDailyViewModel::class.java]
        viewModel.getList()


        //TODO: haeun-> onBackpressed 안쓰임 새로운거로 교체해야함
        binding.layoutTitle.ivBack.setOnClickListener {
            activity?.onBackPressed()
        }

        //TODO :haeun -> 제대로 Live Data 적용해야함 제대로 안된듯?
        boxOfficeDailyAdapter = BoxOfficeDailyAdapter()

        viewModel.result.observe(requireActivity(), Observer {
            var boxOfficeDailItem = it.boxOfficeResult
            var boxList = boxOfficeDailItem.dailyBoxOfficeList
            boxOfficeDailyAdapter.dailyBoxOffice = boxList.toMutableList()


            binding.rvBoxOfficeDaily.adapter = boxOfficeDailyAdapter
        })
    }

}