package com.works.project.configs;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.works.project.R;
import com.works.project.models.Product;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    Activity context;
    List<Product> objects;

    public ProductAdapter(@NonNull Activity context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = context.getLayoutInflater().inflate(R.layout.custom_row, null, true);
        Product pro = objects.get(position);
        TextView t_title = view.findViewById(R.id.r_title);
        TextView t_price = view.findViewById(R.id.r_price);
        t_title.setText(pro.getTitle());
        t_price.setText(pro.getPrice()+"₺");

        // Image Cache
        ImageView r_image = view.findViewById(R.id.r_img);
        Glide.with(view).load(pro.getThumbnail()).into(r_image);

        return view;
    }

}
