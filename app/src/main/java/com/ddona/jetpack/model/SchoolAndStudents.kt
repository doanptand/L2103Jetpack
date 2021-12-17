package com.ddona.jetpack.model

import androidx.room.Embedded
import androidx.room.Relation

data class SchoolAndStudents(
    @Embedded
    val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)
