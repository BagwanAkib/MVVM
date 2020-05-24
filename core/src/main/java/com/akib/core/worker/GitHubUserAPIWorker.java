package com.akib.core.worker;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;

import com.akib.core.ApiClient;
import com.akib.core.ApiInterface;
import com.akib.database.entity.GitHubUser;
import com.akib.database.repository.GitHubRepository;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;

/**
 * Created by Bagwan Akib on 5/15/2020. for com.akibbagwan.core.worker
 */
public class GitHubUserAPIWorker extends BaseWorker {

    public GitHubUserAPIWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public ListenableWorker.Result doWork() {
        try {
            Response<List<GitHubUser>> users = ApiClient.getClient().create(ApiInterface.class).getGitHubUser().execute();
            new GitHubRepository().insert(users.body());
            addResultString("Success");
        } catch (IOException e) {
            e.printStackTrace();
            addResultString("Fail");
            return sendFail();
        }
        return sendSuccess();
    }
}
