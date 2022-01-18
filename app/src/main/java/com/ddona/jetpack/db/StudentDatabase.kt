package com.ddona.jetpack.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ddona.jetpack.model.*

@Database(entities = [
    Student::class,
    School::class,
    Subject::class,
    Director::class,
    StudentSubjectCrossRef::class], exportSchema = false, version = 1)
abstract class StudentDatabase : RoomDatabase() {

    abstract fun getStudentDao(): StudentDao

//    companion object {
//
//        private var instance: StudentDatabase? = null
//
//        @Synchronized
//        fun getInstance(context: Context): StudentDatabase {
//            if (instance == null) {
//                instance = Room.databaseBuilder(
//                    context,
//                    StudentDatabase::class.java,
//                    "student.db"
//                )
//                    .build()
//            }
//            return instance!!
//        }
//    }

//    companion object {
//        @Volatile
//        private var instance: StudentDatabase? = null
//
//        fun getInstance(context: Context): StudentDatabase = instance ?: synchronized(this) {
//            Room.databaseBuilder(
//                context,
//                StudentDatabase::class.java,
//                "student.db"
//            ).fallbackToDestructiveMigration()
//                .build()
//        }
//    }
}