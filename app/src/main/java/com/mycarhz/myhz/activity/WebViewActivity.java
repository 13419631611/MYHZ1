package com.mycarhz.myhz.activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mycarhz.myhz.R;
import com.mycarhz.myhz.application.MYHZApplication;
import com.mycarhz.myhz.constant.Constant;


public class WebViewActivity extends AppCompatActivity {
    private WebView webView;

    private String sum;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = (WebView) findViewById(R.id.wb_jzh);

        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        Intent intent=getIntent();
        sum=intent.getStringExtra("money");
        url=intent.getStringExtra("url");
        //  sum=intent.getStringExtra("money");

       // Log.i("url+money!!!!!!!!!!!!!!!!!!!!!!!!",url+"!!!"+sum);

        if (Constant.JZH_TOPUP.equals(url)) {

            webView.loadUrl("http://192.168.199.154:8080/app/appRecharge.do?auth={uid:'9207'}&&info={money:'"+sum+"'}");

            //  Log.i("uid",MYHZApplication.getUid());
            //webView.loadUrl(Constant.BASE + url + "?auth={uid:'" + MYHZApplication.getUid() + "'}"+"&&info={money:'"+sum+"'}");
        } else if (Constant.JZH_REGISTER.equals(url)){
            webView.loadUrl(Constant.BASE + url + "?auth={uid:'" + MYHZApplication.getUid() + "'}");
        }

        // webView.loadData("http://192.168.199.154:8080/app/appOpen.do?auth={uid:'9207'}", "text/html", "UTF-8");
    }

    @Override
    protected void onResume() {

        super.onResume();
    }
}
