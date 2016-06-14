package com.example.mycomputer.homework;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.IBinder;

public class dingshibizhiService extends Service
{
	int[] wallpapers = new int[]{
			R.drawable.shuangta,
			R.drawable.lijiang,
			R.drawable.qiao,
			R.drawable.shui
	};
	WallpaperManager wManager;
	int current = 0;
	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		if(current >= 4)
			current = 0;
		try
		{
			wManager.setResource(wallpapers[current++]);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return START_STICKY;
	}
	@Override
	public void onCreate()
	{
		super.onCreate();
		wManager = WallpaperManager.getInstance(this);
	}
	@Override
	public IBinder onBind(Intent intent)
	{
		return null;
	}
}

