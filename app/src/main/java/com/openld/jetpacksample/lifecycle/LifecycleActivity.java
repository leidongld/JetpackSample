package com.openld.jetpacksample.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.openld.jetpacksample.R;

/**
 * LifeCycle测试页
 */
public class LifecycleActivity extends AppCompatActivity {
    private ActivityLifecycleObserver mActivityLifeCycleObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        mActivityLifeCycleObserver = new ActivityLifecycleObserver(this);
        getLifecycle().addObserver(mActivityLifeCycleObserver);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 开始服务
     *
     * @param view 按钮
     */
    public void onClickButtonStartService(View view) {
        Intent intent = new Intent(LifecycleActivity.this, MyLifecycleService.class);
        startService(intent);
    }

    /**
     * 结束服务
     *
     * @param view 按钮
     */
    public void onClickButtonStopService(View view) {
        Intent intent = new Intent(LifecycleActivity.this, MyLifecycleService.class);
        stopService(intent);
    }
}