package com.example.madm2practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ListView listView;
    String[] options = {
            "WebView",
            "Click Image",
            "Capture Video",
            "Date Picker",
            "Time Picker"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        listView = findViewById(R.id.listView);

        imageView.setImageResource(R.drawable.logo);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_dropdown_item_1line,
                options
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            switch (position) {
                case 0:
                    Intent webViewIntent = new Intent(MainActivity.this, Web_View.class);
                    startActivity(webViewIntent);
                    break;
                case 1:
                    Intent imageViewIntent = new Intent(MainActivity.this, Image_View.class);
                    startActivity(imageViewIntent);
                    break;
                case 2:
                    Intent videoViewIntent = new Intent(MainActivity.this, Video_View.class);
                    startActivity(videoViewIntent);
                    break;
                case 3:
                    Intent datePickerIntent = new Intent(MainActivity.this, Date_Picker.class);
                    startActivity(datePickerIntent);
                    break;
                case 4:
                    Intent timePickerIntent = new Intent(MainActivity.this, Time_Picker.class);
                    startActivity(timePickerIntent);
                    break;
            }
        });
    }
}
