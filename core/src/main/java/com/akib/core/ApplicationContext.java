package com.akib.core;

import android.app.Application;
import android.content.Context;

import com.akib.database.DatabaseContext;
import com.facebook.stetho.Stetho;

public class ApplicationContext {
    private static Application sApplication;

    public static void setContext(Application sApplication) {
        DatabaseContext.setContext(sApplication);
        ApplicationContext.sApplication = sApplication;
        Stetho.initializeWithDefaults(sApplication.getApplicationContext());
    }

    public static Context getContext() {
        return sApplication.getApplicationContext();
    }
}
