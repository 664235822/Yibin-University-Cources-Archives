package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /*组件*/
    Button btn;
    ImageView img;
    /*下载下来的图片*/
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        img = findViewById(R.id.img);

        btn.setOnClickListener(this);
    }

    static class MyHandler extends Handler {
        /*属性*/
        private WeakReference<MainActivity> mainActivity;
        /*构造函数*/
        public MyHandler(WeakReference<MainActivity> mainActivityWeakReference) {
            this.mainActivity = mainActivityWeakReference;
        }
        /*重写方法*/
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what == 1){
                mainActivity.get().img.setImageBitmap(mainActivity.get().bitmap);
            }
        }
    }
    private MyHandler handler = new MyHandler(new WeakReference<>(this));

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                /*创建线程*/
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                       try{
                           URL url = new URL("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fn.sinaimg.cn%2Fsinakd20200324ac%2F304%2Fw690h414%2F20200324%2F9976-ireifzi2051025.png&refer=http%3A%2F%2Fn.sinaimg.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1672505538&t=48bfabb74cfa33a41168e21c5b8e5527");
                           String file = url.getFile();
                           String host = url.getHost();
                           int port = url.getPort();
                           String protocol = url.getProtocol();
                           String path = url.getPath();
                           String query = url.getQuery();
                           url.openConnection();
                           Log.i("【信息】", String.format("\nfile:%s,\nhost:%s,\nport:%d," +
                                   "\nprotocol:%s," +
                                   "\npath:%s,\nquery:%s", file, host, port, protocol, path, query));
                           InputStream is = url.openStream();
                           bitmap = BitmapFactory.decodeStream(is);
                           handler.sendEmptyMessage(1);

                           is.close();
                           is = url.openStream();
                           OutputStream os = openFileOutput("1.png", Context.MODE_PRIVATE);
                           int hasread = -1;
                           byte[] buff = new byte[1024];
                           while ((hasread=is.read(buff))>0){
                               os.write(buff,0,hasread);
                           }
                           is.close();
                           os.close();
                       }catch (Exception e){
                           Log.i("", "run: 异常了");
                       }
                    }
                };
                /*启动线程*/
                thread.start();
                break;
            default:
                break;
        }
    }
}
