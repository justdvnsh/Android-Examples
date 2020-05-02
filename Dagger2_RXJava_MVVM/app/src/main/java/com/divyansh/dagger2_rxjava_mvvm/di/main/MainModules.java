package com.divyansh.dagger2_rxjava_mvvm.di.main;

import com.divyansh.dagger2_rxjava_mvvm.network.main.MainApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModules {

    @Provides
    static MainApi getMainApiMethods(Retrofit retrofit) {
        return retrofit.create(MainApi.class);
    }
}
