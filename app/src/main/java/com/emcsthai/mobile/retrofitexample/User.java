package com.emcsthai.mobile.retrofitexample;

import com.google.gson.annotations.Expose;

/**
 * Created by nakharin on 6/21/16 AD.
 */
public class User {

    @Expose
    String name;
    @Expose
    String blog;
    @Expose
    String company;

    public String getName() {
        return name;
    }

    public String getBlog() {
        return blog;
    }

    public String getCompany() {
        return company;
    }
}
