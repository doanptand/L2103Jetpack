package com.ddona.jetpack.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class Task(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_task_id")
    var id: Int = 0,
    @ColumnInfo(name = "_task_name")
    var name: String = "",
    @ColumnInfo(name = "_task_description")
    var description: String = "",
    @ColumnInfo(name = "_task_deadline")
    var deadline: Long = 0,
    @Ignore
    var remind: String = "",
)
