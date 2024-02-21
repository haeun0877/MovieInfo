package com.example.boxoffice.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boxoffice.remote.model.BoxOfficeDailyItems
import com.example.boxoffice.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BoxOfficeDailyViewModel @Inject constructor(
    private val repository: Repository
    ): ViewModel() {

    private var items = MutableLiveData<BoxOfficeDailyItems>()
    val result: LiveData<BoxOfficeDailyItems>
        get() = items

    fun getList() = viewModelScope.launch {
        items.value = repository.getBoxOfficeDailyList()
    }
}