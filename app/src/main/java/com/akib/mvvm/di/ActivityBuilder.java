package com.akib.mvvm.di;


import com.akib.mvvm.activity.main.MainActivity;
import com.akib.mvvm.activity.main.MainActivityModel;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Bagwan Akib on 5/14/2020. for com.akibbagwan.h_helper.di
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModel.class)
    abstract MainActivity bindMainActivity();

}