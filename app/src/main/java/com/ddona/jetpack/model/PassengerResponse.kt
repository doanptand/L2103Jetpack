package com.ddona.jetpack.model

data class PassengerResponse(
    val data: List<Passenger>,
    val totalPages: Int,
    val totalPassengers: Int
)