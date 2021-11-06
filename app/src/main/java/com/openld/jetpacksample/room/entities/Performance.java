package com.openld.jetpacksample.room.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

/**
 * author: lllddd
 * created on: 2021/10/31 21:23
 * description:
 */
@Entity(tableName = "performance")
public class Performance {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    public int id;

    @ColumnInfo(name = "studentId", typeAffinity = ColumnInfo.INTEGER)
    public int studentId;

    @ColumnInfo(name = "chinese", typeAffinity = ColumnInfo.INTEGER)
    public int chinese;

    @ColumnInfo(name = "maths", typeAffinity = ColumnInfo.INTEGER)
    public int maths;

    @ColumnInfo(name = "english", typeAffinity = ColumnInfo.INTEGER)
    public int english;

    @Ignore
    @ColumnInfo(name = "date", typeAffinity = ColumnInfo.TEXT)
    public Date date;

    public Performance(int id, int studentId, int chinese, int maths, int english) {
        this.id = id;
        this.studentId = studentId;
        this.chinese = chinese;
        this.maths = maths;
        this.english = english;
    }

    @NonNull
    @Override
    public String toString() {
        return "Performance{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", chinese=" + chinese +
                ", maths=" + maths +
                ", english=" + english +
                '}';
    }
}
