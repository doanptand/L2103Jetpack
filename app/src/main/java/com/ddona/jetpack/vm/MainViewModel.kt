package com.ddona.jetpack.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {
    private var _number = MutableLiveData<Int>()
    val number: LiveData<Int>
        get() = _number

    init {
        _number.postValue(0)
    }

    fun increaseNumber() {
        _number.postValue(_number.value?.plus(1))
        Log.d("doanpt", "number: ${number.value}")
    }
}
//class MainViewModel2(private val app: Application): AndroidViewModel(app) {
//}