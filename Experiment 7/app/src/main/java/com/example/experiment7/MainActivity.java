package com.example.experiment7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String setDate, setTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView dateText = findViewById(R.id.textView3);
        TextView timeText = findViewById(R.id.textView4);
        ImageView imageView = findViewById(R.id.image);
        Button dateButton = findViewById(R.id.datePicker);
        Button timeButton = findViewById(R.id.timePicker);
        Button confirmButton = findViewById(R.id.confirm);

        imageView.setImageResource(R.drawable.cs);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialDatePicker<Long> materialDatePicker = MaterialDatePicker.Builder
                        .datePicker().setTitleText("Select a Date")
                        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                        .build();

                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
                    @Override
                    public void onPositiveButtonClick(Long selection) {
                        setDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date(selection));
                        dateText.setText(setDate);
                    }
                });
                materialDatePicker.show(getSupportFragmentManager(), "tag");
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialTimePicker materialTimePicker = new MaterialTimePicker.Builder()
                        .setTimeFormat(TimeFormat.CLOCK_12H)
                        .setHour(12)
                        .setMinute(0)
                        .setInputMode(MaterialTimePicker.INPUT_MODE_CLOCK)
                        .setTitleText("Select a Time")
                        .build();

                materialTimePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setTime = MessageFormat.format("{0}:{1}",
                                String.format(Locale.getDefault(), "%02d", materialTimePicker.getHour()),
                                String.format(Locale.getDefault(), "%02d", materialTimePicker.getMinute()));
                        timeText.setText(setTime);
                    }
                });
                materialTimePicker.show(getSupportFragmentManager(), "tag");
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setDate == null || setDate.isEmpty() || setTime == null || setTime.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please select a date and time", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent1 = new Intent(MainActivity.this, Confirmation.class);
                    intent1.putExtra("date", setDate);
                    intent1.putExtra("time", setTime);
                    startActivity(intent1);
                }
            }
        });
    }
}
