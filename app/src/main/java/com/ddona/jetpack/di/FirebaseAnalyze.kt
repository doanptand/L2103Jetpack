package com.ddona.jetpack.di

import android.util.Log
import com.ddona.jetpack.analyze.AnalyticsService
import javax.inject.Inject

class FirebaseAnalyze @Inject constructor() : AnalyticsService {
    override fun analyzeMethod() {
        Log.d("doanpt", "using firebase analyze")
    }
}