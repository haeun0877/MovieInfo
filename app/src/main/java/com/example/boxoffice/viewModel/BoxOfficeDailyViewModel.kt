package com.example.boxoffice.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boxoffice.remote.model.BoxOfficeDailyItems
import com.example.boxoffice.remote.model.DailyBoxOffice
import com.example.boxoffice.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Collections
import javax.inject.Inject

@HiltViewModel
class BoxOfficeDailyViewModel @Inject constructor(
    private val repository: Repository
    ): ViewModel() {

    private var items = MutableLiveData<List<DailyBoxOffice>?>()
    val result: MutableLiveData<List<DailyBoxOffice>?>
        get() = items

    fun getList(targetDt: String) = viewModelScope.launch {
        items.value = repository.getBoxOfficeDailyList(targetDt).boxOfficeResult.dailyBoxOfficeList
    }

    fun setListSorting(type : Int){
        val list = items.value

        if (list != null) {
            Collections.sort(list
            ) { o1, o2 ->
                var valueA = ""
                var valueB = ""

                try {
                    if (type == 0) { // 관객수 순
                        valueA = o1?.audiAcc.toString()
                        valueB = o2?.audiAcc.toString()
                    } else if (type == 1) { // 개봉일 순
                        valueA = o1?.openDt.toString()
                        valueB = o2?.openDt.toString()
                    } else { // 매출액 순
                        valueA = o1?.salesAcc.toString()
                        valueB = o2?.salesAcc.toString()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }

                valueA.compareTo(valueB)
            }
            items.value = list

        }
    }
}