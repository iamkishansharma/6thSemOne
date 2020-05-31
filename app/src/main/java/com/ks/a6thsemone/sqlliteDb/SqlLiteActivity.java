package com.ks.a6thsemone.sqlliteDb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ks.a6thsemone.R;

public class SqlLiteActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText id, name, marks, phone;
    Button sqlAdd, sqlViewAll;
    boolean isInserted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_lite);

        name = findViewById(R.id.sqlName);
        marks = findViewById(R.id.sqlMarks);
        phone = findViewById(R.id.sqlPhone);

        myDb = new DatabaseHelper(this);

        sqlAdd = findViewById(R.id.sqlAdd);
        sqlViewAll = findViewById(R.id.sqlViewAll);


        //Adding Data into DataBase and generating toast
        sqlAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nam = name.getText().toString();
                final String mark = marks.getText().toString();
                final String phon = phone.getText().toString();

                if(nam.length()==0 && mark.length()==0 && phon.length()==0){
                    name.setError("Required Field");
                    marks.setError("Required Field");
                    phone.setError("Required Field");

                }else{
                    isInserted = myDb.insertData(nam, mark, phon);
                    if(isInserted){
                        name.setText("");
                        marks.setText("");
                        phone.setText("");
                        Toast.makeText(SqlLiteActivity.this, "Data Added", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(SqlLiteActivity.this, "Data could not be Added", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        //Viewing Data from the DataBase
        sqlViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SqlLiteActivity.this, ViewAll.class);
                startActivity(in);
            }
        });
    }
}
