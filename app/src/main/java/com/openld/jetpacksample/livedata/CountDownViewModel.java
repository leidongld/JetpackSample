package com.openld.jetpacksample.livedata;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.Timer;
import java.util.TimerTask;

/**
 * author: lllddd
 * created on: 2021/11/1 16:10
 * description:倒计时ViewModel
 */
public class CountDownViewModel extends AndroidViewModel {
    private Timer mTimer;

    private MutableLiveData<Integer> mRemindSecond;

    public MutableLiveData<Integer> getRemindSecond() {
        if (mRemindSecond == null) {
            mRemindSecond = new MutableLiveData<>();
        }
        return mRemindSecond;
    }

    public CountDownViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mRemindSecond = null;
    }

    /**
     * 开始执行倒计时
     */
    public void startCounting() {
        if (mTimer == null) {
            mTimer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    if (mRemindSecond != null) {
                        mRemindSecond.postValue(mRemindSecond.getValue() - 1);
                    }
                }
            };
            mTimer.schedule(timerTask, 1000, 1000);
        }
    }
}
