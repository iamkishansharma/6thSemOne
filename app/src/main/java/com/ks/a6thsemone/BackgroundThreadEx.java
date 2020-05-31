package com.ks.a6thsemone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class BackgroundThreadEx extends AppCompatActivity {

    ProgressBar pb;
    ListView lv;
    String[] arr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    ArrayList<String> al;
    ArrayAdapter<String> ad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_thread_ex);

        pb = findViewById(R.id.prog1);
        lv = findViewById(R.id.list_bg);

        al = new ArrayList<>();
        ad = new ArrayAdapter<>(BackgroundThreadEx.this, android.R.layout.simple_list_item_1, arr);
        lv.setAdapter(ad);

        new MyTask().execute();
    }

    class MyTask extends AsyncTask<Void, Integer, String> {

        int count = 0;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setMax(10);
            pb.setProgress(0);
            pb.setVisibility(View.VISIBLE);
            count = 0;
        }
        @Override
        protected String doInBackground(Void... voids) {
            for (int i = 1; i <= 10; i++) {
                publishProgress(i);
                count = count + 1;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Completed!";
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            //super.onProgressUpdate(values[0]);
            pb.setProgress(values[0]);
            al.add(arr[count - 1]);
            ad.notifyDataSetChanged();
        }
        @Override
        protected void onPostExecute(String s) {
            //super.onPostExecute(s);
            Toast.makeText(BackgroundThreadEx.this, s, Toast.LENGTH_LONG).show();
            pb.setVisibility(View.INVISIBLE);
        }
    }
}
