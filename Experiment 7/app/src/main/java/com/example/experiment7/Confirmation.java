package com.example.experiment7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        TextView dateAndTime = findViewById(R.id.textView7);
        Button back = findViewById(R.id.back);

        Bundle bundle = getIntent().getExtras();

        String date = bundle.getString("date");
        String time = bundle.getString("time");

        dateAndTime.setText(date + " " + time);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Confirmation.this, MainActivity.class);
                startActivity(intent2);
            }
        });
    }
}