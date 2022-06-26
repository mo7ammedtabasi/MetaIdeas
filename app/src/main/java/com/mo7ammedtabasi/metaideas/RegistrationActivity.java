package com.mo7ammedtabasi.metaideas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    EditText etFullName,etEmailAddress,etPhoneNumber,etPassword;
    Button btnRegisterNow;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        btnRegisterNow=findViewById(R.id.btnRegister);
        etFullName=findViewById(R.id.etFullName);
        etEmailAddress=findViewById(R.id.etEmailAddress);
        etPhoneNumber=findViewById(R.id.etPhoneNumber);
        etPassword=findViewById(R.id.etPassword);
        firebaseAuth = FirebaseAuth.getInstance();


        btnRegisterNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAddress=etEmailAddress.getText().toString().trim();
                String password=etPassword.getText().toString().trim();
                databaseReference= FirebaseDatabase.getInstance().getReference().child("Users");
                firebaseAuth.createUserWithEmailAndPassword(emailAddress,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()){
                           DatabaseReference newUser=databaseReference.child(firebaseUser.getUid());
                           newUser.child("Full Name").setValue(etFullName.getText().toString().trim());
                           newUser.child("Email Address").setValue(etEmailAddress.getText().toString().trim());
                           newUser.child("Phone Number").setValue(etPhoneNumber.getText().toString().trim());
                           newUser.child("Password").setValue(etPassword.getText().toString().trim());

                           Toast.makeText(RegistrationActivity.this, "Registration Successfully", Toast.LENGTH_LONG).show();
                           Intent goToLogin=new Intent(RegistrationActivity.this,MainActivity.class);
                           startActivity(goToLogin);
                       }
                    }
                });


            }
        });
    }
}