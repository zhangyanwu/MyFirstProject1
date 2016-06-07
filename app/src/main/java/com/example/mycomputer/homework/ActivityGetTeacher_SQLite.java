package com.example.mycomputer.homework;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/6.
 */
public class ActivityGetTeacher_SQLite extends Activity{

    ContentResolver cr;
    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitygetteachersqlite_layout);
        cr = getContentResolver();
        ed = (EditText) findViewById(R.id.layout_getteachersqlite_ed1);
    }

    public void query(View view){
        String uri = ed.getText().toString().trim();
        Cursor c = cr.query(Uri.parse(uri),new String[]{"name","age"},null,null,null);
        Bundle b = new Bundle();
        b.putSerializable("data",fromcursortolist(c));
        Intent intent = new Intent(ActivityGetTeacher_SQLite.this,ActivityFromTeatherSQLite_Result.class);
        intent.putExtras(b);
        startActivity(intent);
    }

    public void querysomeone(View view){
        String uri = ed.getText().toString().trim();
        Cursor c = cr.query(Uri.parse(uri),new String[]{"name","age"},null,null,null);
        Bundle b = new Bundle();
        b.putSerializable("data",fromcursortolist(c));
        Intent intent = new Intent(ActivityGetTeacher_SQLite.this,ActivityFromTeatherSQLite_Result.class);
        intent.putExtras(b);
        startActivity(intent);
    }

    public ArrayList<Map<String,String>> fromcursortolist(Cursor cursor){
        ArrayList<Map<String,String>> result = new ArrayList<Map<String,String>>();
        while(cursor.moveToNext()){
            Map<String,String> m = new HashMap<String,String>();
            Log.e("12345",cursor.getString(cursor.getColumnIndex("name")));
            Log.e("12346",cursor.getString(cursor.getColumnIndex("age")));
            m.put("name",cursor.getString(cursor.getColumnIndex("name")));
            m.put("age",cursor.getString(cursor.getColumnIndex("age"))+"");
            result.add(m);
        }
        return result;
    }


}
