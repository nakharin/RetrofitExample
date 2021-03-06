package com.emcsthai.mobile.retrofitexample.network;

import com.emcsthai.mobile.retrofitexample.network.model.User;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by nakharin on 6/21/16 AD.
 */
public interface APIService {

    @GET("/users/{username}")
    Call<User> getUser(@Path("username") String username);
}
