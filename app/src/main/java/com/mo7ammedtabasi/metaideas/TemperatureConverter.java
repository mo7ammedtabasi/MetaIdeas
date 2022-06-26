package com.mo7ammedtabasi.metaideas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TemperatureConverter extends AppCompatActivity implements View.OnClickListener{

    EditText etFahrenheit,etCelsius;
    Button btnConvert,btnResetValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);

        etFahrenheit=findViewById(R.id.etFahrenheit);
        etCelsius=findViewById(R.id.etCelsius);
        btnConvert=findViewById(R.id.btnConvert);
        btnResetValues=findViewById(R.id.btn_resetTemperatureValues);
        btnConvert.setOnClickListener(this);
        btnResetValues.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        String fahrenheitString= etFahrenheit.getText().toString().trim();
        String celsiusString= etCelsius.getText().toString().trim();
        switch (view.getId()){
            case R.id.btnConvert:
                if (!fahrenheitString.isEmpty() && celsiusString.isEmpty()){
                    double fahrenheitDouble= Double.parseDouble(fahrenheitString);
                    String result=String.valueOf((fahrenheitDouble-32)/1.8);
                    etCelsius.setText(result);
                } else if (fahrenheitString.isEmpty() && !celsiusString.isEmpty()){
                    double celsiusDouble= Double.parseDouble(celsiusString);
                    String result=String.valueOf((celsiusDouble+32)*1.8);
                    etFahrenheit.setText(result);
                } else if (!fahrenheitString.isEmpty() && !celsiusString.isEmpty()) {
                    Toast.makeText(this, "Pleas delete one of the values", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Please enter values", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_resetTemperatureValues:
                if (fahrenheitString.isEmpty() && celsiusString.isEmpty()){
                    Toast.makeText(this, "There is no values to reset", Toast.LENGTH_SHORT).show();
                } else{
                    etFahrenheit.setText("");
                    etCelsius.setText("");
                }
        }
    }
}