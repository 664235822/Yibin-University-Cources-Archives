package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {

    private String color = "red";
    private MyBinderUse binder;

    class MyBinderUse extends IMyAidlInterface.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String getColor() throws RemoteException {
            return color;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("OnBind", "Service被【绑定】时的回调方法");
        binder = new MyBinderUse();
        return binder;
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
