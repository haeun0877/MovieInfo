package com.example.boxoffice.view.fragment

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
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

    private val filterArr : ArrayList<String> = arrayListOf(" 관객수 순 ", " 개봉일 순 ", " 매출액 순 ")

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

        // 리스트 스켈레톤 UI
        binding.sflBackground.startShimmer()

        // 일별 박스 오피스 리스트
        boxOfficeDailyAdapter = BoxOfficeDailyAdapter()
        viewModel.getList("20240101")
        binding.rvBoxOfficeDaily.adapter = boxOfficeDailyAdapter

        viewModel.result.observe(viewLifecycleOwner, Observer {
            boxOfficeDailyAdapter.submitList(it)

            binding.sflBackground.stopShimmer()
            binding.sflBackground.visibility = View.GONE
            Log.e("haeun","observe $it")
        })
    }

    // 필터 탭 설정
    private fun initTabSetting(){
        binding.tabBoxOfficeFilter.tabMode = TabLayout.MODE_SCROLLABLE
        binding.tabBoxOfficeFilter.setTabTextColors(Color.parseColor("#7b7f8f"), Color.parseColor("#FF6200EE"))

//        for(strTab in filterArr){
//            binding.tabBoxOfficeFilter.addTab(binding.tabBoxOfficeFilter.newTab().setText(strTab))
//        }

        val viewGroup : ViewGroup = binding.tabBoxOfficeFilter.getChildAt(0) as ViewGroup
        for(i in 0 until filterArr.size){
            binding.tabBoxOfficeFilter.addTab(binding.tabBoxOfficeFilter.newTab().setText(filterArr[i]))

            val view : View = viewGroup.getChildAt(i)
            val params : ViewGroup.MarginLayoutParams = view.layoutParams as ViewGroup.MarginLayoutParams

            if(i == 0){
                params.setMargins(30, 0, 10, 0)
            }else if(i == filterArr.size-1){
                params.setMargins(0, 0, 30, 0)
            }else{
                params.setMargins(0, 0, 10, 0)
            }

            // 필터 적용 및 리프레시
            view.setOnClickListener {
                viewModel.setListSorting(i)
            }
        }

    }

}