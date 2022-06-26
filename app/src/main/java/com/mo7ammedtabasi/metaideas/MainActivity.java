package com.mo7ammedtabasi.metaideas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean pressTwiceToExit=false;
    TextView tv_forgetPassword,tv_registerNow;
    Button btnLogin;
    EditText etEmailAddress,etPassword;
    CheckBox chkRememberMe;
    AlertDialog.Builder builderAlertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmailAddress=findViewById(R.id.etEmailAddress);
        chkRememberMe=findViewById(R.id.chk_rememberMe);
        etPassword=findViewById(R.id.etPassword);
        tv_forgetPassword=findViewById(R.id.tv_forgetPassword);
        tv_registerNow=findViewById(R.id.tv_register);
        btnLogin=findViewById(R.id.btnLogin);

        builderAlertDialog=new AlertDialog.Builder(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Welcome to your app", Toast.LENGTH_SHORT).show();
                Intent goToCalculatorActivity = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(goToCalculatorActivity);
            }
        });

        tv_forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToForgetPassword=new Intent(MainActivity.this,ForgetPasswordActivity.class);
                startActivity(goToForgetPassword);
            }
        });

        tv_registerNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToRegisterActivity=new Intent(MainActivity.this,RegistrationActivity.class);
                startActivity(goToRegisterActivity);
            }
        });

        SharedPreferences rememberMe=getSharedPreferences("rememberMe",0);
        if (rememberMe.getBoolean("bool", false)){
            String emailAddress=rememberMe.getString("email","");
            etEmailAddress.setText(emailAddress);
            String Password=rememberMe.getString("password","");
            etPassword.setText(Password);
            chkRememberMe.setChecked(true);
        }

    }

//    @Override
//    public void onBackPressed() {
//        if (pressTwiceToExit){
//            super.onBackPressed();
//        } else {
//            pressTwiceToExit = true;
//            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    pressTwiceToExit = false;
//                }
//            },3000);
//        }
//    }


    @Override
    public void onBackPressed() {
        builderAlertDialog.setMessage("Do you want to exit").setIcon(R.drawable.twitter).setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        Toast.makeText(MainActivity.this, "Good bay", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                Toast.makeText(MainActivity.this, "Welcome again", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog=builderAlertDialog.create();
        alertDialog.setTitle("Exit");
        alertDialog.show();
//        super.onBackPressed();
    }

    public void rememberMe(View view) {
        SharedPreferences rememberMe=getSharedPreferences("rememberMe",0);
        SharedPreferences.Editor pen= rememberMe.edit();
        pen.putString("email",etEmailAddress.getText().toString().trim());
        pen.putString("password",etPassword.getText().toString().trim());
        pen.putBoolean("bool",true);
        pen.apply();
        Toast.makeText(this, "We Saved Your Data", Toast.LENGTH_SHORT).show();
        chkRememberMe.setChecked(true);
    }
}