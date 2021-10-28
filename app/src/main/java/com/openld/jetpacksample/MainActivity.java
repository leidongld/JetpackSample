package com.openld.jetpacksample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.openld.jetpacksample.lifecycle.LifecycleActivity;
import com.openld.jetpacksample.navigation.NavigationActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    /**
     * 点击测试Navigation
     *
     * @param view
     */
    public void onClickButtonNavigation(View view) {
        Intent intent = new Intent(MainActivity.this, NavigationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}