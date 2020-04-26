package com.ks.a6thsemone;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewAll extends AppCompatActivity {

    DatabaseHelper myDb;
    ListView sqlList;
    ArrayList<String> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        Cursor res = myDb.getAllData();

        if(res.getCount() == 0){
            Toast.makeText(ViewAll.this, "Nothing to Show", Toast.LENGTH_LONG).show();
        }else{

            while(res.moveToNext()){
                items.add("name: "+res.getString(1));
//                String name = res.getString(1);
//                String marks = res.getString(2);
//                String phone = res.getString(3);
            }
        }

        sqlList  = findViewById(R.id.sqlList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1,items);
        sqlList.setAdapter(adapter);
    }
}
