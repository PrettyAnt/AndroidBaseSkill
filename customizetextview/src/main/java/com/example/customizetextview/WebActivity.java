package com.example.customizetextview;

import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//账单分期里的注意事项所显示的webview
public class WebActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView  webView;
    private TextView tv_title;
    private View     btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_activity);
        initView();
    }


    private void initView() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_back = findViewById(R.id.btn_back);
        webView = (WebView) findViewById(R.id.web);
        btn_back.setOnClickListener(this);
        webView.clearCache(false);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLightTouchEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });
        Intent intent = getIntent();
        String url    = intent.getStringExtra("url");
        webView.loadUrl(url);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
