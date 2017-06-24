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
    public void onClicked_check(View v)
    {

    }

}
