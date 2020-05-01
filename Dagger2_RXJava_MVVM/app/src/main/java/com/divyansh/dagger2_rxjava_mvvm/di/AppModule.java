package com.divyansh.dagger2_rxjava_mvvm.di;

import android.app.Application;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.divyansh.dagger2_rxjava_mvvm.R;
import com.divyansh.dagger2_rxjava_mvvm.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// App Module is where we put all the application level dependencies.
@Module
public class AppModule {

    @Singleton
    @Provides
    static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Provides
    static RequestOptions providesRequestOptions() {
        return RequestOptions.placeholderOf(R.drawable.logo).error(R.drawable.white_background);
    }

    @Provides
    static RequestManager providesRequestManager(Application application, RequestOptions requestOptions) {
        return Glide.with(application).setDefaultRequestOptions(requestOptions);
    }

    @Provides
    static Drawable providesDrawable(Application application) {
        return ContextCompat.getDrawable(application, R.drawable.logo);
    }
}
