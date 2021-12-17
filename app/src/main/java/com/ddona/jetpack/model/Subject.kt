package com.ddona.jetpack.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subject")
data class Subject(
    @PrimaryKey(autoGenerate = false)
    val subjectName: String,
    //define more columns.
)
