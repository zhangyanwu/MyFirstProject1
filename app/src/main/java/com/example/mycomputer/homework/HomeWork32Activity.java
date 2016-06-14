package com.example.mycomputer.homework;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.IOException;

/**
 * Created by Administrator on 2016/6/14.
 */
public class HomeWork32Activity extends BaseActivity {
    SQLiteDatabase db;
    Button bn = null;
    ListView listView;
    @Override
    protected void initContentView(Bundle savedInstanceState){
        setContentView(R.layout.homework32_layout);
        db = SQLiteDatabase.openOrCreateDatabase(
                this.getFilesDir().toString()
                        + "/my.db3", null); // ①
        listView = (ListView) findViewById(R.id.show);
        bn = (Button) findViewById(R.id.ok);
        bn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View source)
            {
                String title = ((EditText) findViewById(
                        R.id.title)).getText().toString();
                String content = ((EditText) findViewById(R.id.content))
                        .getText().toString();
                try
                {
                    insertData(db, title, content);
                    Cursor cursor = db.rawQuery("select * from news_inf"
                            , null);
                    inflateList(cursor);
                }
                catch (SQLiteException se)
                {
                    db.execSQL("create table news_inf(_id integer"
                            + " primary key autoincrement,"
                            + " news_title varchar(50),"
                            + " news_content varchar(255))");
                    insertData(db, title, content);
                    Cursor cursor = db.rawQuery("select * from news_inf"
                            , null);
                    inflateList(cursor);
                }
            }
        });
    }
    private void insertData(SQLiteDatabase db
            , String title, String content)
    {
        db.execSQL("insert into news_inf values(null , ? , ?)"
                , new String[] {title, content });
    }
    private void inflateList(Cursor cursor)
    {
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                HomeWork32Activity.this,
                R.layout.line, cursor,
                new String[] { "news_title", "news_content" }
                , new int[] {R.id.my_title, R.id.my_content },
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        listView.setAdapter(adapter);
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        if (db != null && db.isOpen())
        {
            db.close();
        }
    }
}