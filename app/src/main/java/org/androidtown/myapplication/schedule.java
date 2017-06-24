package org.androidtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
    }
    public void onClicked_add(View v)
    {
        Toast.makeText(getApplicationContext(),"Add the Schedule",Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(schedule.this,schedule_add.class);
        startActivity(myIntent);
    }
    private int year;
    private int month;
    private int day;
    private String memo;

    public int getYear()
    {
        return year;
    }
    public int getMonth()
    {
        return month;
    }
    public int getDay()
    {
        return day;
    }
    public void ShowYourSchedule()
    {
        System.out.println("==========================================");
        System.out.println(year+"년"+month+"월"+day+"일의 일정은");
        System.out.println(memo);
        System.out.println("==========================================");
    }
    public int compareTo(schedule o1) {
        if(year<o1.getYear()) return 1;
        else if(year>o1.getYear()) return -1;

        else{

            if(month<o1.getMonth()) return 1;
            else if(month>o1.getMonth()) return -1;

            else{

                if(day<o1.getDay()) return 1;
                else if(day>o1.getDay()) return -1;
                else return 0;
            }//End of 2nd else
        }//End of 1th else
    }//End of compareTo
}
