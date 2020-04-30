package com.divyansh.dagger2_rxjava_mvvm;

import android.app.Application;

import com.divyansh.dagger2_rxjava_mvvm.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;


// dagger support DapperApplication is compatible with more verions of android
public class BaseApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
