package com.simonojok19.techman;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Student student);

    @Query("DELETE FROM student_table")
    void deleteStudents();

    @Query("SELECT * FROM student_table ORDER BY id ASC")
    List<Student> getStudents();
}
