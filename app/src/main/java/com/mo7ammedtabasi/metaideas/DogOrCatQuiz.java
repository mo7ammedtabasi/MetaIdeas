package com.mo7ammedtabasi.metaideas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DogOrCatQuiz extends AppCompatActivity {

    RadioGroup rgQuestion1,rgQuestion2,rgQuestion3;
    RadioButton rbQuestion1,rbQuestion2,rbQuestion3;
    Button btnGetQuestionResult;
    TextView tvShowResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_or_cat_quiz);

        rgQuestion1=findViewById(R.id.rg_question1);
        rgQuestion2=findViewById(R.id.rg_question2);
        rgQuestion3=findViewById(R.id.rg_question3);
        rbQuestion1=findViewById(R.id.rb_never);
        btnGetQuestionResult=findViewById(R.id.btn_getQuizResult);
        tvShowResult=findViewById(R.id.tv_quizResult);

        btnGetQuestionResult.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
               int rbQuestion1Answer = rgQuestion1.getCheckedRadioButtonId();
               rbQuestion1 = findViewById(rbQuestion1Answer);
                int rbQuestion2Answer = rgQuestion2.getCheckedRadioButtonId();
                rbQuestion2 = findViewById(rbQuestion2Answer);
                int rbQuestion3Answer = rgQuestion3.getCheckedRadioButtonId();
                rbQuestion3 = findViewById(rbQuestion3Answer);

                if (rgQuestion1.getCheckedRadioButtonId() == -1 ||
                rgQuestion2.getCheckedRadioButtonId() == -1 ||
                rgQuestion3.getCheckedRadioButtonId() == -1){
                    Toast.makeText(DogOrCatQuiz.this, "Please Choose an Answer", Toast.LENGTH_SHORT).show();

                }else {
                    if (rbQuestion1.getText().toString().equalsIgnoreCase("NEVER") &&
                            rbQuestion2.getText().toString().equalsIgnoreCase("ALL THE TIME!") &&
                            rbQuestion3.getText().toString().equalsIgnoreCase("OCCASSIONALLY")){
                        tvShowResult.setText("YOU ARE A CAT PERSON");
                    }else if (rbQuestion1.getText().toString().equalsIgnoreCase("SOME TIMES") &&
                            rbQuestion2.getText().toString().equalsIgnoreCase("NOT PHYSICAL PERSON") &&
                            rbQuestion3.getText().toString().equalsIgnoreCase("MANY TIMES")){
                        tvShowResult.setText("YOU ARE A DOG PERSON");
                    }else if (rbQuestion1.getText().toString().equalsIgnoreCase("ALWAYS") &&
                            rbQuestion2.getText().toString().equalsIgnoreCase("NO") &&
                            rbQuestion3.getText().toString().equalsIgnoreCase("MAYBE")){
                        tvShowResult.setText("YOU ARE A 50% DOG PERSON AND 50% CAT PERSON");
                    }
                }
            }
        });
    }
}