package com.example.harshbhut42.error_404;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebViewClient;

public class WebView extends AppCompatActivity {

    private android.webkit.WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mWebview = (android.webkit.WebView) findViewById(R.id.activity_WebView);
        mWebview.setWebViewClient(new WebViewClient());
        mWebview.loadUrl("https://daiict-materials.000webhostapp.com/");

    }
}
