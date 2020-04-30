package com.divyansh.dagger2_rxjava_mvvm.di;

import com.divyansh.dagger2_rxjava_mvvm.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();
}
