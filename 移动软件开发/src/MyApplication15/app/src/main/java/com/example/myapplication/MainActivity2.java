package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.entity.ContactEntity;
import com.example.utils.DBUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {

    List<ContactEntity> contactList;
    String name;
    EditText edit_name, edit_sex, edit_birthday, edit_qq, edit_phone;
    Button btn_update, btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");

        edit_name = findViewById(R.id.edit_username);
        edit_sex = findViewById(R.id.edit_sex);
        edit_birthday = findViewById(R.id.edit_birthday);
        edit_qq = findViewById(R.id.edit_qq);
        edit_phone = findViewById(R.id.edit_phone);

        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);

        MyThread myThread = new MyThread();
        myThread.start();

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateThread updateThread = new UpdateThread();
                updateThread.start();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteThread deleteThread = new DeleteThread();
                deleteThread.start();
            }
        });
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            contactList = DBUtils.getInstance().query("select * from contact where name = '" + name + "'");
            MainActivity2.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    edit_name.setText(contactList.get(0).getName());
                    edit_sex.setText(contactList.get(0).getSex());
                    edit_birthday.setText(contactList.get(0).getBirthday());
                    edit_qq.setText(contactList.get(0).getQq());
                    edit_phone.setText(contactList.get(0).getPhone());
                }
            });
        }
    }

    class UpdateThread extends Thread {
        @Override
        public void run() {
            int result = DBUtils.getInstance().execute("update contact set " +
                    "name = '" + edit_name.getText() + "' ," +
                    "sex = '" + edit_sex.getText() + "' ," +
                    "birthday = '" + edit_birthday.getText() + "' ," +
                    "qq = '" + edit_qq.getText() + "' ," +
                    "phone = '" + edit_phone.getText() + "' " +
                    "where name = '" + name + "'");
            MainActivity2.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (result > 0) {
                        Toast.makeText(MainActivity2.this, "更新信息成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity2.this, "更新信息失败", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    class DeleteThread extends Thread {
        @Override
        public void run() {
            int result = DBUtils.getInstance().execute("delete from contact where name = '" + name + "'");
            MainActivity2.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (result > 0) {
                        Toast.makeText(MainActivity2.this, "删除信息成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity2.this, "删除信息失败", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}