package com.works.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.works.project.configs.Api;
import com.works.project.configs.DB;
import com.works.project.configs.ProductAdapter;
import com.works.project.models.Product;
import com.works.project.services.DummService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Likes extends AppCompatActivity {

    DB db;
    DummService dummService;
    List<Product> products;
    ListView productListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_likes);

        productListView = findViewById(R.id.productListView);
        dummService = Api.getClient().create(DummService.class);
        db = new DB(this);


        productListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product pro = products.get(position);
                DetailActivity.pro = pro;
                Intent i = new Intent(Likes.this, DetailActivity.class);
                startActivity(i);
            }
        });

        productListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Product pro = products.get(position);
                Log.d("prox", pro.getTitle());
                return true;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Long> ids = db.allLikes();
        products = new ArrayList<>();
        for (Long id : ids) {
            dummService.singleProduct(id).enqueue(new Callback<Product>() {
                @Override
                public void onResponse(Call<Product> call, Response<Product> response) {
                    Product pro = response.body();
                    products.add(pro);
                    ProductAdapter adapter = new ProductAdapter(Likes.this, R.layout.custom_row, products);
                    productListView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<Product> call, Throwable throwable) {

                }
            });
        }
    }
}