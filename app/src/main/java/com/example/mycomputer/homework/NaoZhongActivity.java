package com.example.mycomputer.homework;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.IOException;
import java.util.Calendar;

/**
 * Created by Administrator on 2016/6/8.
 */
public class NaoZhongActivity extends BaseActivity {
    Button setTime;
    Calendar currentTime;
    @Override
    protected void initContentView(Bundle savedInstanceState) throws IOException {
        setContentView(R.layout.naozhong_layout);
        setTime= (Button) findViewById(R.id.button38);
        setTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentTime=Calendar.getInstance();
                new TimePickerDialog(NaoZhongActivity.this, 0, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Intent intent=new Intent(NaoZhongActivity.this,AlarmActivity.class);
                        PendingIntent pi=PendingIntent.getActivity(NaoZhongActivity.this,0,intent,0);
                        Calendar c=Calendar.getInstance();
                        c.setTimeInMillis(System.currentTimeMillis());
                        c.set(Calendar.HOUR,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        AlarmManager aManager= (AlarmManager) getSystemService(ALARM_SERVICE);
                        aManager.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pi);
                        Toast.makeText(NaoZhongActivity.this,"成功设置",Toast.LENGTH_SHORT).show();
                    }
                },currentTime.get(Calendar.HOUR_OF_DAY),currentTime.get(Calendar.MINUTE),false).show();
            }
        });
    }
}
