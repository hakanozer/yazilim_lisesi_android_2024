package com.works.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.works.project.configs.Api;
import com.works.project.configs.ProductAdapter;
import com.works.project.models.Product;
import com.works.project.models.Products;
import com.works.project.services.DummService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {

    DummService dummService;
    ListView productListView;
    List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

        productListView = findViewById(R.id.productListView);
        dummService = Api.getClient().create(DummService.class);
        dummService.allProduct().enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {
                if (response.isSuccessful()) {
                    products = response.body().getProducts();
                    //Log.d("products", products.toString());
                    ProductAdapter adapter = new ProductAdapter(DashboardActivity.this, R.layout.custom_row, products);
                    productListView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Products> call, Throwable throwable) {
                Log.e("onFailure", throwable.toString() );
            }
        });

        productListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product pro = products.get(position);
                DetailActivity.pro = pro;
                Intent i = new Intent(DashboardActivity.this, DetailActivity.class);
                startActivity(i);
            }
        });

    }
}