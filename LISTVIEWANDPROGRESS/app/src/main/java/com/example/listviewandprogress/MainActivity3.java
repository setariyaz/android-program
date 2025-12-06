package com.example.listviewandprogress;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView iv = findViewById(R.id.imageView);
        String str = getIntent().getStringExtra("arr");
        //Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
        if(str.equals("MEET"))
        {
            iv.setImageResource(R.drawable.a7);
        }
        else if(str.equals("ROHIT"))
        {
            iv.setImageResource(R.drawable.a9);
        }
        else if(str.equals("SAHIL"))
        {
            iv.setImageResource(R.drawable.a4);
        }
        else if(str.equals("SATYAN"))
        {
            iv.setImageResource(R.drawable.a8);
        }
        else if(str.equals("ZAHIR"))
        {
            iv.setImageResource(R.drawable.a1);
        }
        else if(str.equals("KUNAL"))
        {
            iv.setImageResource(R.drawable.a5);
        }
        else if(str.equals("MOULIK"))
        {
            iv.setImageResource(R.drawable.a10);
        }
        else if(str.equals("JIGAR"))
        {
            iv.setImageResource(R.drawable.a6);
        }
        else if(str.equals("ALL"))
        {
            iv.setImageResource(R.drawable.a3);
        }
    }
}