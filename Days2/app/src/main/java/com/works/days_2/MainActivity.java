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

import com.works.days_2.models.Customer;
import com.works.days_2.utils.Const;

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

        Customer c = new Customer(50, "Erkan", "Bilsin", "Istanbul Address");
        ProfileActivity.customer = c;
        //ProfileActivity.customer = new Customer(50, "Erkan", "Bilsin", "Istanbul Address");

        Intent i = new Intent(this,  ProfileActivity.class);
        i.putExtra(Const.NAME, "Ali");
        i.putExtra(Const.SURNAME, "Bilmem");
        startActivity(i);
        // finish(); // bu ekranı öldür.
        // System.exit(0);
    }


}