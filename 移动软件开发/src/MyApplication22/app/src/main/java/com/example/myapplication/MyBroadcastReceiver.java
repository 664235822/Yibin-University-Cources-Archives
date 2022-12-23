package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getStringExtra("name");
        String number = intent.getStringExtra("number");
        Log.i("【onReceiver】", "onReceive：姓名：" + name + "，学号：" + number);
    }
}
