package com.example.displaystringdataonebyone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button b1,b2;
    int i = 0;
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
        tv = findViewById(R.id.textView);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        String[] temp = getResources().getStringArray(R.array.abc);

        int len = temp.length;
        tv.setText("");
        tv.setText(temp[0].toString());

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((len-1)>i)
                {

                    i++;
                    tv.setText("");
                    tv.setText(temp[i]);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Record Not Avilable", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i>0) {
                    i--;
                    tv.setText("");
                    tv.setText(temp[i].toString());
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Record Not Avilable", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}