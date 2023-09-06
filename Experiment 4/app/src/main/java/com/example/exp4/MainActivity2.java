package com.example.exp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    String[] details = {
            "Sarthak Khandewal",
            "9876543210",
            "sarthak.khandelwal419@nmims.edu.in",
            "Google Search",
            "Android Tutoral"
    };

    int[] images =  {
            R.drawable.user,
            R.drawable.phone,
            R.drawable.email,
            R.drawable.search,
            R.drawable.tutorial
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView listView = findViewById(R.id.customListView);
        customBaseAdapter cba = new customBaseAdapter(getApplicationContext(), details, images);
        listView.setAdapter(cba);

        Button back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity2.this, "Clicked " + details[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}