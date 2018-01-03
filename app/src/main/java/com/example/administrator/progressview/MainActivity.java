package com.example.administrator.progressview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ProgressView progressView1, progressView2, progressView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressView1 = (ProgressView) findViewById(R.id.progress1);
        progressView2 = (ProgressView) findViewById(R.id.progress2);
        progressView3 = (ProgressView) findViewById(R.id.progress3);

        // 默认模式
        progressView2.setProgress(50);
        progressView3.setProgress(100);

        // 动态效果
        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressHelper helper = new ProgressHelper(progressView1, 65);
                helper.start();
            }
        });
    }
}
