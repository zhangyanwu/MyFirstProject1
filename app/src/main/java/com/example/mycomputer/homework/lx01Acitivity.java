package com.example.mycomputer.homework;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/6.
 */
public class lx01Acitivity extends BaseActivity {
    ListView listView;
    ContentResolver contentResolver;
    Button btn;
    EditText et;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.lx01_layout);
        listView = (ListView) findViewById(R.id.mylistview);
        contentResolver = getContentResolver();
        btn = (Button) findViewById(R.id.mybtn);
        final Uri uri=Uri.parse("content://com.ralph.second/students");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor=contentResolver.query(uri,null,null,null,null);
                ArrayList<Map<String,String>> result=new ArrayList<>();
                while(cursor.moveToNext()){
                    Map<String,String> map=new HashMap<>();
                    map.put("name",cursor.getString(0));
                    map.put("age",cursor.getString(1));
                    result.add(map);
                }
            }
        });
    }
}
