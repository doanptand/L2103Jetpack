package com.ddona.jetpack.vm

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MusicViewModel : ViewModel() {

    private val _number = MutableLiveData<Int>()
    val number: LiveData<Int>
        get() = _number


    var message = MutableLiveData<String>()

    init {
        _number.postValue(0)
    }

    fun logData(view: View) {
        Log.d("doanpt", "The new message is:${message.value}")
    }

    fun increaseNumber() {
        _number.postValue(_number.value?.plus(1))
    }

}