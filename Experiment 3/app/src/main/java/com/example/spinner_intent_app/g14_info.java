package com.example.spinner_intent_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class g14_info extends AppCompatActivity {
    private Button back;
    private ImageView image;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g14_info);

        back = findViewById(R.id.back);
        image = findViewById(R.id.g14Image);
        info = findViewById(R.id.g14Info);

        image.setImageResource(R.drawable.g14);
        info.setText("ASUS ROG Zephyrus G14 features the latest-and-greatest in AMD hardware fitted inside its impressive 14-inch form factor. The brand new Ryzen 9 6900HS processor alongside DDR5 memory and an RX 6000S series dedicated graphics card is impressive.");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(g14_info.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
