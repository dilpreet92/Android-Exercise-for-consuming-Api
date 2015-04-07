package com.test.api;

import com.test.models.Meal;
import com.test.models.User;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by vinsol on 4/6/15.
 */
public interface ApiService {

    @FormUrlEncoded
    @POST("/supplier/users/sign_in")
    public void login(@Field("email") String email, @Field("password") String password, Callback<User> cb);

    @GET("/meals")
    public void getMeals(Callback<ArrayList<Meal>> cb);
}
