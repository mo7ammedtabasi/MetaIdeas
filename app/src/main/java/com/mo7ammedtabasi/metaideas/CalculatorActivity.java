package com.mo7ammedtabasi.metaideas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {


    EditText etFirstNumber, etSecondNumber;
    Button btnAddition, btnSubtraction, btnMultiplication, btnDivision, btnResetValues;
    TextView tvResult;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        etFirstNumber = findViewById(R.id.etFirstNumber);
        etSecondNumber = findViewById(R.id.etSecondNumber);
        btnAddition = findViewById(R.id.btn_addition);
        btnSubtraction = findViewById(R.id.btn_subtraction);
        btnMultiplication = findViewById(R.id.btn_multiplication);
        btnDivision = findViewById(R.id.btn_division);
        btnResetValues = findViewById(R.id.btn_resetValues);
        tvResult = findViewById(R.id.tv_result);
        btnAddition.setOnClickListener(this);
        btnSubtraction.setOnClickListener(this);
        btnMultiplication.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnResetValues.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View view) {
        String firstNumberValue = etFirstNumber.getText().toString().trim();
        String secondNumberValue = etSecondNumber.getText().toString().trim();
        if (firstNumberValue.isEmpty() && secondNumberValue.isEmpty()) {
            Toast.makeText(this, "Please Enter Values", Toast.LENGTH_SHORT).show();
        } else {
            double firstNumberValueDouble = Double.parseDouble(firstNumberValue);
            double secondNumberValueDouble = Double.parseDouble(secondNumberValue);
            switch (view.getId()) {
                case R.id.btn_addition:
                    operation = String.valueOf(firstNumberValueDouble + secondNumberValueDouble);
                    tvResult.setText("The Result is: "+operation);
                    break;
                case R.id.btn_subtraction:
                    operation = String.valueOf(firstNumberValueDouble - secondNumberValueDouble);
                    tvResult.setText("The Result is: "+operation);
                    break;
                case R.id.btn_multiplication:
                    operation = String.valueOf(firstNumberValueDouble * secondNumberValueDouble);
                    tvResult.setText("The Result is: "+operation);
                    break;
                case R.id.btn_division:
                    operation = String.valueOf(firstNumberValueDouble / secondNumberValueDouble);
                    tvResult.setText("The Result is: "+operation);
                    break;
                case R.id.btn_resetValues:
                    etFirstNumber.setText("");
                    etSecondNumber.setText("");
                    break;
            }
        }
    }
}