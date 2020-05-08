package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class num1 extends AppCompatActivity {

    Button hum , dev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num1);

        hum = findViewById(R.id.hum);
        dev = findViewById(R.id.dev);

        hum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(num1.this , MainActivity.class);
                intent.putExtra("play",2);
                startActivity(intent);
            }
        });
        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(num1.this , MainActivity.class);
                intent.putExtra("play",1);
                startActivity(intent);
            }
        });
    }
}
