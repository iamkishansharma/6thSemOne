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

public class MyAdapter extends ArrayAdapter<person> {

    private Context mContext;
    int mResource;

    public MyAdapter(@NonNull Context context, int resource, @NonNull ArrayList<person> objects) {
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

        person mperson = new person(name,desc,img);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent,false);

        TextView t1 = (TextView) convertView.findViewById(R.id.person_name);
        TextView t2 = (TextView) convertView.findViewById(R.id.person_desc);
        ImageView im = (ImageView) convertView.findViewById(R.id.person_img);
        t1.setText(name);
        t2.setText(desc);
        im.setImageResource(img);
        return convertView;
    }


    //    Context c;
//    ArrayList<person> al;
//    MyAdapter(Context c, int custom_lv, ArrayList<person> al){
//        this.c = c;
//        this.al = al;
//    }
//
//    @Override
//    public int getCount(){
//        return 0;
//    }
//
//    @Override
//    public Object getItem(int position){
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position){
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent){
//        person p = (person) getItem(position);
//        Activity a = (Activity)c;
//        View v = a.getLayoutInflater().inflate(R.layout.custom_lv, null);
//
//        TextView t1 = v.findViewById(R.id.person_name);
//        TextView t2 = v.findViewById(R.id.person_desc);
//        ImageView im = v.findViewById(R.id.person_img);
//        t1.setText(p.getName());
//        t2.setText(p.getDesc());
//        im.setImageResource(p.getImg());
//        return v;
//    }
}
