package com.ks.a6thsemone;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

class YourAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String> product;
    private final ArrayList<String> price;

    public YourAdapter(Activity context, ArrayList<String>product, ArrayList<String> price) {
        super(context, R.layout.mylist, product);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.product = product;
        this.price = price;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.mylist, null, true);
        TextView textPerson = (TextView) view.findViewById(R.id.text1A2);
        TextView textPrice = (TextView) view.findViewById(R.id.text2A2);

        textPerson.setText(product.get(position));
        textPrice.setText(price.get(position));
        return view;
    }
}
