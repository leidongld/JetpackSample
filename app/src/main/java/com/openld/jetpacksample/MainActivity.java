package com.openld.jetpacksample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.openld.jetpacksample.databinding.DataBindingActivity;
import com.openld.jetpacksample.lifecycle.LifecycleActivity;
import com.openld.jetpacksample.livedata.LiveDataActivity;
import com.openld.jetpacksample.navigation.NavigationActivity;
import com.openld.jetpacksample.room.RoomActivity;
import com.openld.jetpacksample.viewmodel.ViewModelActivity;
import com.openld.jetpacksample.workmanager.WorkManagerActivity;

/**
 * author: lllddd
 * created on: 2021/10/28 15:36
 * description:主页面
 */
public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 点击测试LifeCycle
     *
     * @param view
     */
    public void onClickButtonLifeCycle(View view) {
        Intent intent = new Intent(MainActivity.this, LifecycleActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    /**
     * 点击测试Navigation
     *
     * @param view
     */
    public void onClickButtonNavigation(View view) {
        Intent intent = new Intent(MainActivity.this, NavigationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    /**
     * 点击测试Room
     *
     * @param view
     */
    public void onClickButtonRoom(View view) {
        Intent intent = new Intent(MainActivity.this, RoomActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    /**
     * 点击测试ViewModel
     *
     * @param view
     */
    public void onClickButtonViewModel(View view) {
        Intent intent = new Intent(MainActivity.this, ViewModelActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    /**
     * 点击测试LiveData
     *
     * @param view
     */
    public void onClickButtonLiveData(View view) {
        Intent intent = new Intent(MainActivity.this, LiveDataActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    /**
     * 点击测试WorkManager
     *
     * @param view
     */
    public void onClickButtonWorkManager(View view) {
        Intent intent = new Intent(MainActivity.this, WorkManagerActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    /**
     * 点击测试WorkManager
     *
     * @param view
     */
    public void onClickButtonDataBinding(View view) {
        Intent intent = new Intent(MainActivity.this, DataBindingActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}
