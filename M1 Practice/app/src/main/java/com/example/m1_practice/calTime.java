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

public class calTime extends AppCompatActivity {
    float d, s;
    String res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time);

        Button calculate = findViewById(R.id.calculateButton);
        Button back = findViewById(R.id.back);
        EditText distance = findViewById(R.id.enterDistanceTime);
        EditText speed = findViewById(R.id.enterSpeedTime);
        TextView result = findViewById(R.id.resultDisplay);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!distance.getText().toString().isEmpty() && !speed.getText().toString().isEmpty()) {
                    d = Float.parseFloat(distance.getText().toString());
                    s = Float.parseFloat(speed.getText().toString());
                    res = String.valueOf(d/s);
                    result.setText(res);
                }
                else {
//                    result.setText("Please enter both distance and time");
                    AlertDialog alertDialog = new AlertDialog.Builder(calTime.this).create();
                    alertDialog.setTitle("hi again");
                    alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "hello", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(calTime.this, ":)))", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "get lost", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(calTime.this, ":(((", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alertDialog.show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(calTime.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
