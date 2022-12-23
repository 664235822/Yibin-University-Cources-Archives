package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    WebView webView;
    ImageView imageView;

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        webView = findViewById(R.id.webview);
        imageView = findViewById(R.id.imageView);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);

        /*打开的是新页面，如果希望在本页面打开，则需要配置以下信息,代码26-34*/
        webView.setWebViewClient(new WebViewClient(){
            @SuppressLint("NewApi")
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url = String.valueOf(request.getUrl());
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        imageView.setOnClickListener(view->{
            String url = editText.getText().toString().trim();
            webView.loadUrl(url);
        });
    }

    @SuppressLint("JavascriptInterface")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                webView.goForward();
                break;
            case R.id.btn2:
                webView.goBack();
                break;
            case R.id.btn3:
                webView.zoomIn();
                break;
            case R.id.btn4:
                webView.zoomOut();
                break;
            case R.id.btn5:
                String data = "<h1 style='color: red;'><ul><li>测试——1</li><li>测试——2</li><li>测试——3</li><li>测试——4</li><li>测试——5</li></ul></h1>";
                String mimeType = "text/html";
                String encoding = "utf-8";
                webView.loadData(data,mimeType,encoding);
                break;
            case R.id.btn6:
                String data2 = "<input type='button' onclick='object.showToast()' value='我是html中的按钮,点我的话,Android界面会弹出Toast'>";
                String mimeType2 = "text/html";
                String encoding2 = "utf-8";
                webView.loadData(data2,mimeType2,encoding2);
                /*获取设置*/
                WebSettings settings = webView.getSettings();
                /*设置允许js调用*/
                settings.setJavaScriptEnabled(true);
                webView.addJavascriptInterface(new MyObject(this),"object");
                break;
            default:break;
        }
    }

    private class MyObject {
        /*属性*/
        private Context context;
        /*构造函数*/
        public MyObject(Context context){
            this.context = context;
        }
        @JavascriptInterface
        public void showToast(){
            Toast.makeText(context, "看到我你就成功了", Toast.LENGTH_SHORT).show();
        }
    }
}
