package com.example.randomnumber;

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
        Button b1;
        EditText e1,e2;
        TextView tx1;

        b1=findViewById(R.id.button);
        e1=findViewById(R.id.editTextText);
        e2=findViewById(R.id.editTextText2);
        tx1=findViewById(R.id.textView);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1=e1.getText().toString();
                String n2=e2.getText().toString();

                int nm1=n1.length();
                int nm2=n2.length();

                tx1.setText("");
                if((nm1>0)&&(nm2>0)){
                    int s=Integer.parseInt(e1.getText().toString());
                    int e=Integer.parseInt(e2.getText().toString());
                    if(s<e){
                        int temp = (int) (Math.random() * ((s - e) + 1)) + e;
                        tx1.setText(String.valueOf(temp));
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Start Value Must Be Big Then End Value", Toast.LENGTH_LONG).show();
                    }
                }
                if((nm1>0) && (nm2==0))
                {
                    int s = Integer.parseInt(e1.getText().toString());
                    int temp = (int) (Math.random() * ((s - 100) + 1)) + 100;
                    tx1.setText(String.valueOf(temp));
                }
                if((nm1==0)&&(nm2>0))
                {
                    int e = Integer.parseInt(e2.getText().toString());
                    int temp = (int) (Math.random() * ((0 - e) + 1)) + e;
                    tx1.setText(String.valueOf(temp));
                }
                if((nm1==0)&&(nm2==0))
                {
                    int temp = (int) (Math.random() * 100);
                    tx1.setText(String.valueOf(temp));
                }
            }
        });
    }
}