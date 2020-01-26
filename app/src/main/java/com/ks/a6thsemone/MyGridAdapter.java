package com.ks.a6thsemone;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyGridAdapter extends ArrayAdapter<person> {

    private Context mContext;
    private int mResource;

    public MyGridAdapter(@NonNull Context context, int resource, @NonNull ArrayList<person> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        String desc = getItem(position).getDesc();
        int img = getItem(position).getImg();

        person mperson = new person(name, desc, img);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView t1 = convertView.findViewById(R.id.person_nameG);
        TextView t2 = convertView.findViewById(R.id.person_descG);
        ImageView im = convertView.findViewById(R.id.person_imgG);
        t1.setText(name);
        t2.setText(desc);
        im.setImageResource(img);
        return convertView;
    }
}