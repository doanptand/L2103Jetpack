package com.ddona.jetpack.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "director")
data class Director(
    @PrimaryKey(autoGenerate = false)
    var directorName: String,
    var schoolName: String
)
