package com.ddona.jetpack.model

import androidx.room.Entity

@Entity(tableName = "_student_subject", primaryKeys = ["id", "subjectName"])
data class StudentSubjectCrossRef(
    val id: String,
    val subjectName: String,
)
