package com.ks.a6thsemone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SqlLiteActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText id, name, marks, phone;
    Button sqlAdd, sqlViewAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_lite);

        id = findViewById(R.id.sqlId);
        name = findViewById(R.id.sqlName);
        marks = findViewById(R.id.sqlMarks);
        phone = findViewById(R.id.sqlPhone);

        sqlAdd = findViewById(R.id.sqlAdd);
        sqlViewAll = findViewById(R.id.sqlViewAll);

        //Adding Data into DataBase and generating toast
        sqlAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(name.getText().toString(), marks.getText().toString(), phone.getText().toString());
                if(isInserted){
                    Toast.makeText(SqlLiteActivity.this, "Data Added", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SqlLiteActivity.this, "Data could not be Added", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Viewing Data from the DataBase
        sqlViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SqlLiteActivity.this,ViewAll.class));
            }
        });
    }
}
