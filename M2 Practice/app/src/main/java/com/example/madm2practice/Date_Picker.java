package com.example.madm2practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Date_Picker extends AppCompatActivity {

    TextView selectedDate;
    Button open, back, confirm;
    String setDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        selectedDate = findViewById(R.id.textView3);
        open = findViewById(R.id.open);
        back = findViewById(R.id.back);
        confirm = findViewById(R.id.confirm);

        back.setOnClickListener(v -> {
            Intent backIntent = new Intent(Date_Picker.this, MainActivity.class);
            startActivity(backIntent);
        });

        open.setOnClickListener(v -> {
            MaterialDatePicker<Long> materialDatePicker = MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select date")
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                    .build();

            materialDatePicker.addOnPositiveButtonClickListener(selection -> {
                setDate = new SimpleDateFormat("dd-LLL-yyyy", Locale.getDefault()).format(new Date(selection));
                selectedDate.setText(setDate);
            });

            materialDatePicker.show(getSupportFragmentManager(), "tag");
        });

        confirm.setOnClickListener(v -> {
            Intent confirmIntent = new Intent(Date_Picker.this, Confirm_Date.class);
            confirmIntent.putExtra("date", setDate);
            startActivity(confirmIntent);
        });
    }
}