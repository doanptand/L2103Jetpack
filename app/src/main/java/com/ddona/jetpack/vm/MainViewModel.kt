package com.ddona.jetpack.vm

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ddona.jetpack.util.Event
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel(private val application: Application) : ViewModel() {
    private var _number = MutableLiveData<Int>()
    val number: LiveData<Int>
        get() = _number

    private var _navigateToShare = MutableLiveData<Event<Boolean>>()
    val navigateToShare: LiveData<Event<Boolean>>
        get() = _navigateToShare

    private val _needToast = MutableLiveData<Boolean>()
    val needToast: LiveData<Boolean>
        get() = _needToast

    private val _nextActivity = MutableLiveData<Boolean>()
    val nextActivity: LiveData<Boolean>
        get() = _nextActivity


    private val _showToastChannel = Channel<Boolean>()
    val showToastChannel = _showToastChannel.receiveAsFlow()


    init {
        Log.d("doanpt", "application: $application")
        _number.postValue(0)
    }

    fun showToast() {
//        _needToast.postValue(true)
        viewModelScope.launch {
            _showToastChannel.send(true)
        }
    }

    fun nextActivity() {
        _nextActivity.postValue(true)
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