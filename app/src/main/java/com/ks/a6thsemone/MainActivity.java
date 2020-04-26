package com.ks.a6thsemone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<person> al;
    person p;

    String[] names = {"Kishan Sharma","Mohsin Khan","Summit Gangwar","Mark Zukerberg","Alien Shik","Sundar Pichai","Anything Sharma","Anyone Khan","Nothing Gangwar","Hello Anything"};
    String[] descs = {"Data Scientist","Android Developer","IOS Developer"," Project Manager","Senior Manager","Data Scientist","Android Developer","IOS Developer"," Project Manager","Senior Manager"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);

        al = new ArrayList<person>();
        //Creating 10 object
        for (int i = 0; i < 10; i++) {
            p = new person(names[i], descs[i], R.drawable.ic_launcher_foreground);
            al.add(p);//Adding person object 1 by 1 to ArrayList
        }

        MyAdapter mad;
        mad = new MyAdapter(this, R.layout.custom_lv, al);
        lv.setAdapter(mad);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, names[position], Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void sqlLiteButton(View view) {
        Intent in = new Intent(MainActivity.this, SqlLiteActivity.class);
        startActivity(in);
    }

    public void backgroundThread(View view) {
        Intent in = new Intent(MainActivity.this, BackgroundThreadEx.class);
        startActivity(in);
    }

    public void customGridView(View view) {
        Intent in = new Intent(MainActivity.this, CustomGridView.class);
        startActivity(in);
    }

    public void cardViewActivity(View view) {
        Intent in = new Intent(MainActivity.this, CardViewActivity.class);
        startActivity(in);
    }

    public void recyclerViewActivity(View view) {
        Intent in = new Intent(MainActivity.this, RecyclerViewActivity.class);
        startActivity(in);
    }

    public void customListViewActivity(View view) {
        Intent in = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(in);
    }
}