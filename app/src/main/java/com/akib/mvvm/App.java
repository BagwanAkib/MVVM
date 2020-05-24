package com.akib.mvvm;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.akib.core.ApplicationContext;
import com.akib.core.Const;
import com.akib.core.CoreSharedPreferences;
import com.akib.mvvm.di.AppComponent;
import com.akib.mvvm.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;


public class App extends DaggerApplication {
    private static Application sApplication;
    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    public static Application getApplication() {
        return sApplication;
    }

    public static Context getContext() {
        return getApplication().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        ApplicationContext.setContext(sApplication);
        new CoreSharedPreferences(sApplication.getApplicationContext());
        CoreSharedPreferences.getInstance().saveString(Const.PATH, getFilesDir().getParent());
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }

}
