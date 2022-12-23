package com.example.myapplication;

import android.os.Binder;
import android.util.Log;

public class MyBinder extends Binder {

    private static int count;

    public MyBinder() {
        Log.i("MyBinder", "MyBinder构造函数");
        count++;
    }

    public int getCount() {
        Log.i("MyBinder", "getCount:get方法");
        return count;
    }

    public void setCount(int value) {
        Log.i("MyBinder", "setCount:set方法");
        count = value;
    }
}
