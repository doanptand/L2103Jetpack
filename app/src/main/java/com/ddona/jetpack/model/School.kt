package com.ddona.jetpack.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "school")
data class School(
    @PrimaryKey(autoGenerate = false)
    val schoolName: String
)