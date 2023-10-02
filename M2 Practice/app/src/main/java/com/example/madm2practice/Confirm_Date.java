package com.example.madm2practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Confirm_Date extends AppCompatActivity {

    TextView selectedDate;
    Button back, change;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_date);

        selectedDate = findViewById(R.id.textView2);
        back = findViewById(R.id.back);
        change = findViewById(R.id.change);

        Bundle bundle = getIntent().getExtras();
        date = bundle.getString("date");

        selectedDate.setText(date);

        back.setOnClickListener(v -> {
            Intent backIntent = new Intent(Confirm_Date.this, MainActivity.class);
            startActivity(backIntent);
        });

        change.setOnClickListener(v -> {
            SimpleDateFormat format = new SimpleDateFormat("dd-LLL-yyyy", Locale.getDefault());
            try {
                Date setDate = format.parse(date);
                MaterialDatePicker<Long> materialDatePicker = MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Select Date")
                        .setSelection(setDate.getTime())
                        .build();

                materialDatePicker.addOnPositiveButtonClickListener(selection -> {
                    date = new SimpleDateFormat(
                            "dd-LLL-yyyy", Locale.getDefault())
                            .format(new Date(selection));
                    selectedDate.setText(date);
                });

                materialDatePicker.show(getSupportFragmentManager(), "tag");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }
}
