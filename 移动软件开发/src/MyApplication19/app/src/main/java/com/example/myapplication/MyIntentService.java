package com.example.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {
    /**
     * @param name
     * @deprecated
     */
    public MyIntentService(String name) {
        super(name);
    }

    public MyIntentService() {
        super("测试");
        Log.i("MyIntentService", "MyIntentService：构造函数");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("onCreate", "onCreate：onCreate执行了");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.i("onStartCommand", "onStartCommand：onStartCommand执行了");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        long endTime = System.currentTimeMillis() + 1000 * 5;
        Log.i("onHandleIntent", "onHandleIntent：该项耗时任务需要的时间是：" + endTime);
        while (System.currentTimeMillis() < endTime) {
            synchronized (this) {
                try {
                    Log.i("waiting", "waiting：请稍等");
                    wait(endTime - System.currentTimeMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Log.i("onHandleIntent", "onHandleIntent：完成耗时任务");
    }
}
