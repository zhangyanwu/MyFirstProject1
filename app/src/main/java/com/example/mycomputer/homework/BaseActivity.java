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

import java.io.IOException;

import butterknife.*;

/**
 * Created by MyComputer on 2016/5/27.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            initContentView(savedInstanceState);
            butterknife.ButterKnife.bind(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toolbar t= (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(t);
        getSupportActionBar().setTitle("马什么梅呀？");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mif=new MenuInflater(this);
        mif.inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.normal_btn:
                new AlertDialog.Builder(this).setMessage("张沿伍").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create().show();
                break;
            case android.R.id.home:
                Intent i=new Intent(this,ListViewActivity.class);
                startActivity(i);
                break;
        }
        return true;
    }

    protected abstract void initContentView(Bundle savedInstanceState) throws IOException;
}
