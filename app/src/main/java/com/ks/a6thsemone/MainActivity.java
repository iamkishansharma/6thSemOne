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
    MyAdapter mad;
    ArrayList<person> al;
    person p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);

        al = new ArrayList<person>();
        //Creating 5 object
        for (int i = 0; i < 10; i++) {
            p = new person("Name " + i, "Description " + i, R.drawable.ic_launcher_foreground);
            al.add(p);//Adding person object 1 by 1 to ArrayList
        }
        mad = new MyAdapter(this, R.layout.custom_lv, al);
        lv.setAdapter(mad);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "OOOOO ", Toast.LENGTH_SHORT).show();
            }
        });


        //Button for Another activity
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(in);
            }
        });
        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2 = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(in2);
            }
        });
        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in3 = new Intent(MainActivity.this, CardViewActivity.class);
                startActivity(in3);
            }
        });
        Button btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in4 = new Intent(MainActivity.this, CustomGridView.class);
                startActivity(in4);
            }
        });
        Button btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in4 = new Intent(MainActivity.this, BackgroundThreadEx.class);
                startActivity(in4);
            }
        });
    }
}