package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1;
    Button btn2;
    TextView show;

    static class MyHandler extends Handler {
        private WeakReference<MainActivity> mainActivity;

        public MyHandler(WeakReference<MainActivity> mainActivity) {
            this.mainActivity = mainActivity;
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == 1) {
                mainActivity.get().show.setText(msg.obj.toString());
            }
        }
    }

    private MyHandler handler = new MyHandler(new WeakReference<>(this));

    private OkHttpClient okHttpClient;/*属性*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        show = findViewById(R.id.show);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        /*实例化一个对象*/
//        okHttpClient = OkHttpClient()// 创建默认的OkHttpClient对象
        final Map<String, List<Cookie>> cookieStore = new HashMap<>();
        okHttpClient = new OkHttpClient.Builder().cookieJar(new CookieJar() {
            @Override
            public void saveFromResponse(@NonNull HttpUrl httpUrl, @NonNull List<Cookie> list) {
                cookieStore.put(httpUrl.host(), list);
            }

            @Override
            public List<Cookie> loadForRequest(@NonNull HttpUrl httpUrl) {
                List<Cookie> cookies = cookieStore.get(httpUrl.host());
                return cookies == null ? new ArrayList<Cookie>() : cookies;
            }
        }).build();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                fwwy();
                break;
            case R.id.btn2:
                dlxt();
                break;
            default:
                break;
        }
    }

    /**
     * 访问网页
     */
    private void fwwy() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                String url = "http://192.168.3.24:8080/testget?name=a&pwd=123";
                Request request = new Request.Builder().url(url).build();
                Call call = okHttpClient.newCall(request);
                try {
                    Response response = call.execute();//同步请求
                    Message message = new Message();
                    message.what = 1;
                    message.obj = response.body().string().trim();
                    handler.sendMessage(message);
                } catch (IOException e) {
                    Log.i("【访问网页，fwwy，catch】", "run: 同步请求异常了");
                }
            }
        };
        thread.start();
    }

    /**
     * 登录系统
     */
    private void dlxt() {
        final View login = getLayoutInflater().inflate(R.layout.login, null);
        new AlertDialog.Builder(MainActivity.this).setTitle("登录系统").setView(login).setPositiveButton("登录", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface d, int w) {
                String name = ((EditText) login.findViewById(R.id.myname)).getText().toString();
                String pwd = ((EditText) login.findViewById(R.id.mypwd)).getText().toString();
                String url = "http://192.168.3.24:8080/testpost";
                FormBody body = new FormBody.Builder().add("name", name).add("pwd", pwd).build();
                Request request = new Request.Builder().url(url).post(body).build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.i("【dlxt，onFailure】", "onFailure: post请求异常");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
//                        Log.i("【dlxt，onResponse】", "onResponse: " + response.body().string());
                        Message message = new Message();
                        message.what = 1;
                        message.obj = response.body().string();
                        handler.sendMessage(message);
                    }
                });
            }
        }).setNegativeButton("取消", null).show();
    }
}
