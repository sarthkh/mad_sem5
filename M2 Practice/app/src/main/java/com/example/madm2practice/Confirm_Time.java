package com.example.madm2practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Locale;

public class Confirm_Time extends AppCompatActivity {

    TextView selectedTime;
    Button back, change;
    String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_time);

        selectedTime = findViewById(R.id.textView2);
        back = findViewById(R.id.back);
        change = findViewById(R.id.change);

        Bundle bundle = getIntent().getExtras();
        time = bundle.getString("time");

        selectedTime.setText(time);

        back.setOnClickListener(v -> {
            Intent backIntent = new Intent(Confirm_Time.this, MainActivity.class);
            startActivity(backIntent);
        });

        change.setOnClickListener(v -> {
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);

            MaterialTimePicker materialTimePicker = new MaterialTimePicker.Builder()
                    .setTimeFormat(TimeFormat.CLOCK_12H)
                    .setHour(hour)
                    .setMinute(minute)
                    .build();

            materialTimePicker.addOnPositiveButtonClickListener(v1 -> {
                int selectedHour = materialTimePicker.getHour();
                int selectedMinute = materialTimePicker.getMinute();
                time = String.format(Locale.getDefault(), "%02d:%02d", selectedHour, selectedMinute);
                selectedTime.setText(time);
            });

            materialTimePicker.show(getSupportFragmentManager(), "tag");
        });
    }
}