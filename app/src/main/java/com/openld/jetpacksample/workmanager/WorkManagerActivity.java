package com.openld.jetpacksample.workmanager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.openld.jetpacksample.R;

import java.util.concurrent.TimeUnit;

/**
 * WorkManager测试页
 */
public class WorkManagerActivity extends AppCompatActivity {
    private TextView mTxtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_manager);

        initWidgets();
    }

    private void initWidgets() {
        mTxtInfo = findViewById(R.id.txt_info);
        mTxtInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTxtInfo.setText(null);
            }
        });
    }

    /**
     * 点击了执行单次Worker按钮
     *
     * @param view
     */
    public void onClickButtonExecuteOneTime(View view) {
        Constraints constraints = new Constraints.Builder()
                .setRequiresCharging(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .build();

        Data data = new Data.Builder()
                .putString("param", "This is one time upload log worker's param.")
                .build();

        OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(UploadLogWorker.class)
                .setConstraints(constraints)
                .setInitialDelay(10, TimeUnit.SECONDS)
                .addTag("uploadLogWorkerOneTime")
                .setInputData(data)
                .build();

        WorkManager.getInstance(WorkManagerActivity.this).enqueue(oneTimeWorkRequest);

        WorkManager.getInstance(WorkManagerActivity.this)
                .getWorkInfoByIdLiveData(oneTimeWorkRequest.getId())
                .observe(WorkManagerActivity.this, new Observer<WorkInfo>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onChanged(WorkInfo workInfo) {
                        mTxtInfo.setText("onChanged() -> \nworkInfo : " + workInfo);
                    }
                });
    }

    /**
     * 点击了取消单次Worker按钮
     *
     * @param view
     */
    public void onClickButtonCancelOneTime(View view) {
        WorkManager.getInstance(WorkManagerActivity.this).cancelAllWorkByTag("uploadLogWorkerOneTime");
    }

    /**
     * 点击了执行周期Worker按钮
     *
     * @param view
     */
    public void onClickButtonExecutePeriod(View view) {
        Constraints constraints = new Constraints.Builder()
                .setRequiresCharging(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .build();

        Data data = new Data.Builder()
                .putString("param", "This is period upload log worker's param.")
                .build();

        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(UploadLogWorker.class, 60, TimeUnit.SECONDS)
                .setConstraints(constraints)
                .addTag("uploadLogWorkerPeriod")
                .setInputData(data)
                .build();

        WorkManager.getInstance(WorkManagerActivity.this).enqueue(periodicWorkRequest);

        WorkManager.getInstance(WorkManagerActivity.this)
                .getWorkInfoByIdLiveData(periodicWorkRequest.getId())
                .observe(WorkManagerActivity.this, new Observer<WorkInfo>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onChanged(WorkInfo workInfo) {
                        mTxtInfo.setText("onChanged() -> \nworkInfo : " + workInfo);
                    }
                });
    }

    /**
     * 点击了取消周期Worker按钮
     *
     * @param view
     */
    public void onClickCButtonCancelPeriod(View view) {
        WorkManager.getInstance(WorkManagerActivity.this).cancelAllWorkByTag("uploadLogWorkerPeriod");
    }
}