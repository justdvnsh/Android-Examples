package com.divyansh.dagger2_rxjava_mvvm.ui.main.post;

import android.nfc.Tag;
import android.se.omapi.Session;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.divyansh.dagger2_rxjava_mvvm.SessionManager;
import com.divyansh.dagger2_rxjava_mvvm.models.User;
import com.divyansh.dagger2_rxjava_mvvm.network.main.MainApi;
import com.divyansh.dagger2_rxjava_mvvm.ui.auth.AuthResource;

import javax.inject.Inject;


public class PostViewModel extends ViewModel {

    private static final String TAG = "PostViewModel";

    private MainApi mainApi;
    private SessionManager sessionManager;

    @Inject
    public PostViewModel(MainApi mainApi, SessionManager sessionManager) {
        this.mainApi = mainApi;
        this.sessionManager = sessionManager;

        Log.d(TAG, "post view model is working");
//        Log.d(TAG, sessionManager.getAuthUser().getValue().data.getEmail());
    }

    public LiveData<AuthResource<User>> getAuthUser() {
        return sessionManager.getAuthUser();
    }
}
