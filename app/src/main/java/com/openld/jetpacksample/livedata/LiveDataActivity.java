package com.openld.jetpacksample.livedata;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.openld.jetpacksample.R;

/**
 * LiveData测试页
 */
public class LiveDataActivity extends AppCompatActivity {
    private TextView mTxtCurrentSecond;

    private MutableLiveData<Integer> mRemindSecond;

    private final Observer<Integer> mForeverObserver = new Observer<Integer>() {
        @Override
        public void onChanged(Integer remindSecond) {
            Toast.makeText(LiveDataActivity.this, remindSecond + " s", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        initWidgets();

        ViewModelProvider viewModelProvider = new ViewModelProvider(this);

        CountDownViewModel countDownViewModel = viewModelProvider.get(CountDownViewModel.class);
        mRemindSecond = countDownViewModel.getRemindSecond();
        mRemindSecond.setValue(1000);
        mRemindSecond.observe(this, new Observer<Integer>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onChanged(Integer remindSecond) {
                mTxtCurrentSecond.setText(remindSecond + " s");
            }
        });
        mRemindSecond.observeForever(mForeverObserver);
        countDownViewModel.startCounting();
    }

    /**
     * 初始化控件
     */
    private void initWidgets() {
        mTxtCurrentSecond = findViewById(R.id.txt_current_second);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRemindSecond.removeObserver(mForeverObserver);
    }
}