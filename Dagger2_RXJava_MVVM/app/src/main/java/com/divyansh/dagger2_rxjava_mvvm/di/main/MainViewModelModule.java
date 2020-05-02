package com.divyansh.dagger2_rxjava_mvvm.di.main;

import androidx.lifecycle.ViewModel;

import com.divyansh.dagger2_rxjava_mvvm.di.ViewModelKey;
import com.divyansh.dagger2_rxjava_mvvm.ui.main.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);
}
