package com.openld.jetpacksample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.openld.jetpacksample.lifecycle.LifecycleActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButtonLifeCycle(View view) {
        Intent intent = new Intent(MainActivity.this, LifecycleActivity.class);
        startActivity(intent);
    }
}