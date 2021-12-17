package com.ddona.jetpack.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class Student(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    var id: Int = 0,
    @ColumnInfo(name = "_name")
    var name: String = "",
    @ColumnInfo(name = "_age")
    var age: Int = 0,
    @ColumnInfo(name = "_class_name")
    var className: String = "",
    var schoolName: String = ""
)
