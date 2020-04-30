package com.divyansh.dagger2_rxjava_mvvm.di;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

// App Module is where we put all the application level dependencies.
@Module
public class AppModule {

    @Provides
    static boolean getApp(Application application) {
        return application == null;
    }
}
