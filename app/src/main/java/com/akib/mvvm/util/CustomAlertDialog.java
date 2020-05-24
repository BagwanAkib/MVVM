package com.akib.mvvm.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.akib.mvvm.R;

/**
 * Created by Bagwan Akib on 5/24/2020. for com.akib.mvvm.util
 */
public class CustomAlertDialog {
    private AlertDialog dialog;
    private View customLayout;

    public void showLoading(Context context, String title, String message) {        // create an alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);        // set the custom layout
        customLayout = LayoutInflater.from(context).inflate(R.layout.progress, null);
        builder.setView(customLayout);
        customLayout.findViewById(R.id.pb_progressbar).setVisibility(View.VISIBLE);
        TextView text = customLayout.findViewById(R.id.txt_progress_text);
        text.setText(message);
        dialog = builder.create();
        dialog.show();
    }

    public void hide() {
        if (dialog != null) {
            if (dialog.isShowing())
                dialog.dismiss();
        }
    }

    public void updateText(String textString) {
        if (customLayout != null) {
            TextView text = customLayout.findViewById(R.id.txt_progress_text);
            text.setText(textString);
        }
    }

    public void updateStatusText(String textString) {
        if (customLayout != null) {
            TextView text = customLayout.findViewById(R.id.txt_progress_status);
            text.setVisibility(View.VISIBLE);
            text.setText(textString);
        }
    }
}
