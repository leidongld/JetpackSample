package com.openld.jetpacksample.room.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.openld.jetpacksample.room.entities.Performance;

import java.util.List;

/**
 * author: lllddd
 * created on: 2021/10/31 21:29
 * description:表现
 */
@Dao
public interface PerformanceDao {
    /**
     * 新增一条表现
     *
     * @param performance 表现
     */
    @Insert
    public void insertPerformance(Performance performance);

    /**
     * 删除一条表现
     *
     * @param performance 表现
     */
    @Delete
    public void deletePerformance(Performance performance);

    /**
     * 根据studentId查找表现
     *
     * @param studentId 学生id
     * @return 表现列表
     */
    @Query("SELECT * FROM performance WHERE studentId = :studentId")
    public List<Performance> queryPerformanceByStudentId(int studentId);
}
