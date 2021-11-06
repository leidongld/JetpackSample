package com.openld.jetpacksample.room.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.openld.jetpacksample.room.entities.Student;

import java.util.List;

/**
 * author: lllddd
 * created on: 2021/10/31 21:16
 * description:学生的Dao
 */
@Dao
public interface StudentDao {
    /**
     * 增加学生
     *
     * @param student 学生
     */
    @Insert
    public void insertStudent(Student student);

    /**
     * 删除学生
     *
     * @param student 学生
     */
    @Delete
    public void deleteStudent(Student student);

    /**
     * 更新学生
     *
     * @param student 学生
     */
    @Update
    public void updateStudent(Student student);

    /**
     * 查找学生
     *
     * @return 学生列表
     */
    @Query("SELECT * FROM student")
    public List<Student> queryStudent();

    /**
     * 根据id查找学生
     *
     * @param id 学生id
     * @return 对应学生
     */
    @Query("SELECT * FROM student WHERE id = :id")
    public Student queryStudentById(int id);
}

