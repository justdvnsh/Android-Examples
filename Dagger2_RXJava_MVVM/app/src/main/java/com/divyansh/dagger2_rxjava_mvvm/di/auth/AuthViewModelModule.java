package com.divyansh.dagger2_rxjava_mvvm.di.auth;

import androidx.lifecycle.ViewModel;

import com.divyansh.dagger2_rxjava_mvvm.di.ViewModelKey;
import com.divyansh.dagger2_rxjava_mvvm.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.MapKey;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);
}
