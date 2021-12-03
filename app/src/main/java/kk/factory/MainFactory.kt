package kk.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kk.mvvm.MainViewModel
import kk.repository.MainRepository

class MainFactory(private val mainRepository: MainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(mainRepository) as T
    }
}