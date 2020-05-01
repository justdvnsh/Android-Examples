package com.divyansh.dagger2_rxjava_mvvm.di;

import android.app.Application;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.divyansh.dagger2_rxjava_mvvm.R;

import dagger.Module;
import dagger.Provides;

// App Module is where we put all the application level dependencies.
@Module
public class AppModule {

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
