package com.divyansh.dagger2_rxjava_mvvm.di.main;

import com.divyansh.dagger2_rxjava_mvvm.ui.main.post.PostFragment;
import com.divyansh.dagger2_rxjava_mvvm.ui.main.profile.ProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();


    @ContributesAndroidInjector
    abstract PostFragment contributePostFragment();
}
