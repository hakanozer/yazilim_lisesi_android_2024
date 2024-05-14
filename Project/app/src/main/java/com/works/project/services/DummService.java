package com.works.project.services;

import com.works.project.models.User;
import com.works.project.models.UserLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface DummService {

    @POST("auth/login")
    Call<User> login(@Body UserLogin userLogin);

}
