package com.example.listviewandprogress;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int progress = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ProgressBar pb= findViewById(R.id.progressBar);
        TextView tv= findViewById(R.id.textView);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                pb.setProgress(progress);
                tv.setText(progress+"%");
                progress++;
                if(progress<=100)
                {
                    h.postDelayed(this,50);
                }
                else
                {
                    startActivity(new Intent(getApplicationContext(),MainActivity2.class));
                }
            }
        },100);
    }
}