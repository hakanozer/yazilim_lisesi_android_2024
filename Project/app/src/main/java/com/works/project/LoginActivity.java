package com.works.project;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.works.project.configs.Api;
import com.works.project.models.User;
import com.works.project.models.UserLogin;
import com.works.project.services.DummService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    DummService dummService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        dummService = Api.getClient().create(DummService.class);
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername("kminchelle");
        userLogin.setPassword("0lelplR");
        dummService.login(userLogin).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                Log.d("id", user.toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable throwable) {

            }
        });


    }
}