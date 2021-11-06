package com.openld.jetpacksample.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

/**
 * author: lllddd
 * created on: 2021/11/1 14:52
 * description:计时器ViewModel
 * 这里必须是public否则在反射初始化的时候会报错
 * 这里也可以继承{@link ViewModel}，继承{@link AndroidViewModel}是因为他可以拿到Application的Context
 * 不要随便将Context或者引用Context的对象传入ViewModel，很容易造成内存泄漏
 */
public class TimerViewModel extends AndroidViewModel {
    // 计时器
    private Timer mTimer;

    // 当前秒数
    private int mCurrentSecond;

    // 时钟改变监听器
    private OnTimerChangedListener mOnTimerChangedListener;

    public TimerViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mTimer.cancel();
    }

    /**
     * 开始执行计时
     */
    public void startTiming() {
        if (mTimer == null) {
            mCurrentSecond = 0;
            mTimer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    mCurrentSecond++;
                    if (mOnTimerChangedListener != null) {
                        mOnTimerChangedListener.onTimerChanged(mCurrentSecond);
                    }
                }
            };
            mTimer.schedule(timerTask, 1000, 1000);
        }
    }

    /**
     * 设置时钟改变监听器
     *
     * @param listener 监听器
     */
    public void setOnTimerChangedListener(OnTimerChangedListener listener) {
        this.mOnTimerChangedListener = listener;
    }

    public interface OnTimerChangedListener {
        void onTimerChanged(int currentSecond);
    }
}
