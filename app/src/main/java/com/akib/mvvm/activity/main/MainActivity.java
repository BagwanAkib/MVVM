package com.akib.mvvm.activity.main;


import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.akib.mvvm.R;
import com.akib.mvvm.activity.base.BaseActivity;
import com.akib.mvvm.adapter.GitHubUserAdapter;
import com.akib.mvvm.util.CustomObserver;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends BaseActivity{
    @Inject
    MainActivityViewModel mainActivityViewModel;
    RecyclerView githubUsers;
    GitHubUserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        githubUsers = findViewById(R.id.rv_git_user);
        githubUsers.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GitHubUserAdapter(this, mainActivityViewModel.getUsers());
        githubUsers.setAdapter(adapter);
        mainActivityViewModel.getGitUserFromDatabase().observe(this, gitHubUsers -> {
            mainActivityViewModel.setUsers(new ArrayList<>(gitHubUsers));
            adapter.notifyDataSetChanged();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
//        mainActivityViewModel.getAllGithubUsersAPI()
//                .observe(this, CustomObserver.getObserverMessage(this, "Github", "fetch.."));
        mainActivityViewModel.getAllGithubUsersAPI()
                .observe(this, CustomObserver.getObserverWithoutProgressBar(this, new CustomObserver.ProgressStateUpdateListener() {
                    @Override
                    public void onSuccess(String data) {
                        showToast(data);
                    }

                    @Override
                    public void onFail(String data) {
                        showToast(data);
                    }
                }));
    }

    private void showToast(String data) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }

}
