package com.divyansh.dagger2_rxjava_mvvm.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.divyansh.dagger2_rxjava_mvvm.network.auth.AuthApi;

import javax.inject.Inject;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "Auth Activity";
    private AuthApi authApi;

    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authApi = authApi;
        Log.d(TAG, "View models is working ");

        if (authApi == null) {
            Log.d(TAG, "Auth api null");
        } else {
            Log.d(TAG, "Auth api is not null");
        }
    }
}
