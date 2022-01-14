package com.ddona.jetpack.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ddona.jetpack.model.Employee
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Employee::class], version = 1, exportSchema = false)
abstract class EmployeeDatabase : RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao

    companion object {
        private var instance: EmployeeDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context, scope: CoroutineScope): EmployeeDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    ctx.applicationContext,
                    EmployeeDatabase::class.java,
                    "employee.db"
                )
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            scope.launch(Dispatchers.IO) {
                                insertFakeData(instance!!)
                            }
                        }

                        private suspend fun insertFakeData(instance: EmployeeDatabase) {
                            val employeeDao = instance.employeeDao()
                            for (i in 0..10000) {
                                employeeDao.insert(
                                    Employee(
                                        name = "Doan $i",
                                        account = "doanpt$i",
                                        address = "City $i"
                                    )
                                )
                            }
                        }
                    })
                    .build()
            }
            return instance!!
        }
    }

}