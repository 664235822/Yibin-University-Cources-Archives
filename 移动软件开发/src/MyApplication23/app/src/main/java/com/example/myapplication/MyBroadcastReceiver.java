package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @SuppressLint("LongLogTag")
    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getStringExtra("name");
        String number = intent.getStringExtra("number");
        String action = intent.getAction();
        Log.i("【MyBroadcastReceiver，onReceive】", String.format("onReceive：\n姓名：%s，\n学号：%s\naction：%s", name, number, action));
        Bundle bundle = new Bundle();
        bundle.putString("a", name);
        bundle.putString("b", number);
        setResultExtras(bundle);
    }
}
