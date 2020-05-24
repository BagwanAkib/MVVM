package com.akib.database.repository;


import androidx.lifecycle.LiveData;

import com.akib.database.AppDatabase;
import com.akib.database.dao.GitHubUserDao;
import com.akib.database.entity.GitHubUser;

import java.util.List;

/**
 * Created by Bagwan Akib on 5/24/2020. for com.akib.database.repository
 */
public class GitHubRepository {
    private GitHubUserDao dao;

    public GitHubRepository() {
        dao = AppDatabase.getInstance().getGitHubUserDao();
    }

    public void insert(List<GitHubUser> gitHubUsers) {
        dao.insert(gitHubUsers);
    }

    public LiveData<List<GitHubUser>> getAll() {
        return dao.getAll();
    }
}
