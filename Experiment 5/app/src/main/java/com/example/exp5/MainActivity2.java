package com.example.exp5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity2 extends AppCompatActivity {

    private WebView wV;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button back = findViewById(R.id.back);

        back.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
        });

        String urlToLoad = "https://about.google/contact-google/";
        wV = findViewById(R.id.webView);
        ProgressBar pB = findViewById(R.id.loading_progressBar);

        wV.loadUrl(urlToLoad);
        wV.setWebViewClient(new WebViewClient());
        wV.getSettings().setJavaScriptEnabled(true);

        wV.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url = request.getUrl().toString();

                if (url.startsWith("tel:")) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
//                    intent.setData(Uri.parse(url));
                    intent.setData(Uri.parse("tel:"+"+919876543210"));
                    startActivity(intent);
                    return true;
                } else if (url.startsWith("mailto:")) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
//                    intent.setData(Uri.parse(url));
                    intent.setData(Uri.parse("mailto:"+"random@gmail.com"));
                    startActivity(intent);
                    return true;
                }

                return false;
            }
        });


        wV.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                pB.setProgress(newProgress);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (wV.canGoBack())
        {
            wV.goBack();
        } else {
            super.onBackPressed();
        }

    }
}