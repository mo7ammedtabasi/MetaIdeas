 package com.mo7ammedtabasi.metaideas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

 public class ForgetPasswordActivity extends AppCompatActivity {

    Button btnResettingLing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        btnResettingLing=findViewById(R.id.btnSendRestLink);
        btnResettingLing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ForgetPasswordActivity.this, "Link sent, Pleas Check your mail", Toast.LENGTH_LONG).show();
            }
        });
    }
}