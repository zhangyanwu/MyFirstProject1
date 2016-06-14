package com.example.mycomputer.homework;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;


public class dingshibizi extends BaseActivity
{
	Button start, stop;
	@Override
	protected void initContentView(Bundle savedInstanceState){
		setContentView(R.layout.dingshibizhi_layout);
		start = (Button) findViewById(R.id.start);
		stop = (Button) findViewById(R.id.stop);
		Intent intent = new Intent(dingshibizi.this, dingshibizhiService.class);
		final PendingIntent pi = PendingIntent.getService(dingshibizi.this, 0, intent, 0);
		start.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				AlarmManager aManager = (AlarmManager) getSystemService(
					Service.ALARM_SERVICE);
				aManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP
					, 0, 2000, pi);
				start.setEnabled(false);
				stop.setEnabled(true);
				Toast.makeText(dingshibizi.this
					, "壁纸定时更换启动成功啦",
					Toast.LENGTH_SHORT).show();
			}
		});
		stop.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
			start.setEnabled(true);
			stop.setEnabled(false);
			AlarmManager aManager = (AlarmManager) getSystemService(
				Service.ALARM_SERVICE);
			aManager.cancel(pi);
			}
		});
	}
}


