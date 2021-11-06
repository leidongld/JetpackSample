package com.openld.jetpacksample.databinding;

/**
 * author: lllddd
 * created on: 2021/11/4 14:19
 * description:书
 */
public class Book {
    // 书名
    public String title;

    // 作者
    public String author;

    // 评分等级
    public int rating;

    public Book(String title, String author, int rating) {
        this.title = title;
        this.author = author;
        this.rating = rating;
    }
}
