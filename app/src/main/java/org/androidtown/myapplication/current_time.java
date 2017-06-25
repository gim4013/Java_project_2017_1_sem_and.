package org.androidtown.myapplication;

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
    }

    public void currentTime()
    {
        long time = System.currentTimeMillis();
        SimpleDateFormat dayTime = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        String str = dayTime.format(new Date(time));
        System.out.println(str);
        TextView textView = (TextView)findViewById(textView_current);
        textView.setText(str);
    }

}
