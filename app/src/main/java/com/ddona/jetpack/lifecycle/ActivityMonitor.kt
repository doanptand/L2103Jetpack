package com.ddona.jetpack.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.ddona.jetpack.util.Logger

class ActivityMonitor(private val lifecycle: Lifecycle) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun logOnCreate() {
        Logger.d("doanpt", "Activity OnCreated")
    }

    fun logAbc() {
        if(lifecycle.currentState.isAtLeast(Lifecycle.State.DESTROYED)) {

        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun logOnDestroy() {
        Logger.d("doanpt", "Activity OnDestroyed")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun logOnStart() {
        Logger.d("doanpt", "Activity OnStarted")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun logOnStop() {
        Logger.d("doanpt", "Activity OnStopped")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun logOnResume() {
        Logger.d("doanpt", "Activity OnResumed")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun logOnPaused() {
        Logger.d("doanpt", "Activity OnPaused")
    }
}