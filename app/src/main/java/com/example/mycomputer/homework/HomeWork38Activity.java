package com.example.mycomputer.homework;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/7.
 */
public class HomeWork38Activity extends BaseActivity {
    EditText numbers, content;
    Button select, send;
    SmsManager sManager;
    ArrayList<String> sendList = new ArrayList<String>();

    @Override
    protected void initContentView(Bundle savedInstanceState) throws IOException {
        setContentView(R.layout.homework38_layout);
        sManager = SmsManager.getDefault();
        numbers = (EditText) findViewById(R.id.numbers);
        content = (EditText) findViewById(R.id.content);
        select = (Button) findViewById(R.id.select);
        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (String number : sendList) {
                    PendingIntent pi = PendingIntent.getActivity(HomeWork38Activity.this, 0, new Intent(), 0);
                    sManager.sendTextMessage(number, null, content.getText().toString(), pi, null);
                }
                Toast.makeText(HomeWork38Activity.this, "短信群发成功", Toast.LENGTH_SHORT).show();
            }
        });
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
                BaseAdapter adapter = new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return cursor.getCount();
                    }

                    @Override
                    public Object getItem(int position) {
                        return position;
                    }

                    @Override
                    public long getItemId(int position) {
                        return position;
                    }

                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        cursor.moveToPosition(position);
                        CheckBox rb = new CheckBox(HomeWork38Activity.this);
                        String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                                .replace("-", "")
                                .replace(" ", "");
                        rb.setText(number);
                        if (isChecked(number)) {
                            rb.setChecked(true);
                        }
                        return rb;
                    }
                };
                View selectView = getLayoutInflater().inflate(R.layout.homework38_listview_layout, null);
                final ListView listview = (ListView) selectView.findViewById(R.id.list);
                listview.setAdapter(adapter);
                new AlertDialog.Builder(HomeWork38Activity.this)
                        .setView(selectView)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sendList.clear();
                                for (int i = 0; i < listview.getCount(); i++) {
                                    CheckBox checkbox = (CheckBox) listview.getChildAt(i);
                                    if (checkbox.isChecked()) {
                                        sendList.add(checkbox.getText().toString());
                                    }
                                }
                                numbers.setText(sendList.toString());
                            }
                        }).show();
            }
        });
    }
    public boolean isChecked(String phone) {
        for (String s1 : sendList) {
            if (s1.equals(phone)) {
                return true;
            }
        }
        return false;
    }
}
