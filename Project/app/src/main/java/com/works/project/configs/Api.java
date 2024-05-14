package com.works.project.configs;

import retrofit2.Retrofit;

public class Api {

    private static String baseURL = "https://dummyjson.com/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .build();
        }
        return retrofit;
    }

}
