package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.entity.ContactEntity;
import com.example.utils.DBUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    List<ContactEntity> contactList;

    private static final int REFRESH = 0;
    private static final int ADD = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        MyThread Thread = new MyThread();
        Thread.start();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", contactList.get(i).getName());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, REFRESH, 0, "刷新");
        menu.add(0, ADD, 0, "添加信息");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case REFRESH:
                MyThread myThread = new MyThread();
                myThread.start();
                break;
            case ADD:
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            contactList = DBUtils.getInstance().query("select * from contact");
            List<Map<String, Object>> list = new ArrayList<>();
            for (int i = 0; i < contactList.size(); i++) {
                Map<String, Object> map = new HashMap<>();

                map.put("headshot", R.drawable.ic_launcher_background);
                map.put("username", contactList.get(i).getName());
                map.put("sex", contactList.get(i).getSex());
                map.put("birthday", contactList.get(i).getBirthday());
                map.put("qq", contactList.get(i).getQq());
                map.put("phone", contactList.get(i).getPhone());
                list.add(map);
            }

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String[] arrStr = new String[]{"headshot", "username", "sex", "birthday", "qq", "phone"};
                    int[] arrInt = new int[]{R.id.headshot, R.id.username, R.id.sex, R.id.birthday, R.id.qq, R.id.phone};

                    SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, list, R.layout.contact, arrStr, arrInt);
                    listView.setAdapter(adapter);
                }
            });
        }
    }
}