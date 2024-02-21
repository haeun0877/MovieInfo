package com.example.boxoffice.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.boxoffice.R
import com.example.boxoffice.adapter.BoxOfficeDailyAdapter
import com.example.boxoffice.base.BaseFragment
import com.example.boxoffice.databinding.FragmentBoxOfficeDailyListBinding
import com.example.boxoffice.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.clDailyBoxoffice.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_main_to_daily)
        }
    }
}