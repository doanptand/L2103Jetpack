package com.ddona.jetpack.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ddona.jetpack.model.Student

@Database(entities = [Student::class], exportSchema = false, version = 1)
abstract class StudentDatabase : RoomDatabase() {

    abstract fun getStudentDao(): StudentDao

    companion object {
        private var instance: StudentDatabase? = null

        fun getInstance(context: Context): StudentDatabase = instance ?: synchronized(this) {
            Room.databaseBuilder(
                context,
                StudentDatabase::class.java,
                "student.db"
            ).build()
        }
    }
}