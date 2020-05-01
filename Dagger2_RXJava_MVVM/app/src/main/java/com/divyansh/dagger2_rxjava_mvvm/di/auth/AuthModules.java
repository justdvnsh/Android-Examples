package com.divyansh.dagger2_rxjava_mvvm.di.auth;

import com.divyansh.dagger2_rxjava_mvvm.network.auth.AuthApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModules {

    @Provides
    static AuthApi getAuthApiMethods(Retrofit retrofit) {
        return retrofit.create(AuthApi.class);
    }
}
