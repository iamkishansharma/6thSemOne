package com.ks.a6thsemone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    Button r_add;
    EditText r_ed1, r_ed2;
    RecyclerView mRecyclerView;
    ArrayList<person> mArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        r_ed1 = findViewById(R.id.r_edt1);
        r_ed2 = findViewById(R.id.r_edt2);
        r_add = findViewById(R.id.r_btnAdd);
        mRecyclerView = findViewById(R.id.mRecyclerView);


        final String a = r_ed1.getText().toString();
        final String b = r_ed2.getText().toString();

        RecyclerView.LayoutManager rlm = new LinearLayoutManager(RecyclerViewActivity.this);
        mRecyclerView.setLayoutManager(rlm);
        mArrayList = new ArrayList<>();

        r_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person p = new person(a, b, R.drawable.ic_launcher_foreground);
                mArrayList.add(p);

            }
        });


        MyRecyclerAdapter mad = new MyRecyclerAdapter(RecyclerViewActivity.this, mArrayList);
        mRecyclerView.setAdapter(mad);

    }
}
