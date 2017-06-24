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

public class schedule_add extends AppCompatActivity {
    final int DIALOG_DATE = 1;
    final int DIALOG_TIME = 2;

    Intent myIntent = new Intent(this,schedule.class);

    EditText et = (EditText)findViewById(R.id.editText);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_add);
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

                                        myIntent.putExtra("year",year);
                                        myIntent.putExtra("month",monthOfYear);
                                        myIntent.putExtra("day",dayOfMonth);
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
                                        myIntent.putExtra("hour",hourOfDay);
                                        myIntent.putExtra("min",minute);
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
        String text = et.getText().toString();
        myIntent.putExtra("memo",text);
        startActivity(myIntent);
    }
}
