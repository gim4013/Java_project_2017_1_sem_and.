package org.androidtown.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.orm.SugarRecord;

public class schedule_add extends AppCompatActivity {
    final int DIALOG_DATE = 1;
    final int DIALOG_TIME = 2;

    public class schedule_data extends SugarRecord<schedule_data>{
        int year;
        int month;
        int day;
        int hour;
        int min;
        String memo;

        public schedule_data() { }
        public schedule_data(int year, int month, int day)
        {
            this.year = year;
            this.month = month;
            this.day = day;
        }
        public schedule_data(int hour, int min)
        {
            this.hour = hour;
            this.min = min;
        }
        public schedule_data(String memo)
        {
            this.memo = memo;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_add);

        EditText et = (EditText)findViewById(R.id.editText);
        String memo_data = et.getText().toString();
        schedule_data DB_data = new schedule_data(memo_data);
        DB_data.save();

    }
    public void onClicked_date(View v)
    {
        Toast.makeText(getApplicationContext(),"날짜를 선택해 주세요",Toast.LENGTH_LONG).show();
        showDialog(DIALOG_DATE);
    }
    public void onClicked_time(View v)
    {
        Toast.makeText(getApplicationContext(),"시간을 선택해 주세요",Toast.LENGTH_LONG).show();
        showDialog(DIALOG_TIME);
    }
    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_DATE:
                DatePickerDialog dpd = new DatePickerDialog
                        (schedule_add.this, new DatePickerDialog.OnDateSetListener() {
                                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                                    {
                                        Toast.makeText(getApplicationContext(), year + "년 " + (monthOfYear + 1) + "월 " + dayOfMonth + "일 을 선택했습니다", Toast.LENGTH_SHORT).show();
                                        TextView textView1 = (TextView)findViewById(R.id.textView1);
                                        textView1.setText(year + "년 " + (monthOfYear + 1) + "월 " + dayOfMonth+"일");
                                        schedule_data DB_data = new schedule_data(year,dayOfMonth,dayOfMonth);
                                        DB_data.save();

                                    }
                                }
                                , // 사용자가 날짜설정 후 다이얼로그 빠져나올때
                                //    호출할 리스너 등록
                                2017, 1, 1); // 기본값 연월일
                return dpd;
            case DIALOG_TIME:
                TimePickerDialog tpd =
                        new TimePickerDialog
                                (schedule_add.this, new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                        Toast.makeText(getApplicationContext(), hourOfDay + "시 " + minute + "분 을 선택했습니다", Toast.LENGTH_SHORT).show();
                                        TextView textView2 = (TextView)findViewById(R.id.textView2);
                                        textView2.setText(hourOfDay + "시 " + minute + "분");
                                        schedule_data DB_data = new schedule_data(hourOfDay,minute);
                                        DB_data.save();
                                    }
                                }, // 값설정시 호출될 리스너 등록
                                4, 19, false); // 기본값 시분 등록
                // true : 24 시간(0~23) 표시
                // false : 오전/오후 항목이 생김
                return tpd;
        }
        return super.onCreateDialog(id);
    }
    public void onClicked_save(View v)
    {
        Toast.makeText(getApplicationContext(),"저장되었습니다.",Toast.LENGTH_LONG).show();
        Intent myintent = new Intent(this,schedule.class) ;
        startActivity(myintent);
    }
    public void onClicked_goBack(View v)
    {
        Toast.makeText(getApplicationContext(),"저장하지 않고 되돌아 갑니다.",Toast.LENGTH_LONG).show();

        Intent myintent = new Intent(this,schedule.class) ;
        startActivity(myintent);
    }

}
