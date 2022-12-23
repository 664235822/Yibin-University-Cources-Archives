package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.utils.DBUtils;

public class MainActivity3 extends AppCompatActivity {

    EditText edit_name, edit_sex, edit_birthday, edit_qq, edit_phone;
    Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        edit_name = findViewById(R.id.edit_username);
        edit_sex = findViewById(R.id.edit_sex);
        edit_birthday = findViewById(R.id.edit_birthday);
        edit_qq = findViewById(R.id.edit_qq);
        edit_phone = findViewById(R.id.edit_phone);

        btn_add = findViewById(R.id.btn_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyThread myThread = new MyThread();
                myThread.start();
            }
        });
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            int result = DBUtils.getInstance().execute("insert into contact " +
                    "(name,sex,birthday,qq,phone) values " +
                    "('" + edit_name.getText() + "'," +
                    "'" + edit_sex.getText() + "'," +
                    "'" + edit_birthday.getText() + "'," +
                    "'" + edit_qq.getText() + "'," +
                    "'" + edit_phone.getText() + "')");
            MainActivity3.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (result > 0) {
                        Toast.makeText(MainActivity3.this, "添加信息成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity3.this, "添加信息失败", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}