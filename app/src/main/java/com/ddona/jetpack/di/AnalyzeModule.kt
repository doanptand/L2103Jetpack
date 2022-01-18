package com.ddona.jetpack.di

import com.ddona.jetpack.analyze.AnalyticsService
import com.ddona.jetpack.analyze.GoogleAnalyze
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AnalyzeModule {

    @Binds
    @GoogleAnalyzer
    abstract fun bindGoogleAnalyze(googleAnalyze: GoogleAnalyze): AnalyticsService

    @Binds
    @FirebaseAnalyzer
    abstract fun bindFirebaseAnalyze(firebaseAnalyze: FirebaseAnalyze): AnalyticsService
}