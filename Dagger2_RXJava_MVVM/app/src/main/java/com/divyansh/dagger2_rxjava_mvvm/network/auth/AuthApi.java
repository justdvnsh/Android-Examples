package com.divyansh.dagger2_rxjava_mvvm.network.auth;

import com.divyansh.dagger2_rxjava_mvvm.models.User;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AuthApi {

    @GET("/users/{id}")
    Flowable<User> getUser(
            @Path("id") int id
    );

}
