package com.openld.jetpacksample.lifecycle;

import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleService;

/**
 * author: lllddd
 * created on: 2021/10/17 15:42
 * description:自定义的有生命周期观察功能的Service
 */
public class MyLifecycleService extends LifecycleService {
    private ServiceLifecycleObserver mServiceLifecycleObserver;

    public MyLifecycleService() {
        mServiceLifecycleObserver = new ServiceLifecycleObserver(this);
        getLifecycle().addObserver(mServiceLifecycleObserver);
    }

    @Nullable
    @Override
    public IBinder onBind(@NonNull Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
