package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] nicknames = new String[]{"小赵", "小钱", "小孙", "小李", "小周", "小吴", "小郑", "小王", "小冯", "小陈",
            "小褚", "小卫", "小蒋", "小沈", "小韩", "小杨", "小朱", "小秦", "小尤", "小许",
            "小何", "小吕", "小施", "小张", "小孔", "小曹", "小严", "小华", "小金", "小魏"};
    String[] messages = new String[]{"在吗", "[视频通话]", "游戏中", "干嘛", "哈哈哈", "在开会", "可以的", "牛啊", "拜拜", "[语音]",
            "斗地主不", "麻将3缺1", "尴尬而不失礼貌的微笑", "在想你呀", "晚安", "想要什么礼物", "[位置]", "口腔溃疡好点没", "无所谓", "方案等一下给你",
            "2000不讲价", "我想要switch", "兄弟哒", "大楼被烧了？没事，只要不是被骚了就好", "项目还差多人在线模块没写完", "虽然吃了很多家店，但是麦当劳还是yyds", "有什么问题可以问我", "没空", "我觉得不行", "所有没到学校的都暂缓"};

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Map<String, Object> map = new HashMap<>();

            map.put("headshot", R.drawable.justin_timberlake);
            map.put("nickname", nicknames[i]);
            map.put("message", messages[i]);

            list.add(map);
        }

        String[] arrStr = new String[]{"headshot", "nickname", "message"};
        int[] arrInt = new int[]{R.id.headshot, R.id.nickname, R.id.message};

        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.list_item, arrStr, arrInt);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "你点击了" + nicknames[i], Toast.LENGTH_SHORT).show();
            }
        });

        button = findViewById(R.id.toast_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(MainActivity.this);

                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.justin_timberlake);
                int width = 60;
                int height = 60;
                LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width, height);
                imageView.setLayoutParams(parms);

                TextView textView = new TextView(MainActivity.this);
                textView.setText("SmallPig1997");

                LinearLayout linearLayout = new LinearLayout(MainActivity.this);
                linearLayout.addView(imageView);
                linearLayout.addView(textView);

                toast.setView(linearLayout);
                toast.setDuration(Toast.LENGTH_LONG);

                toast.show();
            }
        });

    }
}