package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.simple_message);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setTitle("简单信息对话框");
                builder.setMessage("信息区域");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你点击了确定按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你点击了取消按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

        btn2 = findViewById(R.id.simple_list);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] arrayStr = new String[]{"简单列表项1", "简单列表项2", "简单列表项3", "简单列表项4"};

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setTitle("简单列表对话框");
                builder.setItems(arrayStr, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你点击了" + arrayStr[i], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你点击了确定按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你点击了取消按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

        btn3 = findViewById(R.id.radio_group_list);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] arrayStr = new String[]{"单选列表项1", "单选列表项2", "单选列表项3", "单选列表项4"};
                final int[] checkedItem = {0};

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setTitle("单选列表对话框");
                builder.setSingleChoiceItems(arrayStr, checkedItem[0], new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你点击了" + arrayStr[i], Toast.LENGTH_SHORT).show();
                        checkedItem[0] = i;
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你点击了确定按钮，选择了" + arrayStr[checkedItem[0]], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你点击了取消按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

        btn4 = findViewById(R.id.checkbox_group_list);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] arrayStr = new String[]{"多选列表项1", "多选列表项2", "多选列表项3", "多选列表项4"};
                final boolean[] checkedItem = new boolean[]{false, false, false, false};

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setTitle("多选列表对话框");
                builder.setMultiChoiceItems(arrayStr, checkedItem, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if (b) {
                            Toast.makeText(MainActivity.this, "你选择了" + arrayStr[i], Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "你取消选择了" + arrayStr[i], Toast.LENGTH_SHORT).show();
                        }
                        checkedItem[i] = b;
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int j = 0; j < arrayStr.length; j++) {
                            if (checkedItem[j]) {
                                stringBuilder.append(arrayStr[j]).append(",");
                            }
                        }
                        if (stringBuilder.length() > 0) {
                            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                            Toast.makeText(MainActivity.this, "你点击了确定按钮，选择了" + stringBuilder, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "你点击了确定按钮，没有选择任何项", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你点击了取消按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

        btn5 = findViewById(R.id.custom_list);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] nicknames = new String[]{"小赵", "小钱", "小孙", "小李", "小周"};
                String[] messages = new String[]{"在吗", "[视频通话]", "游戏中", "干嘛", "哈哈哈"};

                List<Map<String, Object>> list = new ArrayList<>();
                for (int i = 0; i < nicknames.length; i++) {
                    Map<String, Object> map = new HashMap<>();

                    map.put("headshot", R.drawable.justin_timberlake);
                    map.put("nickname", nicknames[i]);
                    map.put("message", messages[i]);

                    list.add(map);
                }

                String[] arrStr = new String[]{"headshot", "nickname", "message"};
                int[] arrInt = new int[]{R.id.headshot, R.id.nickname, R.id.message};

                SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, list, R.layout.list_item, arrStr, arrInt);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setTitle("自定义列表对话框");
                builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你点击了" + nicknames[i], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你点击了确定按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你点击了取消按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

        btn6 = findViewById(R.id.custom_dialog);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setTitle("自定义对话框");
                builder.setView(R.layout.custom_dialog);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你点击了确定按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你点击了取消按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }
}