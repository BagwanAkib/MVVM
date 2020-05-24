package com.akib.mvvm.activity.main;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModel {

    @Provides
    MainActivityViewModel getMainActivityViewModel() {
        return new MainActivityViewModel();
    }
}
