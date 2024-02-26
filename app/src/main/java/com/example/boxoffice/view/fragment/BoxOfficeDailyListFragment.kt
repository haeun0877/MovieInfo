package com.example.boxoffice.view.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.boxoffice.adapter.BoxOfficeDailyAdapter
import com.example.boxoffice.base.BaseFragment
import com.example.boxoffice.databinding.FragmentBoxOfficeDailyListBinding
import com.example.boxoffice.viewModel.BoxOfficeDailyViewModel
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BoxOfficeDailyListFragment : BaseFragment<FragmentBoxOfficeDailyListBinding>() {

    private val viewModel : BoxOfficeDailyViewModel by viewModels()
    private lateinit var boxOfficeDailyAdapter: BoxOfficeDailyAdapter

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBoxOfficeDailyListBinding {
        return FragmentBoxOfficeDailyListBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.layoutTitle.tvTitle.text = "일별 박스 오피스"

        binding.layoutTitle.ivBack.setOnClickListener {
            view.findNavController().popBackStack()
        }

        // 필터 탭
        initTabSetting()

        // 일별 박스 오피스 리스트
        boxOfficeDailyAdapter = BoxOfficeDailyAdapter()
        viewModel.getList("20240101")
        binding.rvBoxOfficeDaily.adapter = boxOfficeDailyAdapter

        viewModel.result.observe(requireActivity(), Observer {
            var boxOfficeDailItem = it.boxOfficeResult
            var boxList = boxOfficeDailItem.dailyBoxOfficeList
            boxOfficeDailyAdapter.submitList(boxList)
        })
    }

    private fun initTabSetting(){
        binding.tabBoxOfficeFilter.tabMode = TabLayout.MODE_SCROLLABLE
        binding.tabBoxOfficeFilter.setTabTextColors(Color.parseColor("#7b7f8f"), Color.parseColor("#FF6200EE"))

        binding.tabBoxOfficeFilter.addTab(binding.tabBoxOfficeFilter.newTab().setText(" 관객수 순 "))
        binding.tabBoxOfficeFilter.addTab(binding.tabBoxOfficeFilter.newTab().setText(" 개봉일 순 "))
        binding.tabBoxOfficeFilter.addTab(binding.tabBoxOfficeFilter.newTab().setText(" 매출액 순 "))
    }

}