package com.example.think_it.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.think_it.entity.user;

import java.util.List;

@Dao
public interface userDao {

    @Query("SELECT * FROM user")
    List<user> getAll();

    @Insert
    void insert(user user);

    @Delete
    void delete(user user);

    @Update
    void update(user user);
}