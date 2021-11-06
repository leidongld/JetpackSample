package com.openld.jetpacksample.viewmodel;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.openld.jetpacksample.R;

/**
 * ViewModel测试页
 */
public class ViewModelActivity extends AppCompatActivity implements TimerViewModel.OnTimerChangedListener {
    private TextView mTxtCurrentSecond;

    private ViewModelProvider mViewModelProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);

        mViewModelProvider = new ViewModelProvider(this);

        initWidgets();

        TimerViewModel timerViewModel = mViewModelProvider.get(TimerViewModel.class);
        timerViewModel.setOnTimerChangedListener(this);
        timerViewModel.startTiming();
    }

    /**
     * 初始化控件
     */
    private void initWidgets() {
        mTxtCurrentSecond = findViewById(R.id.txt_current_second);
    }

    /*
     * 时钟改变监听器
     *
     * @param currentSecond 当前的秒数
     */
    @Override
    public void onTimerChanged(int currentSecond) {
        runOnUiThread(new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                mTxtCurrentSecond.setText(currentSecond + " s");
            }
        });
    }
}