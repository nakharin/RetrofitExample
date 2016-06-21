package com.emcsthai.mobile.retrofitexample.network.callback;

import com.emcsthai.mobile.retrofitexample.network.model.User;
import com.squareup.okhttp.ResponseBody;

import retrofit.Retrofit;

/**
 * Created by nakharin on 6/21/16 AD.
 */
public interface UserCallbackListener {
    void onResponse(User user, Retrofit retrofit);
    void onBodyError(ResponseBody responseBodyError);
    void onBodyErrorIsNull();
    void onFailure(Throwable t);
}
