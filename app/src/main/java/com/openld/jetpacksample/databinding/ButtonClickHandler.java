package com.openld.jetpacksample.databinding;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * author: lllddd
 * created on: 2021/11/4 14:47
 * description:时间处理监听器
 */
public class ButtonClickHandler {
    private final Context context;

    public ButtonClickHandler(Context context) {
        this.context = context;
    }

    public void onButtonClicked(View view) {
        Toast.makeText(context, "点击了按钮，欧耶", Toast.LENGTH_SHORT).show();
    }
}
