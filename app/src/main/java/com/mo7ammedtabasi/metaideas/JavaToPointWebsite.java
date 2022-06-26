package com.mo7ammedtabasi.metaideas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class JavaToPointWebsite extends AppCompatActivity {

    WebView webViewJavaToPointWebsite;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_to_point_website);

        webViewJavaToPointWebsite=findViewById(R.id.webViewJavaToPointWebsite);

        webViewJavaToPointWebsite.getSettings().setJavaScriptEnabled(true);
        webViewJavaToPointWebsite.setWebViewClient(new WebViewClient());
        webViewJavaToPointWebsite.loadUrl("https://www.javatpoint.com/java-tutorial");
    }
}