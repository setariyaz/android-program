package com.example.showimagesonebyone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int index=0;
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


        ImageView img;
        Button b1,b2;


        int[] image={
                R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e
        };
        int len=image.length;

        img=findViewById(R.id.imageView);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);

        img.setImageResource(image[0]);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<(len-1))
                {
                    index++;
                    img.setImageResource(image[index]);
                }
                else
                {

                    Toast.makeText(MainActivity.this, "Image Not Avilabe", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index>0)
                {
                    index--;
                    img.setImageResource(image[index]);

                }
                else
                {

                    Toast.makeText(MainActivity.this, "Image Not Avilabe", Toast.LENGTH_SHORT).show();
                }

            }
        });





    }
}