package com.mahi.webjava;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView wview;
    EditText ed;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wview=findViewById(R.id.wview);
        wview.getSettings().setJavaScriptEnabled(true);
        wview.getSettings().setBuiltInZoomControls(true);
        wview.addJavascriptInterface(this,"and9am");
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait page is loading..");
        wview.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pDialog.show( );
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pDialog.dismiss(); }
            });
        ed=findViewById(R.id.ed1);
    }// onCreate

    public void load(View v) {


        switch (v.getId()){
            case R.id.bt:
                wview.loadUrl("https://www."+ed.getText().toString());
                  break;

            case  R.id.gl:
                wview.loadUrl("https://www.google.co.in");
                break;

            case  R.id.fb:
                wview.loadUrl("http://www.facebook.com");
                break;

            case R.id.you:
                wview.loadUrl("http://www.youtube.com");
                break;

            case R.id.html:
                wview.loadUrl("http://www.facebook.com/mahesh.love.771");
                break;
        }
    }
    @JavascriptInterface
    public void display(String name, String pass){
        Toast.makeText(this,
                name+"\t"+pass,Toast.LENGTH_LONG).show();
    }
}// main
