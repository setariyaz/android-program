package com.example.generateage;

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

import java.time.LocalDate;
import java.time.Period;

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
        EditText e1,e2,e3;
        TextView tx1;

        b1=findViewById(R.id.button);
        e1=findViewById(R.id.editTextText3);
        e2=findViewById(R.id.editTextText4);
        e3=findViewById(R.id.editTextText5);
        tx1=findViewById(R.id.textView);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = e1.getText().toString();
                String month = e2.getText().toString();
                String year = e3.getText().toString();

                if (date.isEmpty() || month.isEmpty() || year.isEmpty()) {
                    Toast.makeText(MainActivity.this, "TEXT BOX IS EMPTY", Toast.LENGTH_SHORT).show();
                }

                    int sdate = Integer.parseInt(date);
                    int smonth = Integer.parseInt(month);
                    int syear = Integer.parseInt(year);

                    LocalDate today = LocalDate.now();
                    LocalDate birthdate = LocalDate.of(syear, smonth, sdate);
                if (birthdate.isAfter(today)) {
                    Toast.makeText(MainActivity.this, "Birth date cannot be in the future!", Toast.LENGTH_SHORT).show();

                }

                Period age = Period.between(birthdate, today);
                String result = "Your Age:\n" +
                        age.getYears() + " Years\n" +
                        age.getMonths() + " Months\n" +
                        age.getDays() + " Days";
                tx1.setText(result);
            }
        });


    }
}