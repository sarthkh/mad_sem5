package com.example.mad_exp_12;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd, buttonSub, buttonMul, buttonDiv, buttonExp, buttonMod, buttonClr;
    EditText editTextNum1, editTextNum2;
    TextView textView;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdd = findViewById(R.id.add);
        buttonSub = findViewById(R.id.sub);
        buttonMul = findViewById(R.id.mul);
        buttonDiv = findViewById(R.id.div);
        buttonExp = findViewById(R.id.exp);
        buttonMod = findViewById(R.id.mod);
        buttonClr = findViewById(R.id.clr);
        editTextNum1 = findViewById(R.id.num1);
        editTextNum2 = findViewById(R.id.num2);
        textView = findViewById(R.id.ans);

        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonExp.setOnClickListener(this);
        buttonMod.setOnClickListener(this);
        buttonClr.setOnClickListener(this);
    }

    public int getIntFromEditText(EditText editText) {
        if (editText.getText().toString().equals("")) {
            Toast.makeText(this, "enter a number!", Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
//            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
//            alertDialog.setTitle("Error");
//            alertDialog.setMessage("Invalid input!");
//            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "yessir", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    Toast.makeText(MainActivity.this, "noice :)", Toast.LENGTH_SHORT).show();
//                }
//            });
//            alertDialog.show();
            return 0;
        } else {
            return Integer.parseInt(editText.getText().toString());
        }
    }

    @Override
    public void onClick(View v) {
        num1 = getIntFromEditText(editTextNum1);
        num2 = getIntFromEditText(editTextNum2);

        if(num1 == 0 || num2 == 0){
            return;
        }

// DEPRECIATED
//        switch (v.getId()) {
//            case R.id.add:
//                textView.setText("Answer = " + (num1 + num2));
//                break;
//            case R.id.sub:
//                textView.setText("Answer = " + (num1 - num2));
//                break;
//            case R.id.mul:
//                textView.setText("Answer = " + (num1 * num2));
//                break;
//            case R.id.div:
//                textView.setText("Answer = " + (num1 / num2));
//                break;
//        }

        int id = v.getId();
        if(id==R.id.add) {
            textView.setText("Answer = "+(num1+num2));
        }
        else if(id==R.id.sub) {
            textView.setText("Answer = "+(num1-num2));
        }
        else if(id==R.id.mul) {
            textView.setText("Answer = "+(num1*num2));
        }
        else if(id==R.id.div) {
            textView.setText("Answer = "+((float)num1/(float)num2));
        }
        else if(id==R.id.exp) {
            textView.setText("Answer = "+(Math.pow(num1,num2)));
        }
        else if(id==R.id.mod) {
            textView.setText("Answer = "+((float)num1%(float)num2));
        }
        else if(id==R.id.clr) {
            editTextNum1.setText("");
            editTextNum2.setText("");
            textView.setText("");
            editTextNum1.requestFocus();
        }
    }
}