package com.example.equationsolvermatrix;

import androidx.appcompat.app.AppCompatActivity;
import Jama.Matrix;
import java.lang.Math.*;
import java.text.DecimalFormat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2, et3, et4, et5, et6, et7, et8, et9, et10, et11, et12;
    TextView tv;
    Button bt, bt2, bt3;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.editTextTextPersonName4);
        et2 = findViewById(R.id.editTextTextPersonName);
        et3 = findViewById(R.id.editTextTextPersonName7);
        et4 = findViewById(R.id.editTextTextPersonName3);
        et5 = findViewById(R.id.editTextTextPersonName2);
        et6 = findViewById(R.id.editTextTextPersonName6);
        et7 = findViewById(R.id.editTextTextPersonName9);
        et8 = findViewById(R.id.editTextTextPersonName5);
        et9 = findViewById(R.id.editTextTextPersonName8);
        et10 = findViewById(R.id.editTextTextPersonName12);
        et11 = findViewById(R.id.editTextTextPersonName10);
        et12 = findViewById(R.id.editTextTextPersonName11);

        tv = findViewById(R.id.textView);
        bt = findViewById(R.id.button);
        bt2 = findViewById(R.id.button2);
        bt3 = findViewById(R.id.button3);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double x1, x2, x3, x4, x5, x6, x7, x8, x9, c1, c2, c3;
                x1 = et1.getText().toString().isEmpty() ? 0 : Double.parseDouble(et1.getText().toString());
                x2 = et2.getText().toString().isEmpty() ? 0 : Double.parseDouble(et2.getText().toString());
                x3 = et3.getText().toString().isEmpty() ? 0 : Double.parseDouble(et3.getText().toString());
                x4 = et4.getText().toString().isEmpty() ? 0 : Double.parseDouble(et4.getText().toString());
                x5 = et5.getText().toString().isEmpty() ? 0 : Double.parseDouble(et5.getText().toString());
                x6 = et6.getText().toString().isEmpty() ? 0 : Double.parseDouble(et6.getText().toString());
                x7 = et7.getText().toString().isEmpty() ? 0 : Double.parseDouble(et7.getText().toString());
                x8 = et8.getText().toString().isEmpty() ? 0 : Double.parseDouble(et8.getText().toString());
                x9 = et9.getText().toString().isEmpty() ? 0 : Double.parseDouble(et9.getText().toString());
                c1 = et10.getText().toString().isEmpty() ? 0 : Double.parseDouble(et10.getText().toString());
                c2 = et11.getText().toString().isEmpty() ? 0 : Double.parseDouble(et11.getText().toString());
                c3 = et12.getText().toString().isEmpty() ? 0 : Double.parseDouble(et12.getText().toString());

                DecimalFormat df = new DecimalFormat("#.#####");

                if(x1*(x5*x9 - x6*x8) - x2*(x4*x9 - x7*x6) + x3*(x4*x8 - x7*x5) != 0){
                    double[][] lhsArray = {{x1, x2, x3}, {x4, x5, x6}, {x7, x8, x9}};
                    double[] rhsArray = {c1, c2, c3};
                    //Creating Matrix Objects with arrays
                    Matrix lhs = new Matrix(lhsArray);
                    Matrix rhs = new Matrix(rhsArray, 3);
                    //Calculate Solved Matrix
                    Matrix ans = lhs.solve(rhs);
                    String x = df.format(ans.get(0, 0));
                    String y = df.format(ans.get(1, 0));
                    String z = df.format(ans.get(2, 0));

                    tv.setText("x = " + x + "\ny = " + y + "\nz = " + z);
                }
                else{
                    Toast.makeText(MainActivity.this, "This system of equations is not solvable.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Not available currently 🙂", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}