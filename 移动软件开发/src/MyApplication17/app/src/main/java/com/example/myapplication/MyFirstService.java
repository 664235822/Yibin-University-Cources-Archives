package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyFirstService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("OnBind", "Service被【绑定】时的回调方法");
        return null;
    }

    @Override
    public void onCreate() {
        Log.i("OnCreate", "Service被【第一次创建】时的回调方法");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("OnUnbind", "Service被【解除绑定】时的回调方法");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i("OnDestroy", "Service被【销毁】时的回调方法");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("OnStartCommand", "客户端调用【onStartCommand(intent)】时的回调方法");
        return super.onStartCommand(intent, flags, startId);
    }
}
