package com.ddona.jetpack.analyze

import android.util.Log
import javax.inject.Inject

class GoogleAnalyze @Inject constructor() : AnalyticsService {
    override fun analyzeMethod() {
        Log.d("doanpt", "using google analyze")
    }
}