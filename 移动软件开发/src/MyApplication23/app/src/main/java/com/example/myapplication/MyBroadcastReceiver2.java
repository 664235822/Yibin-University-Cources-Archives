package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MyBroadcastReceiver2 extends BroadcastReceiver {

    @SuppressLint("LongLogTag")
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = getResultExtras(true);
        String a = bundle.getString("a");
        String b = bundle.getString("b");
        Log.i("【MyBroadcastReceiver2，onReceive】", String.format("onReceive：\n姓名：%s，\n学号：%s", a, b));

    }
}
