package com.duyhq.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Person.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDAO personDAO();

    private static volatile AppDatabase INSTANCE;

    static final ExecutorService dbExecutor = Executors.newFixedThreadPool(4);

    static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, "PersonDB").build();
            }
        }

        return INSTANCE;
    }
}
