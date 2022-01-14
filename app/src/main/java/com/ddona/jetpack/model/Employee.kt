package com.ddona.jetpack.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val id: Int = 0,
    @ColumnInfo(name = "_name")
    val name: String = "",
    @ColumnInfo(name = "_account")
    val account: String = "",
    @ColumnInfo(name = "_address")
    val address: String = ""
)
