package com.example.mad_exp_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView icon = findViewById(R.id.imageView);
        Button photo = findViewById(R.id.button1);
        Button video = findViewById(R.id.button2);

        icon.setImageResource(R.drawable.icon);

        photo.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity.this, Photo.class);
            startActivity(intent1);
        });

        video.setOnClickListener(view -> {
            Intent intent2 = new Intent(MainActivity.this, Video.class);
            startActivity(intent2);
        });


    }
}