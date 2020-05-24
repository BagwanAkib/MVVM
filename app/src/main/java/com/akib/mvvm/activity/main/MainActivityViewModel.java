package com.akib.mvvm.activity.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.work.WorkInfo;

import com.akib.core.workerRepository.WRepository;
import com.akib.database.entity.GitHubUser;
import com.akib.database.repository.GitHubRepository;

import java.util.ArrayList;
import java.util.List;

class MainActivityViewModel extends ViewModel {
    private ArrayList<GitHubUser> users = new ArrayList<>();
    private GitHubRepository repository;

    MainActivityViewModel() {
        repository = new GitHubRepository();
    }

    LiveData<List<GitHubUser>> getGitUserFromDatabase() {
        return repository.getAll();
    }

    LiveData<WorkInfo> getAllGithubUsersAPI() {
        return WRepository.getGitHubUserWorker();
    }

    ArrayList<GitHubUser> getUsers() {
        return users;
    }

    void setUsers(ArrayList<GitHubUser> users) {
        this.users.addAll(users);
    }
}
