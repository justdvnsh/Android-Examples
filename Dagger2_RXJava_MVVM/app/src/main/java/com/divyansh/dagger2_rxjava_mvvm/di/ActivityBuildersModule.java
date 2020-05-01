package com.divyansh.dagger2_rxjava_mvvm.di;

import com.divyansh.dagger2_rxjava_mvvm.di.auth.AuthModules;
import com.divyansh.dagger2_rxjava_mvvm.di.auth.AuthViewModelModule;
import com.divyansh.dagger2_rxjava_mvvm.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelModule.class,
                    AuthModules.class
            }
    )
    abstract AuthActivity contributeAuthActivity();
}
