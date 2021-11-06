package com.openld.jetpacksample.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * author: lllddd
 * created on: 2021/11/3 9:54
 * description:上传日志的Worker
 */
public class UploadLogWorker extends Worker {
    private static final String TAG = "UploadLogWorker";

    private final String mParam;

    public UploadLogWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        Data data = workerParams.getInputData();
        mParam = data.getString("param");
    }

    @NonNull
    @Override
    public Result doWork() {
        for (int i = 0; i < 100; i++) {
            Log.d(TAG,  mParam+ ">>> doWork " + i);
        }
        return Result.success();
    }
}
