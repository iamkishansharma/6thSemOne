package com.ks.a6thsemone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {


    ListView lv3;
    EditText ed1, ed2;
    Button add, delete;
//    String[] product = new String[]{"Mobile", "Laptop", "EarPhone", "Data Cable", "Charger"};
//    String[] price = new String[]{"Rs.20,000", "Rs.80,000", "Rs.900", "Rs.200", "Rs.300"};
    ArrayList<String> product = new ArrayList<>();
    ArrayList<String> price = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);

        add = findViewById(R.id.add);
        delete = findViewById(R.id.del);

        lv3 = findViewById(R.id.lv3);

        final YourAdapter yourAdapter = new YourAdapter(SecondActivity.this, product, price);
        lv3.setAdapter(yourAdapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String pro = ed1.getText().toString();
                final String pri = ed2.getText().toString();

                if(pro.length()==0 && pri.length()==0){
                    Toast.makeText(SecondActivity.this, "ERROR....", Toast.LENGTH_SHORT).show();
                }else{
                    product.add(pro);
                    price.add(pri);
                    yourAdapter.notifyDataSetChanged();
                    Toast.makeText(SecondActivity.this, "Added", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product.remove(0);
                price.remove(0);
                yourAdapter.notifyDataSetChanged();
            }
        });

    }
}
