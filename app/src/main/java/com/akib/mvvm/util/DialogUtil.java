package com.akib.mvvm.util;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

/**
 * Created by Bagwan Akib on 5/24/2020. for com.akib.mvvm.util
 */
public class DialogUtil {
    public void oneButtonDialog(Context context, String title, String message, String btnName, DialogInterface.OnClickListener listener, boolean cancelable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message)
                .setCancelable(cancelable)
                .setPositiveButton(btnName, listener);
        AlertDialog alert = builder.create();
        alert.show();
    }

    public static void messageBox(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        AlertDialog alert = builder.create();
        alert.show();
    }
}
