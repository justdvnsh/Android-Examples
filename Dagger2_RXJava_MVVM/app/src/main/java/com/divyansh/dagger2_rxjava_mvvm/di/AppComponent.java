package com.divyansh.dagger2_rxjava_mvvm.di;

import android.app.Application;

import com.divyansh.dagger2_rxjava_mvvm.BaseApplication;
import com.divyansh.dagger2_rxjava_mvvm.SessionManager;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuildersModule.class,
                AppModule.class,
                ViewModelFactoryModule.class,
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {

    SessionManager sessionManager();

    @Component.Builder
    interface Builder{


        // we inject the base application into App component.
        // app component is the service and Base Application is the Client
        // like interface in Retrofit, is the service and Retofit's instance is Client

        @BindsInstance
        Builder application(Application application);


        // we pass the application class to the main component builder, which will bind the instance of the
        // Base Application to persist throughout the lifetime of the app.
        // ** NOTE ** DaggerApplication is of the type Application
        // BindsInstance is used when we already have the resource available to us before building the project.
        // like here we have the application class even before the Application is built.
        // so, we bind an instance of the Application object.

        AppComponent build();
    }
}

