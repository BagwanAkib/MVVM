package com.akib.mvvm.util;

import android.content.Context;

import androidx.lifecycle.Observer;
import androidx.work.WorkInfo;

import com.akib.core.worker.BaseWorker;

/**
 * Created by Bagwan Akib on 5/24/2020. for com.akib.mvvm.util
 */
public class CustomObserver {
    public static Observer<WorkInfo> getObserverMessage(Context context, String title, String message) {
        CustomAlertDialog progressUtil = new CustomAlertDialog();
        progressUtil.showLoading(context, title, message);
        return workInfo -> {
            if (workInfo.getState().equals(WorkInfo.State.ENQUEUED)) {
                progressUtil.updateText("Loading..");
            }
            if (workInfo.getState().equals(WorkInfo.State.SUCCEEDED)) {
                progressUtil.updateText(workInfo.getOutputData().getString(BaseWorker.RESULT_STRING));
                progressUtil.hide();
                DialogUtil.messageBox(context, title, workInfo.getOutputData().getString(BaseWorker.RESULT_STRING));
            }
            if (workInfo.getState().equals(WorkInfo.State.RUNNING)) {
                progressUtil.updateText("Requesting..");
            }
            if (workInfo.getState().equals(WorkInfo.State.FAILED)
                    || workInfo.getState().equals(WorkInfo.State.BLOCKED)
                    || workInfo.getState().equals(WorkInfo.State.CANCELLED)) {
                progressUtil.updateText(workInfo.getOutputData().getString(BaseWorker.RESULT_STRING));
                progressUtil.hide();
            }
        };
    }

    public static Observer<WorkInfo> getObserver(Context context) {
        CustomAlertDialog progressUtil = new CustomAlertDialog();
        progressUtil.showLoading(context, "Github", "Loading...");
        return workInfo -> {
            if (workInfo.getState().equals(WorkInfo.State.ENQUEUED)) {
                progressUtil.updateText("Loading..");
            }
            if (workInfo.getState().equals(WorkInfo.State.SUCCEEDED)) {
                progressUtil.updateText(workInfo.getOutputData().getString(BaseWorker.RESULT_STRING));
                progressUtil.hide();
            }
            if (workInfo.getState().equals(WorkInfo.State.RUNNING)) {
                progressUtil.updateText("Requesting..");
            }
            if (workInfo.getState().equals(WorkInfo.State.FAILED)
                    || workInfo.getState().equals(WorkInfo.State.BLOCKED)
                    || workInfo.getState().equals(WorkInfo.State.CANCELLED)) {
                progressUtil.updateText(workInfo.getOutputData().getString(BaseWorker.RESULT_STRING));
                progressUtil.hide();
            }
        };
    }

    public static Observer<WorkInfo> getObserverWithoutProgressBar(Context context, ProgressStateUpdateListener listener) {
        return workInfo -> {
//            if (workInfo.getState().equals(WorkInfo.State.ENQUEUED)) {
//
//            }
            if (workInfo.getState().equals(WorkInfo.State.SUCCEEDED)) {
                listener.onSuccess(workInfo.getOutputData().getString(BaseWorker.RESULT_STRING));
            }
//            if (workInfo.getState().equals(WorkInfo.State.RUNNING)) {
//            }
            if (workInfo.getState().equals(WorkInfo.State.FAILED)
                    || workInfo.getState().equals(WorkInfo.State.BLOCKED)
                    || workInfo.getState().equals(WorkInfo.State.CANCELLED)) {
                listener.onFail(workInfo.getOutputData().getString(BaseWorker.RESULT_STRING));
            }
        };
    }

    public interface ProgressStateUpdateListener {
        void onSuccess(String data);

        void onFail(String data);
    }
}
