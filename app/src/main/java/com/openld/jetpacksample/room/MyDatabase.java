package com.openld.jetpacksample.room;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.openld.jetpacksample.JetpackApplication;
import com.openld.jetpacksample.room.daos.PerformanceDao;
import com.openld.jetpacksample.room.daos.StudentDao;
import com.openld.jetpacksample.room.entities.Performance;
import com.openld.jetpacksample.room.entities.Student;

/**
 * author: lllddd
 * created on: 2021/10/31 21:22
 * description:我的数据库
 */
@Database(entities = {Student.class, Performance.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    private static final String DB_NAME = "my_db";

    private static MyDatabase mMyDatabase;

    public abstract StudentDao studentDao();
    public abstract PerformanceDao performanceDao();

    public static synchronized MyDatabase getInstance() {
        if (mMyDatabase == null) {
            mMyDatabase = Room.databaseBuilder(JetpackApplication.getContext(), MyDatabase.class, DB_NAME)
                    .build();
        }
        return mMyDatabase;
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {
        // TODO: 2021/11/1 如何清除所有的表
    }
}
