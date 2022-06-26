package com.mo7ammedtabasi.metaideas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class RandomHighestMountains extends AppCompatActivity {

    TextView tvRandomMountain;
    Button btnGenerateRandomMountain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_highest_mountains);

        tvRandomMountain=findViewById(R.id.tv_randomMountain);
        btnGenerateRandomMountain=findViewById(R.id.btn_generateRandomMountain);
        btnGenerateRandomMountain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mountainNames[] ={"Everest","Colorado","Alps","El mo2atam","Gapl Tarek","saint Cathrien","Gapl Mousa"};
                Random random=new Random();
                int index =random.nextInt(mountainNames.length);
                tvRandomMountain.setText(mountainNames[index]);
            }
        });
    }
}