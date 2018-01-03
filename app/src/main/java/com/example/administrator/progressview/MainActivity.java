package com.example.administrator.progressview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ProgressView progressView1, progressView2, progressView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressView1 = (ProgressView) findViewById(R.id.progress1);
        progressView2 = (ProgressView) findViewById(R.id.progress2);
        progressView3 = (ProgressView) findViewById(R.id.progress3);

        progressView1.setProgress(25);
        progressView2.setProgress(50);
        progressView3.setProgress(100);
    }
}
