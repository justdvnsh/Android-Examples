package com.divyansh.dagger2_rxjava_mvvm.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.divyansh.dagger2_rxjava_mvvm.viewmodel.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);

    // similar to writing
    // binds is more efficient way of doing the same thing.
    // basically, in both of them we are just telling the dagger component to bind instance of the viewmodelfactory
    /*
    * @Provides
    * static ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory vm) {
    *   return vm;
    * }
    *
    * */
}
