package com.pe.polindustria.asistencia.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.pe.polindustria.asistencia.R;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView mWebview = new WebView(this);
        mWebview.loadUrl("http://ok.polindustria.com.pe/asistencia/public/");
        setContentView(mWebview);
    }
}
