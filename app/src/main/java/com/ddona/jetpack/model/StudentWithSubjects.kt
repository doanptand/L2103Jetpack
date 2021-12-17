package com.ddona.jetpack.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class StudentWithSubjects(
    @Embedded
    val student: Student,
    @Relation(
        parentColumn = "id",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)
