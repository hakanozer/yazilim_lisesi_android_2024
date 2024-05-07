package com.works.days_2;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.works.days_2.models.Customer;
import com.works.days_2.utils.Const;

public class ProfileActivity extends AppCompatActivity {

    public static Customer customer = new Customer();
    TextView txtName, txtSurname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        txtName = findViewById(R.id.txtName);
        txtSurname = findViewById(R.id.txtSurname);

        String name = getIntent().getStringExtra(Const.NAME);
        String surname = getIntent().getStringExtra(Const.SURNAME);
        int age = getIntent().getIntExtra(Const.AGE, -1);

        if (name != null) {
            txtName.setText(name);
            txtSurname.setText(surname);
        }else {
            finish();
        }

        Log.d("name", customer.toString());


    }
}