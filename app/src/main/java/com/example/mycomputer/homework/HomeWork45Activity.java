package com.example.mycomputer.homework;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.io.IOException;

/**
 * Created by Administrator on 2016/6/13.
 */
public class HomeWork45Activity extends BaseActivity {
    ListView lv;
    ContentResolver cr;
    @Override
    protected void initContentView(Bundle savedInstanceState) throws IOException {
        setContentView(R.layout.homework45_layout);
        lv = (ListView) findViewById(R.id.studList);

        cr = getContentResolver();

        Uri uri = Uri.parse("content://com.ralph.second/students");
        Cursor c = cr.query(uri,null,null,null,null,null);

        SimpleCursorAdapter aca = new SimpleCursorAdapter(this,R.layout.ex09_row_layout,c,new String[]{"name","age"},new int[]{R.id.studName,R.id.studAge},0);
        lv.setAdapter(aca);
    }
}
