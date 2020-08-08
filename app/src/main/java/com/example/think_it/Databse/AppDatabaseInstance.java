package com.example.think_it.Databse;

import android.content.Context;

import androidx.room.Room;

public class AppDatabaseInstance {

    private Context mCtx;
    private static AppDatabaseInstance mInstance;

    //our app database object
    private AppDatabase appDatabase;

    private AppDatabaseInstance(Context mCtx) {
        this.mCtx = mCtx;

        //creating the app database with Room database builder
        //MyToDos is the name of the database
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase.class, "users").build();
    }

    public static synchronized AppDatabaseInstance getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new AppDatabaseInstance(mCtx);
        }
        return mInstance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
