package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int LOGIN = 1;
    private static final int REGISTER = 2;

    TextView textView;
    Button button;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.download_text);
        button = findViewById(R.id.download_button);
        progressBar = findViewById(R.id.download_progressbar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadAsyncTask asyncTask = new DownloadAsyncTask(MainActivity.this, textView, progressBar);
                asyncTask.execute();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu loginMenu = menu.addSubMenu("用户");
        loginMenu.add(0, LOGIN, 0, "注销");
        loginMenu.add(0, REGISTER, 0, "注册");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case LOGIN:
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                break;
            case REGISTER:
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    class DownloadAsyncTask extends AsyncTask<String, Integer, String> {

        Context context;
        TextView textView;
        ProgressBar progressBar;

        int hasRead = 0;

        public DownloadAsyncTask(Context context, TextView textView, ProgressBar progressBar) {
            this.context = context;
            this.textView = textView;
            this.progressBar = progressBar;
        }

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 10000; i++) {
                stringBuilder.append((i + 1) + "\n");
                hasRead++;
                publishProgress(hasRead);
            }
            return stringBuilder.toString();
        }

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(0);
            progressBar.setMax(10000);
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            textView.setText("读取到的值：" + values[0]);
            progressBar.setProgress(values[0]);
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(MainActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
            super.onPostExecute(s);
        }
    }
}