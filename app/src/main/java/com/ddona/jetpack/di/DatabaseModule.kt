package com.ddona.jetpack.di

import android.app.Application
import androidx.room.Room
import com.ddona.jetpack.db.StudentDao
import com.ddona.jetpack.db.StudentDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideStudentDB(app: Application): StudentDatabase {
        return Room.databaseBuilder(
            app.applicationContext,
            StudentDatabase::class.java,
            "student.db"
        ).build()
    }


    @Provides
    @Singleton
    fun provideStudentDao(db: StudentDatabase): StudentDao {
        return db.getStudentDao()
    }
}