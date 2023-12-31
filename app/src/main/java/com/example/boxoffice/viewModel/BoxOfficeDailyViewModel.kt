package com.example.boxoffice.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boxoffice.api.model.BoxOfficeDailyItems
import com.example.boxoffice.repository.Repository
import kotlinx.coroutines.launch

class BoxOfficeDailyViewModel : ViewModel() {

    private val repository = Repository()

    private var items = MutableLiveData<BoxOfficeDailyItems>()
    val result: LiveData<BoxOfficeDailyItems>
        get() = items

    fun getList() = viewModelScope.launch {
        items.value = repository.getBoxOfficeDailyList()
    }
}