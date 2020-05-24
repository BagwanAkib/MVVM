package com.akib.core.workerRepository;

import androidx.lifecycle.LiveData;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.akib.core.worker.GitHubUserAPIWorker;

/**
 * Created by Bagwan Akib on 5/24/2020. for com.akib.core.workerRepository
 */
public class WRepository {
    public static LiveData<WorkInfo> getGitHubUserWorker() {
        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(GitHubUserAPIWorker.class)
                .addTag("GIT")
                .build();
        WorkManager.getInstance().beginUniqueWork("GIT", ExistingWorkPolicy.KEEP, request).enqueue();
        return WorkManager.getInstance().getWorkInfoByIdLiveData(request.getId());
    }
}
