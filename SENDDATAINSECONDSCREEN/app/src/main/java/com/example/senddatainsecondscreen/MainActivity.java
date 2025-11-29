package com.example.senddatainsecondscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
        Button b1,b2;
        EditText t1,t2,t3;
        TextView tx1;
        b1=findViewById(R.id.button4);
        b2=findViewById(R.id.button3);
        t1=findViewById(R.id.editTextText);
        t2=findViewById(R.id.editTextText2);
        t3=findViewById(R.id.editTextPhone);
        tx1=findViewById(R.id.textView);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1=t1.getText().toString();
                String str2=t2.getText().toString();
                String str3=t3.getText().toString();
                String data[]={str1,str2,str3};
                tx1.setText("name:"+data[0]+"\ncity:"+data[1]+"\nphone:"+data[2]);
            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1=t1.getText().toString();
                String str2=t2.getText().toString();
                String str3=t3.getText().toString();
                String data[]={str1,str2,str3};
                Intent i=new Intent(getApplicationContext(), mysecondscreen.class);
                i.putExtra("data",data);
                startActivity(i);




            }
        });

    }
}