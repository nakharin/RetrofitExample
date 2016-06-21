package com.emcsthai.mobile.retrofitexample.network;

import com.emcsthai.mobile.retrofitexample.network.model.User;
import com.emcsthai.mobile.retrofitexample.network.callback.UserCallbackListener;
import com.squareup.okhttp.ResponseBody;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by nakharin on 6/21/16 AD.
 */
public class WebServiceManager {

    protected static final String BASE_URL = "https://api.github.com";

    public static void getUser(String username, final UserCallbackListener listener) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);
        Call call = apiService.getUser(username);
        call.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Response<User> response, Retrofit retrofit) {
                User user = response.body();
                if (user != null) {
                    // 200 OK
                    listener.onResponse(user, retrofit);
                } else {
                    //404 Not found
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        // Error
                        listener.onBodyError(responseBody);
                    } else {
                        // Null
                        listener.onBodyErrorIsNull();
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                // Failed
                listener.onFailure(t);
            }
        });
    }
}

