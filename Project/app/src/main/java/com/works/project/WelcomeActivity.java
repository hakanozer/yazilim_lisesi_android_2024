package com.works.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);
        Timer timer = new Timer();
        timer.schedule(timerTask, 3000);
        //timer.cancel();
        //timer.schedule(timerTask, 13000);

    }

    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            Intent i = new Intent(WelcomeActivity.this, LoginActivity.class);
            startActivity(i);
            Log.d("TAG", "this line call");
        }
    };

}