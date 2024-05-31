package com.works.project.services;

import com.works.project.models.Product;
import com.works.project.models.Products;
import com.works.project.models.User;
import com.works.project.models.UserLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DummService {

    @POST("auth/login")
    Call<User> login(@Body UserLogin userLogin);

    @GET("products")
    Call<Products> allProduct();

    @GET("products/search")
    Call<Products> search(@Query("q") String data);

    @GET("products/{pid}")
    Call<Product> singleProduct(@Path("pid") long pid);




}
