package com.openld.jetpacksample;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.ProcessLifecycleOwner;

import com.openld.jetpacksample.lifecycle.JetpackApplicationObserver;

/**
 * author: lllddd
 * created on: 2021/10/17 15:14
 * description:自定义Application
 */
public class JetpackApplication extends Application {
    private static Context mApplicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext = getApplicationContext();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new JetpackApplicationObserver());
    }

    /**
     * 获取应用的Context
     *
     * @return 应用的Context
     */
    public static Context getContext() {
        return mApplicationContext;
    }
}
