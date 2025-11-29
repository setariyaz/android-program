package com.example.counterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int a=0;

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
        Button b1,b2,b3;
        TextView tx1;


        b1=findViewById(R.id.button2);
        b2=findViewById(R.id.button);
        b3=findViewById(R.id.button3);
        tx1=findViewById(R.id.textView);

        tx1.setText(String.valueOf(a));
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a++;
                tx1.setText(String.valueOf(a));
                if(a==50){
                  tx1.setTextColor(getColor(R.color.c));
                    Toast.makeText(MainActivity.this,"Your Score 50",Toast.LENGTH_SHORT).show();
                }
                else if(a==100){

                    Toast.makeText(MainActivity.this,"Your Score 100",Toast.LENGTH_SHORT).show();
                    tx1.setTextColor(getColor(R.color.a));

                }
                else if(a==150){

                    Toast.makeText(MainActivity.this,"Your Score 150",Toast.LENGTH_SHORT).show();
                    tx1.setTextColor(getColor(R.color.b));

                }
                else if(a==200){

                    Toast.makeText(MainActivity.this,"Your Score 100",Toast.LENGTH_SHORT).show();
                    tx1.setTextColor(getColor(R.color.d));

                }
                else if(a>=99999){
                    a=0;
                    tx1.setText(String.valueOf(0));
                    Toast.makeText(MainActivity.this,"Counter is Reset",Toast.LENGTH_SHORT).show();

                }




            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               a=0;
               tx1.setText(String.valueOf(0));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(a>0){
                        a--;
                        tx1.setText(String.valueOf(a));
                    }
            }
        });
    }
}