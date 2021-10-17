package com.openld.jetpacksample.lifecycle;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * author: lllddd
 * created on: 2021/10/17 15:45
 * description:Service生命周期的观察者
 */
public class ServiceLifecycleObserver implements LifecycleObserver {
    private final Context mContext;

    private static final String TAG = ServiceLifecycleObserver.class.getSimpleName();

    public ServiceLifecycleObserver(@Nullable Context context) {
        this.mContext = context;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void startLocation() {
        Toast.makeText(mContext, ">>> startLocation", Toast.LENGTH_SHORT).show();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void stopLocation() {
        Toast.makeText(mContext, ">>> stopLocation", Toast.LENGTH_SHORT).show();
    }
}
