package org.androidtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //Button schedule_button = (Button)findViewById(R.id.button_schedule);
        }
        public void onClicked_schedule(View v)
        {
            Toast.makeText(getApplicationContext(),"Schedule창으로 이동합니다.",Toast.LENGTH_LONG).show();
            Intent myIntent = new Intent(MainActivity.this,schedule.class);
            startActivity(myIntent);
        }
        public void onClicked_off(View v)
        {
            Toast.makeText(getApplicationContext(),"Exit",Toast.LENGTH_LONG).show();
            finish();
        }
        public void onClicked_current_time(View v)
        {
            Toast.makeText(getApplicationContext(),"Current Time",Toast.LENGTH_LONG).show();
            Intent myIntent = new Intent(this,current_time.class);
            startActivity(myIntent);
        }



}
