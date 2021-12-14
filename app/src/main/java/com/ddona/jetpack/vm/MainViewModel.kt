package com.ddona.jetpack.vm

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ddona.jetpack.util.Event

class MainViewModel(private val application: Application) : ViewModel() {
    private var _number = MutableLiveData<Int>()
    val number: LiveData<Int>
        get() = _number

    private var _navigateToShare = MutableLiveData<Event<Boolean>>()
    val navigateToShare: LiveData<Event<Boolean>>
        get() = _navigateToShare

    init {
        Log.d("doanpt", "application: $application")
        _number.postValue(0)
    }

    fun increaseNumber() {
        //do something here
        _number.postValue(_number.value?.plus(1))
        Log.d("doanpt", "number: ${number.value}")
        //value change then start share
        _navigateToShare.postValue(Event(true))
    }
}
//class MainViewModel2(private val app: Application): AndroidViewModel(app) {
//}