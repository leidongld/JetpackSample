package com.openld.jetpacksample.databinding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.openld.jetpacksample.R;

/**
 * DataBinding测试页
 */
public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBindingBinding activityDataBindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);

        Book book = new Book("《Android Jetpack应用指南》", "叶坤", 5);

//        activityDataBindingBinding.txtTitle.setText(book.title);
//        activityDataBindingBinding.txtAuthor.setText(book.author);
//        activityDataBindingBinding.txtRating.setText(BookRatingUtil.getBookRatingStr(book.rating));
        activityDataBindingBinding.setBook(book);
        activityDataBindingBinding.setButtonClickHandler(new ButtonClickHandler(this));
    }
}