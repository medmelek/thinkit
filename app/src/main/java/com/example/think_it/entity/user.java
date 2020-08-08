package com.example.think_it.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class user implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "fullname")
    private String fullname;

    //--------

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}