package com.ddona.jetpack.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class SubjectWithStudents(
    @Embedded
    val subject: Subject,

    @Relation(
        parentColumn = "subjectName",
        entityColumn = "id",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students: List<Student>
)