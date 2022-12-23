package com.example.myapplication16b;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    Uri uri = Uri.parse("content://com.example.myapplication16a.myprovider/");

    Button btnQuery, btnInsert, btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnQuery = findViewById(R.id.btn_query);
        btnInsert = findViewById(R.id.btn_insert);
        btnUpdate = findViewById(R.id.btn_update);
        btnDelete = findViewById(R.id.btn_delete);

        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = getContentResolver().query(uri, null, "selection", null, null);
                Log.i("【B：查询】", "query：查询数据");
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put("user", "admin");
                values.put("pwd", "123456");
                getContentResolver().insert(uri, values);
                Log.i("【B：添加】", "insert：插入数据");
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put("user", "admin");
                values.put("pwd", "123456");
                getContentResolver().update(uri, values, "where", null);
                Log.i("【B：修改】", "update：修改数据");
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContentResolver().delete(uri, "where", null);
                Log.i("【B：删除】", "delete：删除数据");
            }
        });
    }
}