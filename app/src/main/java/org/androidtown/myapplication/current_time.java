package org.androidtown.myapplication;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Date;

import static org.androidtown.myapplication.R.id.textView_current;

public class current_time extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_time);

        Thread t = new Thread() {
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                currentTime();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();
    }
    public void currentTime()
    {
        long time = System.currentTimeMillis();
        SimpleDateFormat dayTime = new SimpleDateFormat("YYYY년 MM월 dd일 hh시 mm분 ss초");
        String str = dayTime.format(new Date(time));

        TextView textView = (TextView)findViewById(textView_current);
        textView.setText(str);
    }

    public void onClicked_goBack()
    {
      Intent myintent = new Intent(this,MainActivity.class);
      startActivity(myintent);
    }
}
