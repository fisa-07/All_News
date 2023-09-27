package com.example.allnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class Web_view_activity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.web_id);

        Intent intent = getIntent();
        String URL = intent.getStringExtra("url");

        try{
            webView.loadUrl(URL);
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"Issues in loading",Toast.LENGTH_SHORT).show();
        }
    }
}