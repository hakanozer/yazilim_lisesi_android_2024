package com.works.days_2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnGotoProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnGotoProfile = findViewById(R.id.btnGotoProfile);
        btnGotoProfile.setOnClickListener(profileClick);
    }

    View.OnClickListener profileClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("onClick", "Profile onClick: ");
        }
    };

    public void gotoProfile(View view) {
        view.setBackgroundColor(Color.RED);
        Log.d("gotoProfile", "gotoProfile: click ");

        Intent i = new Intent(this,  ProfileActivity.class);
        startActivity(i);
    }
    

}