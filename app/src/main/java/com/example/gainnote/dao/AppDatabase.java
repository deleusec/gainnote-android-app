package com.example.gainnote.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.gainnote.model.Exercice;
import com.example.gainnote.model.TrainingSession;
import com.example.gainnote.model.User;
@TypeConverters({Converters.class})
@Database(entities = { User.class, TrainingSession.class, Exercice.class}, version = AppDatabase.DATABASE_VERSION, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static final int DATABASE_VERSION = 11;
    public static final String DATABASE_NAME = "myDbb";

    public abstract AppDao appDao();

    private static volatile AppDatabase INSTANCE;

    public int userSelected = 0;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration().allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }

    public static User getUser(Context context){
      return   getDatabase(context).appDao().getUser();
    }

}