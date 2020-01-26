package com.ks.a6thsemone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
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
        for(int i=0;i<10;i++){
            p = new person("Name "+i,"Description "+i, R.drawable.ic_launcher_background);
            mArrayList.add(p);//Adding person object 1 by 1 to ArrayList
        }

        madG = new MyGridAdapter(this, R.layout.custom_grid, mArrayList);
        mGridView.setAdapter(madG);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CustomGridView.this, "Grid View Click ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
