package com.ddona.jetpack.di

import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class GoogleAnalyzer


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class FirebaseAnalyzer