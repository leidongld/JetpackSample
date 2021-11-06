package com.openld.jetpacksample.databinding;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;

/**
 * author: lllddd
 * created on: 2021/11/4 14:34
 * description:
 */
public class BookInfoBinding extends ViewDataBinding {
    protected BookInfoBinding(DataBindingComponent bindingComponent, View root, int localFieldCount) {
        super(bindingComponent, root, localFieldCount);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object value) {
        return false;
    }

    @Override
    protected void executeBindings() {

    }

    @Override
    public void invalidateAll() {

    }

    @Override
    public boolean hasPendingBindings() {
        return false;
    }
}
