package com.works.project;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.works.project.configs.DB;
import com.works.project.models.Product;

public class DetailActivity extends AppCompatActivity {

    static Product pro;
    TextView d_title, d_price, d_detail;
    ImageView d_img;
    ImageButton btnLike;

    DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        db = new DB(this);

        d_title = findViewById(R.id.d_title);
        d_img = findViewById(R.id.d_img);
        d_price = findViewById(R.id.d_price);
        d_detail = findViewById(R.id.d_detail);
        btnLike = findViewById(R.id.btnLike);

        d_title.setText(pro.getTitle());
        Glide.with(this).load(pro.getThumbnail()).into(d_img);
        d_price.setText(pro.getPrice()+"₺");
        d_detail.setText(pro.getDescription());

        boolean status = db.singleLike(pro.getID());
        if (status) {
            btnLike.setColorFilter(Color.RED);
        }
        
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean status = db.singleLike(pro.getID());
                if (status) {
                    int removeStatus = db.removeLike(pro.getID());
                    if (removeStatus > 0) {
                        btnLike.setColorFilter(Color.BLACK);
                    }
                }else {
                    long id = db.addLike(pro.getID());
                    if (id > 0) {
                        btnLike.setColorFilter(Color.RED);
                    }
                }
            }
        });

    }
}