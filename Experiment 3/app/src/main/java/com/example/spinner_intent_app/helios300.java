package com.example.spinner_intent_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class helios300 extends AppCompatActivity {
    private Button back;
    private ImageView image;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helios300_info);

        back = findViewById(R.id.back);
        image = findViewById(R.id.helios300Image);
        info = findViewById(R.id.helios300Info);

        info.setText("The Predator Helios 300 is a 12th gen gaming laptop with superior cooling technology, a blisteringly fast display, and a trove of performance-enhancing.");

        image.setImageResource(R.drawable.helios300);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(helios300.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
