package com.akib.mvvm.di;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Bagwan Akib on 5/14/2020. for com.akibbagwan.h_helper.di
 */
@Module
public abstract class AppModule {

    @Binds
    abstract Context provideContext(Application application);

}
