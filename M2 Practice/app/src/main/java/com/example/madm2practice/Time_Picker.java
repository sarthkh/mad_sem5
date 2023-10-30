package com.example.madm2practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.text.MessageFormat;
import java.util.Locale;

public class Time_Picker extends AppCompatActivity {

    TextView selectedTime;
    Button open, back, confirm;
    String setTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        selectedTime = findViewById(R.id.textView3);
        open = findViewById(R.id.open);
        back = findViewById(R.id.back);
        confirm = findViewById(R.id.confirm);

        back.setOnClickListener(v -> {
            Intent backIntent = new Intent(Time_Picker.this, MainActivity.class);
            startActivity(backIntent);
        });

        open.setOnClickListener(v -> {
            MaterialTimePicker materialTimePicker = new MaterialTimePicker.Builder()
                    .setTimeFormat(TimeFormat.CLOCK_12H)
                    .setTitleText("Select Time")
                    .setHour(12)
                    .setMinute(0)
                    .setInputMode(MaterialTimePicker.INPUT_MODE_CLOCK)
                    .build();

            materialTimePicker.addOnPositiveButtonClickListener(v1 -> {
                setTime = MessageFormat.format(
                        "{0}:{1}",
                        String.format(Locale.getDefault(), "%02d", materialTimePicker.getHour()),
                        String.format(Locale.getDefault(), "%02d", materialTimePicker.getMinute())
                );
                selectedTime.setText(setTime);
            });

            materialTimePicker.show(getSupportFragmentManager(), "tag");
        });

        confirm.setOnClickListener(v -> {
            if (setTime == null || setTime.isEmpty()) {
                Toast.makeText(Time_Picker.this, "Please select a time", Toast.LENGTH_SHORT).show();
            } else {
                Intent confirmIntent = new Intent(Time_Picker.this, Confirm_Time.class);
                confirmIntent.putExtra("time", setTime);
                startActivity(confirmIntent);
            }
        });
    }
}