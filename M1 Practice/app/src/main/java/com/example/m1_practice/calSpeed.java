package com.example.m1_practice;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class calSpeed extends AppCompatActivity {
    float d, t;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speed);

        EditText time = findViewById(R.id.enterTimeSpeed);
        EditText distance = findViewById(R.id.enterDistanceSpeed);
        Button calculate = findViewById(R.id.calculateButton);
        Button back = findViewById(R.id.back);
        TextView result = findViewById(R.id.resultDisplay);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if inputs are empty
                if(!distance.getText().toString().isEmpty() && !time.getText().toString().isEmpty()) {
                    d = Float.parseFloat(distance.getText().toString());
                    t = Float.parseFloat(time.getText().toString());
                    s = String.valueOf(d/t);
                    result.setText(s);
                } else {
                    // Show error message
//                    result.setText("Please enter both distance and time");
                    AlertDialog alert = new AlertDialog.Builder(calSpeed.this).create();
                    alert.setTitle("hello!");
                    alert.setMessage("how are you?");
                    alert.setButton(DialogInterface.BUTTON_POSITIVE, "Fine", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(calSpeed.this, "Nice :)", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alert.setButton(DialogInterface.BUTTON_NEGATIVE, "Sad", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(calSpeed.this, "Damn TC :)", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alert.show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(calSpeed.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
