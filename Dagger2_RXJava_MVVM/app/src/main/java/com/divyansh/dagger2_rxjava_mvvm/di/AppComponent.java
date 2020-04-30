package com.divyansh.dagger2_rxjava_mvvm.di;

import android.app.Application;

import com.divyansh.dagger2_rxjava_mvvm.BaseApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(
        modules = {
                AndroidSupportInjectionModule.class
        }
)
public interface AppComponent  extends AndroidInjector<BaseApplication> {
    // we inject the base application into App component.
    // app component is the service and Base Application is the Client
    // like interface in Retrofit, is the service and Retofit's instance is Client

    @Component.Builder
    interface Builder {

        // we pass the application class to the main component builder, which will bind the instance of the
        // Base Application to persist throughout the lifetime of the app.
        // ** NOTE ** DaggerApplication is of the type Application
        // BindsInstance is used when we already have the resource available to us before building the project.
        // like here we have the application class even before the Application is built.
        // so, we bind an instance of the Application object.
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
