package kk.mvvm

import android.security.identity.ResultData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kk.repository.MainRepository

class MainViewModel(private var repository: MainRepository): ViewModel() {

    val itemMutable = MutableLiveData<ResultData>()

    fun getDataResponse(count: String){
        repository.onCallApi(count)
    }

    val resultDataList : LiveData<List<kk.model.ResultData>>
        get() = repository.resultData
}