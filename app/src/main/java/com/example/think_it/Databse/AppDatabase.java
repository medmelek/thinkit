package com.example.think_it.Databse;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.think_it.dao.userDao;
import com.example.think_it.entity.user;

@Database(entities = {user.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract userDao userDao();
}
