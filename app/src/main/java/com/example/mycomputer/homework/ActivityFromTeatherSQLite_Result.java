package com.example.mycomputer.homework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/6.
 */
public class ActivityFromTeatherSQLite_Result extends Activity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityfromteachersqlite_result_layout);
        lv = (ListView) findViewById(R.id.layout_fromteachersqlite_result_lv1);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        List<Map<String, String>> list = (List<Map<String, String>>) b.get("data");
        SimpleAdapter sda = new SimpleAdapter(this, list, R.layout.activityfromteaqchersqlite_result_list_layout, new String[]{"name", "age"}, new int[]{R.id.listview_tv1, R.id.listview_tv2});
        lv.setAdapter(sda);
    }
}
