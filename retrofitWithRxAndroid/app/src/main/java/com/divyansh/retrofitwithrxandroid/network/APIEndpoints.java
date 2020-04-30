package com.divyansh.retrofitwithrxandroid.network;

import com.divyansh.retrofitwithrxandroid.network.pojo.User;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIEndpoints {

    @GET("/api/users")
    Call<User> getUsers();
}
