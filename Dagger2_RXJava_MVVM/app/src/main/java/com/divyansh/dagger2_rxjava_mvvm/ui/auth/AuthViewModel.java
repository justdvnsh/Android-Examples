package com.divyansh.dagger2_rxjava_mvvm.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "Auth Activity";

    @Inject
    public AuthViewModel() {
        Log.d(TAG, "View models is working ");
    }
}
