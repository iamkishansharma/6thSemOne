package com.ks.a6thsemone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomGridView extends AppCompatActivity {

    GridView mGridView;
    MyGridAdapter madG;
    ArrayList<person> mArrayList;
    person p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_grid_view);

        mGridView = findViewById(R.id.gv);

        mArrayList = new ArrayList<>();
        //Creating 5 object
        for (int i = 0; i < 10; i++) {
            p = new person("Name " + i, "Description " + i, R.drawable.ic_launcher_background);
            mArrayList.add(p);//Adding person object 1 by 1 to ArrayList
        }

        madG = new MyGridAdapter(CustomGridView.this, R.layout.custom_grid, mArrayList);
        mGridView.setAdapter(madG);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CustomGridView.this, "Grid View Click ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

class MyGridAdapter extends ArrayAdapter<person> {

    private Context mContext;
    private int mResource;

    protected MyGridAdapter(@NonNull Context context, int resource, @NonNull ArrayList<person> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        String desc = getItem(position).getDesc();
        int img = getItem(position).getImg();

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