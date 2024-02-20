package com.example.boxoffice.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.boxoffice.R
import com.example.boxoffice.base.BaseFragment
import com.example.boxoffice.databinding.FragmentBoxDailyViewBinding

class BoxDailyViewFragment : BaseFragment<FragmentBoxDailyViewBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBoxDailyViewBinding {
        return FragmentBoxDailyViewBinding.inflate(inflater, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}