package com.example.spinner_intent_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spin);
        image = findViewById(R.id.image);

        String[] gamingLaptops = {
                "Select a laptop",
                "Asus ROG Zephyrus G14",
                "Acer Predator Helios 300",
                "Razer Blade 14",
                "Alienware M16",
                "MSI Titan GT77",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, gamingLaptops);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0: image.setImageDrawable(null);
                            break;
                    case 1: /* image.setImageResource(R.drawable.g14); */
                            Intent g14_intent = new Intent(MainActivity.this, g14_info.class);
                            startActivity(g14_intent);
                            break;
                    case 2: /* image.setImageResource(R.drawable.helios300); */
                            Intent helios300_intent = new Intent(MainActivity.this, helios300.class);
                            startActivity(helios300_intent);
                            break;
                    case 3: image.setImageResource(R.drawable.blade14);
                            break;
                    case 4: image.setImageResource(R.drawable.m16);
                            break;
                    case 5: image.setImageResource(R.drawable.gt77);
                            break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // DO ABSOLUTELY NOTHING WHEN NOTHING IS SELECTED
            }
        });
    }
}