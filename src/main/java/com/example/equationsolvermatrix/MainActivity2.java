package com.example.equationsolvermatrix;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

import Jama.Matrix;

public class MainActivity2 extends AppCompatActivity {

    EditText et1, et2, et3, et4, et5, et6;
    TextView tv;
    Button bt, bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et1 = findViewById(R.id.editTextTextPersonName4);
        et2 = findViewById(R.id.editTextTextPersonName);
        et3 = findViewById(R.id.editTextTextPersonName3);
        et4 = findViewById(R.id.editTextTextPersonName2);
        et5 = findViewById(R.id.editTextTextPersonName12);
        et6 = findViewById(R.id.editTextTextPersonName10);

        tv = findViewById(R.id.textView);
        bt = findViewById(R.id.button);
        bt1 = findViewById(R.id.button4);

        bt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                double x1, x2, x3, x4, c1, c2;
                x1 = et1.getText().toString().isEmpty() ? 0 : Double.parseDouble(et1.getText().toString());
                x2 = et2.getText().toString().isEmpty() ? 0 : Double.parseDouble(et2.getText().toString());
                x3 = et3.getText().toString().isEmpty() ? 0 : Double.parseDouble(et3.getText().toString());
                x4 = et4.getText().toString().isEmpty() ? 0 : Double.parseDouble(et4.getText().toString());
                c1 = et5.getText().toString().isEmpty() ? 0 : Double.parseDouble(et5.getText().toString());
                c2 = et6.getText().toString().isEmpty() ? 0 : Double.parseDouble(et6.getText().toString());

                DecimalFormat df = new DecimalFormat("#.#####");

                if((x1*x4 - x2*x3) != 0){
                    double[][] lhsArray = {{x1, x2}, {x3, x4}};
                    double[] rhsArray = {c1, c2};
                    //Creating Matrix Objects with arrays
                    Matrix lhs = new Matrix(lhsArray);
                    Matrix rhs = new Matrix(rhsArray, 2);
                    //Calculate Solved Matrix
                    Matrix ans = lhs.solve(rhs);
                    String x = df.format(ans.get(0, 0));
                    String y = df.format(ans.get(1, 0));

                    tv.setText("x = " + x + "\ny = " + y);
                }
                else{
                    Toast.makeText(MainActivity2.this, "This system of equations is not solvable.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });
    }
    public void openActivity1(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}