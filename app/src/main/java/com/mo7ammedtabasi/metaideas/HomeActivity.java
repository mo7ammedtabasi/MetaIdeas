package com.mo7ammedtabasi.metaideas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnCalculator,btnRandomHighestMountains,btnRestaurant,btnDogOrCatQuiz,btnJavaToPointWebsite
            ,btnCV,btnTemperatureConverter,btnMediaPlayer,btnConnect3,btnGoogleMap,btnFakeAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnCalculator=findViewById(R.id.btn_calculatorApp);
        btnRandomHighestMountains=findViewById(R.id.btn_randomHighestMountains);
        btnRestaurant=findViewById(R.id.btn_restaurant);
        btnDogOrCatQuiz=findViewById(R.id.btn_dogOrCat);
        btnJavaToPointWebsite=findViewById(R.id.btn_javaToPointWebsite);
        btnCV=findViewById(R.id.btn_cv);
        btnTemperatureConverter=findViewById(R.id.btn_TemperatureConverter);
        btnMediaPlayer=findViewById(R.id.btn_ExoPlayer);
        btnConnect3=findViewById(R.id.btn_Connect3);
        btnGoogleMap=findViewById(R.id.btnGoogleMap);
        btnFakeAPI=findViewById(R.id.btnFakeAPI);
        btnCalculator.setOnClickListener(this);
        btnRandomHighestMountains.setOnClickListener(this);
        btnRestaurant.setOnClickListener(this);
        btnDogOrCatQuiz.setOnClickListener(this);
        btnJavaToPointWebsite.setOnClickListener(this);
        btnCV.setOnClickListener(this);
        btnTemperatureConverter.setOnClickListener(this);
        btnMediaPlayer.setOnClickListener(this);
        btnConnect3.setOnClickListener(this);
        btnGoogleMap.setOnClickListener(this);
        btnFakeAPI.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_calculatorApp:
                Intent goToCalculator=new Intent(this,CalculatorActivity.class);
                startActivity(goToCalculator);
                break;
            case R.id.btn_randomHighestMountains:
                Intent goToRandomHighestMountains=new Intent(this,RandomHighestMountains.class);
                startActivity(goToRandomHighestMountains);
                break;
            case R.id.btn_restaurant:
                Intent goToRestaurant=new Intent(this,RestaurantActivity.class);
                startActivity(goToRestaurant);
                break;
            case R.id.btn_dogOrCat:
                Intent goToDogOrCatQuiz=new Intent(this,DogOrCatQuiz.class);
                startActivity(goToDogOrCatQuiz);
                break;
            case R.id.btn_javaToPointWebsite:
                Intent goToJavaToPointWebsite=new Intent(this,JavaToPointWebsite.class);
                startActivity(goToJavaToPointWebsite);
                break;
            case R.id.btn_cv:
                Intent goToPDFView=new Intent(this,PDFView.class);
                startActivity(goToPDFView);
                break;
            case R.id.btn_TemperatureConverter:
                 Intent goToTemperatureConverter=new Intent(this,TemperatureConverter.class);
                 startActivity(goToTemperatureConverter);
                 break;
            case R.id.btn_ExoPlayer:
                Intent goToExoPlayer=new Intent(this,ExoPlayer.class);
                startActivity(goToExoPlayer);
                break;
            case R.id.btn_Connect3:
                Intent goToConnect3=new Intent(this,Connect3.class);
                startActivity(goToConnect3);
                break;
            case R.id.btnGoogleMap:
                Intent goToGoogleMap=new Intent(this,MapsActivity.class);
                startActivity(goToGoogleMap);
                break;
            case R.id.btnFakeAPI:
                Intent goToFakeAPI=new Intent(this,FakeAPI.class);
                startActivity(goToFakeAPI);
                break;





        }
    }
}