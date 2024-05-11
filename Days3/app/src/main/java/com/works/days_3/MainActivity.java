package com.works.days_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;
import com.works.days_3.utils.Util;

public class MainActivity extends AppCompatActivity {

    EditText txtEmail, txtPassword;
    Button btnLogin, btnRegister;
    SharedPreferences shared;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        shared = getSharedPreferences("customer", MODE_PRIVATE);
        editor = shared.edit();

        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();

                if (!Util.isValidEmail(email)) {
                    Util.alert(MainActivity.this, "Email Empty or Not Valid!" );
                }else if ( !Util.isValidPassword(password) ) {
                    //Util.alert(MainActivity.this,"Password not Valid!" );
                    Snackbar.make(v, "Password not Valid!", Snackbar.LENGTH_LONG).show();
                }else {
                    Log.d("email", email);
                    Log.d("password", password);
                    editor.putString("email", email);
                    editor.putString("token", "token123");
                    boolean status = editor.commit();
                    if (status) {
                        Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                        startActivity(i);
                        finish();
                    }
                }


            }
        });


        txtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("email", s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }



}