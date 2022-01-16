package com.ddona.jetpack.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.ddona.jetpack.network.PassengerApi
import com.ddona.jetpack.network.PassengerDataSource

class PassengerViewModel(
    private val passengerApi: PassengerApi
) : ViewModel() {
    val passengers = Pager(
        PagingConfig(pageSize = 20)
    ) {
        PassengerDataSource(passengerApi)
    }.flow.cachedIn(viewModelScope)
}