package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button get, post;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get = findViewById(R.id.getreq);
        post = findViewById(R.id.postreq);
        textView = findViewById(R.id.textview);
        get.setOnClickListener(this);
        post.setOnClickListener(this);
    }

    static class MyHandler extends Handler{
        private WeakReference<MainActivity> mainActivity;
        public MyHandler(WeakReference<MainActivity> mainActivity){
            this.mainActivity = mainActivity;
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what==1) {
                mainActivity.get().textView.setText(msg.obj.toString());
            }
        }
    }

    private MyHandler handler = new MyHandler(new WeakReference<MainActivity>(this));

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getreq:
                Thread threadGet = new Thread(){
                    @Override
                    public void run() {
                        String str = GetUtil.sendGet("http://192.168.3.24:8080/loginget");
                        Message message = new Message();
                        message.what = 1;
                        message.obj = str;
                        handler.sendMessage(message);
                    }
                };
                threadGet.start();
                break;
            case R.id.postreq:
                Thread threadPost = new Thread() {
                    @Override
                    public void run() {
                        String str = GetUtil.sendPost("http://192.168.3.24:8080/loginpost", "name=aaa" + "&pwd=bbb");
                        Message message = new Message();
                        message.what = 1;
                        message.obj = str;
                        handler.sendMessage(message);
                    }
                };
                threadPost.start();
                break;
            default:
                break;
        }
    }
}
