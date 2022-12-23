package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MySystemReceiver extends BroadcastReceiver {

    @SuppressLint("LongLogTag")
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("【MySystemReceiver，onReceive】", "onReceive：成功了");
        Bundle bundle = intent.getExtras();
        int level = bundle.getInt("level");
        int scale = bundle.getInt("scale");
        Log.i("【MySystemReceiver，onReceive】", "onReceive：" + level + "，" + scale);
        if (level / scale < 0.8) {
            Log.i("【MySystemReceiver，onReceive】", "onReceive：电量过低了");
        }
    }
}
