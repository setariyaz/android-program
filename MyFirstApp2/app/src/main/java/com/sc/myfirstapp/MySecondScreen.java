package com.sc.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MySecondScreen extends AppCompatActivity {

    EditText e1,e2,e3;
    TextView t1;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_second_screen);
        e1=findViewById(R.id.editTextText);
        e2=findViewById(R.id.editTextText2);
        e3=findViewById(R.id.editTextPhone);
        b1=findViewById(R.id.button3);
        b2=findViewById(R.id.button4);
        t1=findViewById(R.id.textView2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1=e1.getText().toString();
                String str2=e2.getText().toString();
                String str3=e3.getText().toString();
                t1.setText("Name "+str1+"\nCity "+str2+"\nPhone "+str3);

            }
        });
        b1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String str1=e1.getText().toString();
                String str2=e2.getText().toString();
                String str3=e3.getText().toString();
                String str4 = "Name "+str1+"\nCity "+str2+"\nPhone "+str3;
                Toast.makeText(getApplicationContext(),str4,Toast.LENGTH_LONG).show();
                return false;
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1=e1.getText().toString();
                String str2=e2.getText().toString();
                String str3=e3.getText().toString();
                String str4 = "Name "+str1+"\nCity "+str2+"\nPhone "+str3;
                Intent i = new Intent(getApplicationContext(), MyThirdScreen.class);
                i.putExtra("data",str4);
                startActivity(i);

            }
        });

    }
}