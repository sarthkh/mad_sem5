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

public class calDistance extends AppCompatActivity {
    float s, t;
    String res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.distance);

        Button calculate = findViewById(R.id.calculateButton);
        EditText speed = findViewById(R.id.enterSpeedDistance);
        EditText time = findViewById(R.id.enterTimeDistance);
        TextView result = findViewById(R.id.resultDisplay);
        Button back = findViewById(R.id.back);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!speed.getText().toString().isEmpty() && !time.getText().toString().isEmpty()) {
                    s = Float.parseFloat(speed.getText().toString());
                    t = Float.parseFloat(time.getText().toString());
                    res = String.valueOf(s*t);
                    result.setText(res);
                }
                else {
//                    Toast.makeText(getBaseContext(), "Please enter both distance and time", Toast.LENGTH_SHORT).show();
                    AlertDialog alertDialog = new AlertDialog.Builder(calDistance.this).create();
//                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("Please enter both speed and time");
                    alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(calDistance.this, "try again :)", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(calDistance.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    alertDialog.show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(calDistance.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
