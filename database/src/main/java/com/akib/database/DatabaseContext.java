package com.akib.database;

import android.app.Application;
import android.content.Context;

public class DatabaseContext {
    //TODO: add App Name
    static final String NAME = "APP_NAME";
    private static Application sApplication;

    public static void setContext(Application sApplication) {
        DatabaseContext.sApplication = sApplication;
    }

    public static Context getContext() {
        return sApplication.getApplicationContext();
    }
}
