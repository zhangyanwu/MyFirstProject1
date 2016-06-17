package com.example.mycomputer.homework;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.baidu.mapapi.map.MapView;

/**
 * Created by Administrator on 2016/6/17.
 */
public class BaiDuMapActivity extends Activity {
    MapView map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.baidumap_layout);
        map= (MapView) findViewById(R.id.mymap);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        map.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        map.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        map.onPause();
    }
}
