package com.ks.a6thsemone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyHolder> {
    Context ct;
    ArrayList<person> al;
    String name;
    String desc;

    MyRecyclerAdapter(Context context, ArrayList all, String a, String b) {
        ct = context;
        al = all;
        name = a;
        desc = b;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(ct);
        View v = li.inflate(R.layout.custom_lv, parent, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        final person p1 = al.get(position);

        holder.tv1.setText(name);
        holder.tv2.setText(desc);
        holder.iv.setImageResource(p1.getImg());

        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ct, "Clicked! " + position, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tv1, tv2;
        ImageView iv;
        RelativeLayout ll;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.person_name);
            tv2 = itemView.findViewById(R.id.person_desc);
            iv = itemView.findViewById(R.id.person_img);
            ll = itemView.findViewById(R.id.personLay);
        }
    }
}
