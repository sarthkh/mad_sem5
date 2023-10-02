package com.example.madm2practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class Web_View extends AppCompatActivity {

    ProgressBar progressBar;
    WebView webView;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        progressBar = findViewById(R.id.progress);
        webView = findViewById(R.id.webView);
        back = findViewById(R.id.back);

        back.setOnClickListener(v -> {
            Intent intent = new Intent(Web_View.this, MainActivity.class);
            startActivity(intent);
        });

        String urlToLoad = "https://about.google/contact-google/";

        webView.loadUrl(urlToLoad);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url = request.getUrl().toString();

                if (url.startsWith("tel:")) {
                    Intent telIntent = new Intent(Intent.ACTION_DIAL);
//                    telIntent.setData(Uri.parse(url));
                    telIntent.setData(Uri.parse("tel:" + "+919876543210"));
                    startActivity(telIntent);
                    return true;
                } else if (url.startsWith("mailto:")) {
                    Intent mailIntent = new Intent(Intent.ACTION_SENDTO);
//                    mailIntent.setData(Uri.parse(url));
                    mailIntent.setData(Uri.parse("mailto:" + "sarthakhandelwal@gmail.com"));
                    startActivity(mailIntent);
                    return true;
                }

                return false;
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progressBar.setProgress(newProgress);
            }
        });
    }
}