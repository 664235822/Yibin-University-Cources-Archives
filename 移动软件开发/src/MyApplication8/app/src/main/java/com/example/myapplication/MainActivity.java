package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    FrameLayout frameLayout;

    RadioGroup radioGroup;

    RadioButton chat, contact, discover, me;

    static final int COUNT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.content_layout);
        radioGroup = findViewById(R.id.btnGroup);
        chat = findViewById(R.id.chat);
        contact = findViewById(R.id.contact);
        discover = findViewById(R.id.discover);
        me = findViewById(R.id.me);

        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        radioGroup.check(R.id.chat);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int flag = 0;
        switch (i) {
            case R.id.chat:
                flag = 0;
                break;
            case R.id.contact:
                flag = 1;
                break;
            case R.id.discover:
                flag = 2;
                break;
            case R.id.me:
                flag = 3;
                break;
            default:
                break;
        }

        Fragment fragment = (Fragment) adapter.instantiateItem(frameLayout, flag);
        adapter.setPrimaryItem(frameLayout, 0, fragment);
        adapter.finishUpdate(frameLayout);
    }

    FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
        @NonNull
        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new ChatFragment();
                    break;
                case 1:
                    fragment = new ContactFragment();
                    break;
                case 2:
                    fragment = new DiscoverFragment();
                    break;
                case 3:
                    fragment = new MeFragment();
                    break;
                default:
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return COUNT;
        }
    };
}