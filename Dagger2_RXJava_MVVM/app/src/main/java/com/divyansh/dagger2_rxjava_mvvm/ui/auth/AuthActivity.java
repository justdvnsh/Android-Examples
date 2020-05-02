package com.divyansh.dagger2_rxjava_mvvm.ui.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.divyansh.dagger2_rxjava_mvvm.R;
import com.divyansh.dagger2_rxjava_mvvm.models.User;
import com.divyansh.dagger2_rxjava_mvvm.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {

    private final String TAG = "application";
    private AuthViewModel authViewModel;

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    @Inject
    RequestManager requestManager;

    @Inject
    Drawable logo;

    @BindView(R.id.login_logo)
    ImageView logoImage;

    @BindView(R.id.user_id_input)
    EditText userId;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        ButterKnife.bind(this);

        authViewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(AuthViewModel.class);

        setLogo();

        subscribeObserver();
    }

    private void setLogo() {
        requestManager.load(logo).into(logoImage);
    }

    private void subscribeObserver() {
        authViewModel.observeUser().observe(this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if (userAuthResource != null) {
                    switch (userAuthResource.status) {
                        case LOADING:
                            setVisibility(true);
                            break;

                        case AUTHENTICATED:
                            setVisibility(false);
                            Log.d(TAG, "LOGIN SUCESS" + userAuthResource.data.getEmail());
                            break;

                        case ERROR:
                            setVisibility(false);
                            Toast.makeText(AuthActivity.this, "Put a number between 1 to 10", Toast.LENGTH_SHORT).show();
                            break;

                        case NOT_AUTHENTICATED:
                            setVisibility(false);
                            break;
                    }
                }
            }
        });
    }

    private void setVisibility(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.login_button)
    public void login(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                attemptLogin();
                break;
        }
    }

    private void attemptLogin() {
        if (TextUtils.isEmpty(userId.getText().toString())) {
            return ;
        }
        authViewModel.authenticateWithId(Integer.parseInt(userId.getText().toString()));
    }

}
