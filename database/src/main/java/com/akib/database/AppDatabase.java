package com.akib.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.akib.database.dao.DeviceDao;
import com.akib.database.dao.GitHubUserDao;
import com.akib.database.entity.GitHubUser;


@Database(entities = {GitHubUser.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE = null;

    public static AppDatabase getInstance() {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(DatabaseContext.getContext(), AppDatabase.class, DatabaseContext.NAME+".db").build();
        }
        return INSTANCE;
    }

    public abstract GitHubUserDao getGitHubUserDao();
}