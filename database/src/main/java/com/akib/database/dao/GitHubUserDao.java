package com.akib.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.akib.database.entity.GitHubUser;

import java.util.List;

/**
 * Created by Bagwan Akib on 5/24/2020. for com.akib.database.dao
 */
@Dao
public interface GitHubUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<GitHubUser> gitHubUsers);

    @Query("select * from GitHubUser")
    LiveData<List<GitHubUser>> getAll();
}
