package com.divyansh.dagger2_rxjava_mvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {

    private final String TAG = "application";

    @Inject
    RequestManager requestManager;

    @Inject
    Drawable logo;

    @BindView(R.id.login_logo)
    ImageView logoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        ButterKnife.bind(this);

        setLogo();
    }

    private void setLogo() {
        requestManager.load(logo).into(logoImage);
    }


}
