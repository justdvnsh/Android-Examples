package com.divyansh.dagger2_rxjava_mvvm.di;

import com.divyansh.dagger2_rxjava_mvvm.di.auth.AuthModules;
import com.divyansh.dagger2_rxjava_mvvm.di.auth.AuthViewModelModule;
import com.divyansh.dagger2_rxjava_mvvm.di.main.MainFragmentBuildersModule;
import com.divyansh.dagger2_rxjava_mvvm.di.main.MainModules;
import com.divyansh.dagger2_rxjava_mvvm.di.main.MainViewModelModule;
import com.divyansh.dagger2_rxjava_mvvm.ui.auth.AuthActivity;
import com.divyansh.dagger2_rxjava_mvvm.ui.main.MainActivity;

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

    @ContributesAndroidInjector(
            modules = {
                    MainFragmentBuildersModule.class,
                    MainViewModelModule.class,
                    MainModules.class
            }
    )
    abstract MainActivity contributeMainActivity();
}
