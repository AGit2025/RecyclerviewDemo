package com.example.sampleapplication.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.sampleapplication.dao.UserDao;
import com.example.sampleapplication.model.User;

@Database(entities = {

        User.class


},exportSchema = false,version = 3)

public abstract class Database1 extends RoomDatabase {

    private static final String TAG = Database1.class.getSimpleName();
    private static volatile Database1 INSTANCE;

    public static Database1 getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (Database1.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    Database1.class,
                                    "attendance_db"
                            )
                            .fallbackToDestructiveMigration()
                            .build();

                }
            }
        }
        return INSTANCE;
    }


    public abstract UserDao userDao();
}