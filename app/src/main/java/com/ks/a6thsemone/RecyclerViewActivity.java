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

    Button r_add, r_del;
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
        r_del = findViewById(R.id.r_btnDel);

        mRecyclerView = findViewById(R.id.mRecyclerView);

        RecyclerView.LayoutManager rlm = new LinearLayoutManager(RecyclerViewActivity.this);
        mRecyclerView.setLayoutManager(rlm);
        mArrayList = new ArrayList<>();

        final MyRecyclerAdapter mad = new MyRecyclerAdapter(RecyclerViewActivity.this, mArrayList);
        mRecyclerView.setAdapter(mad);

        r_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = r_ed1.getText().toString().trim();
                final String desc = r_ed2.getText().toString().trim();
                person p = new person(name,desc, R.drawable.ic_launcher_foreground);
                mArrayList.add(p);
                mad.notifyDataSetChanged();

            }
        });
        r_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mArrayList.remove(0);
                mad.notifyDataSetChanged();

            }
        });


    }
}
