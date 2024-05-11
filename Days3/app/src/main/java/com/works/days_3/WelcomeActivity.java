package com.works.days_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {

    SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);

        Timer timer = new Timer();
        timer.schedule(task, 1000);

    }

    TimerTask task =  new TimerTask() {
        @Override
        public void run() {
            shared = getSharedPreferences("customer", MODE_PRIVATE);
            String token = shared.getString("token", "");
            if (token.equals("")) {
                // redirect login
                Intent i = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }else {
                // api control
                Intent i = new Intent(WelcomeActivity.this, DashboardActivity.class);
                startActivity(i);
                finish();
            }
        }
    };

}