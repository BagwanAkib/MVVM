package com.akib.core.worker;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * Created by Bagwan Akib on 5/15/2020. for com.akibbagwan.core.worker
 */
public abstract class BaseWorker extends Worker {
    public static final String RESULT_STRING = "RESULT STRING";
    private Data.Builder data;

    BaseWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        data = new Data.Builder();
    }

    void addResultString(String string) {
        data.putString(RESULT_STRING, string);
    }

    private Data getData() {
        return data.build();
    }

    Result sendSuccess() {
        return Result.success(getData());
    }

    Result sendFail() {
        return Result.failure(getData());
    }

}
