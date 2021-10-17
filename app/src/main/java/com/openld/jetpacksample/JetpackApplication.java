package com.openld.jetpacksample;

import android.app.Application;

import androidx.lifecycle.ProcessLifecycleOwner;

import com.openld.jetpacksample.lifecycle.JetpackApplicationObserver;

/**
 * author: lllddd
 * created on: 2021/10/17 15:14
 * description:自定义Application
 */
public class JetpackApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new JetpackApplicationObserver());
    }
}
