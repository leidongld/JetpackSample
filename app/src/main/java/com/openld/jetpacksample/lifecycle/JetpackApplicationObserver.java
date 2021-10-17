package com.openld.jetpacksample.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * author: lllddd
 * created on: 2021/10/17 16:07
 * description:自定义Application的生命周期观察者
 */
public class JetpackApplicationObserver implements LifecycleObserver {
    private static final String TAG = JetpackApplicationObserver.class.getSimpleName();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onApplicationOnCreate() {
        Log.d(TAG, ">>> JetpackApplication onCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onApplicationOnStart() {
        Log.d(TAG, ">>> JetpackApplication onStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onApplicationOnResume() {
        Log.d(TAG, ">>> JetpackApplication onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onApplicationOnPause() {
        Log.d(TAG, ">>> JetpackApplication onPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onApplicationOnStop() {
        Log.d(TAG, ">>> JetpackApplication onStop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onApplicationOnDestroy() {
        // 这里永远不会执行
        Log.d(TAG, ">>> JetpackApplication onDestroy");
    }
}
