package com.example.mycomputer.homework;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


/**
 * Created by MyComputer on 2016/5/27.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentView(savedInstanceState);
        Toolbar t = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(t);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setIcon(R.drawable.airplane);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = new MenuInflater(this);
        inf.inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.normal_btn:
                new AlertDialog.Builder(this).setIcon(R.drawable.icon_28).setTitle("作者介绍").setMessage("张沿伍").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create().show();
                break;
            case android.R.id.home:
                Intent i = new Intent(this,ListViewActivity.class);
                startActivity(i);
                break;
        }
        return true;
    }

    protected abstract void initContentView(Bundle savedInstanceState);
}