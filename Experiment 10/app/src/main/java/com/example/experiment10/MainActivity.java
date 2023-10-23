package com.example.experiment10;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText rollNum, name, marks;
    Button add, remove, update, view;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollNum = findViewById(R.id.studentRollNum);
        name = findViewById(R.id.studentName);
        marks = findViewById(R.id.studentMarks);

        add = findViewById(R.id.addStudent);
        remove = findViewById(R.id.removeStudent);
        update = findViewById(R.id.updateStudent);
        view = findViewById(R.id.viewStudent);

        db = new DatabaseHandler(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = rollNum.getText().toString();
                String n = name.getText().toString();
                String m = marks.getText().toString();

                Boolean verifyAdd = db.addStudentData(r, n, m);

                if (verifyAdd == true)
                    Toast.makeText(MainActivity.this, "New student added to database!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Error!! ~ New student not added to database", Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = rollNum.getText().toString();
                String n = name.getText().toString();
                String m = marks.getText().toString();

                Boolean verifyUpdate = db.updateStudentData(r, n, m);

                if (verifyUpdate == true)
                    Toast.makeText(MainActivity.this, "Student record updated in database!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Error!! ~ Student record not updated in database", Toast.LENGTH_SHORT).show();
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = rollNum.getText().toString();
                Boolean verifyRemove = db.removeStudentData(r);

                if (verifyRemove == true)
                    Toast.makeText(MainActivity.this, "Student record removed from database!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Error!! - Student record not removed from database", Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor result = db.fetchStudentData();

                if (result.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "No such entry exists!", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while (result.moveToNext()) {
                    buffer.append("Roll Number - " + result.getString(0) + "\n");
                    buffer.append("Name - " + result.getString(1) + "\n");
                    buffer.append("Marks - " + result.getString(2) + "\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setCancelable(true);
                builder.setTitle("Existing student records ~");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}
