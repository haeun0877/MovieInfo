package com.example.boxoffice.view.fragment

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
        viewModel.getList()

        binding.layoutTitle.ivBack.setOnClickListener {
            view.findNavController().popBackStack()
        }

        boxOfficeDailyAdapter = BoxOfficeDailyAdapter()

        viewModel.result.observe(requireActivity(), Observer {
            var boxOfficeDailItem = it.boxOfficeResult
            var boxList = boxOfficeDailItem.dailyBoxOfficeList
            boxOfficeDailyAdapter.dailyBoxOffice = boxList.toMutableList()


            binding.rvBoxOfficeDaily.adapter = boxOfficeDailyAdapter
        })
    }

}