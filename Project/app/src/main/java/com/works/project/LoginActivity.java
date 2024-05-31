package com.works.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    EditText txtUserName, txtPassword;
    Button btnLogin;
    SharedPreferences shared;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        shared = getSharedPreferences("customer", MODE_PRIVATE);
        editor = shared.edit();

        String token = shared.getString("token","");
        if(!token.equals("")) {
            Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(i);
            finish();
        }

        txtUserName = findViewById(R.id.txtUserName);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        dummService = Api.getClient().create(DummService.class);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUserName.getText().toString();
                String password = txtPassword.getText().toString();

                UserLogin userLogin = new UserLogin();
                userLogin.setUsername(username);
                userLogin.setPassword(password);
                dummService.login(userLogin).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()) {
                            User user = response.body();
                            editor.putString("token", user.getToken());
                            editor.putString("name", user.getFirstName());
                            editor.commit();
                            Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
                            startActivity(i);
                            finish();
                        }else {
                            Toast.makeText(LoginActivity.this, "Username or Password Fail!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable throwable) {
                        Toast.makeText(LoginActivity.this, "Server Error!", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });




    }
}