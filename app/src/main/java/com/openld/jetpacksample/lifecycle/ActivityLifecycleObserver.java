package com.openld.jetpacksample.lifecycle;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * author: lllddd
 * created on: 2021/10/17 15:18
 * description:Activity生命周期变化观察者
 */
public class ActivityLifecycleObserver implements LifecycleObserver {
    private final Context mContext;

    public ActivityLifecycleObserver(@NonNull Context context) {
        this.mContext = context;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void dealActivityOnCreate() {
        Toast.makeText(mContext, "观察到了onCreate", Toast.LENGTH_SHORT).show();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void dealActivityOnStart() {
        Toast.makeText(mContext, "观察到了onStart", Toast.LENGTH_SHORT).show();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void dealActivityOnResume() {
        Toast.makeText(mContext, "观察到了onResume", Toast.LENGTH_SHORT).show();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void dealActivityOnPause() {
        Toast.makeText(mContext, "观察到了onPause", Toast.LENGTH_SHORT).show();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void dealActivityOnStop() {
        Toast.makeText(mContext, "观察到了onStop", Toast.LENGTH_SHORT).show();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void dealActivityOnDestroy() {
        Toast.makeText(mContext, "观察到了onDestroy", Toast.LENGTH_SHORT).show();
    }
}
