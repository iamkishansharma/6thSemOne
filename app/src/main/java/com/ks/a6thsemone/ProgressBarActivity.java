package com.ks.a6thsemone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class ProgressBarActivity extends AppCompatActivity {

    ProgressBar pgb1, pgb2;
    Button start, reset;
    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        pgb1 = findViewById(R.id.progressbar1);
        pgb2 = findViewById(R.id.progressbar2);
        start = findViewById(R.id.prog_start);
        reset = findViewById(R.id.prog_reset);
        mProgressBar = new ProgressBar(ProgressBarActivity.this);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressBar.setMax(100);
                mProgressBar.setIndeterminate(true);
                final int totalTime = 100;
                Thread t = new Thread(){
                    @Override
                    public void run() {
                        int jumpTime = 0;
                        while (jumpTime < totalTime){
                            try{
                                sleep(200);
                                jumpTime += 5;
                                pgb1.setProgress(jumpTime);
                                pgb2.setProgress(jumpTime);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    }
                };
                t.start();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pgb1.setProgress(0);
                pgb1.setProgress(0);
            }
        });


    }
}
