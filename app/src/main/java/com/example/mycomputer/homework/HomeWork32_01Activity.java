package com.example.mycomputer.homework;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/3.
 */
public class HomeWork32_01Activity extends BaseActivity {
    ListView listView;
    TextView textView;
    File currentParent;
    File[] currentFiles;

    @Override
    protected void initContentView(Bundle savedInstanceState) throws IOException {
        setContentView(R.layout.homework32_01_layout);
        listView = (ListView) findViewById(R.id.list);
        textView = (TextView) findViewById(R.id.path);
        File root = new File("/mnt/sdcard/");
        if (root.exists()) {
            currentParent = root;
            currentFiles = root.listFiles();
            inflateListView(currentFiles);
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (currentFiles[position].isFile()) {
                    try {
                        if (currentFiles[position].getCanonicalPath().toString().contains(".jpg") || currentFiles[position].getCanonicalPath().toString().contains(".png")) {
                            Intent i = new Intent();
                            i.setAction(Intent.ACTION_VIEW);
                            i.setDataAndType(Uri.fromFile(currentFiles[position]), "image/*");
                            startActivity(i);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return;
                }
                File[] tmp = currentFiles[position].listFiles();

                if (tmp == null || tmp.length == 0) {
                    Toast.makeText(HomeWork32_01Activity.this
                            , "此路径下没有文件",
                            Toast.LENGTH_SHORT).show();
                } else {
                    currentParent = currentFiles[position];
                    currentFiles = tmp;
                    try {
                        inflateListView(currentFiles);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Button parent = (Button) findViewById(R.id.parent);
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View source) {
                try {
                    if (!currentParent.getCanonicalPath()
                            .equals("/mnt/sdcard")) {
                        currentParent = currentParent.getParentFile();
                        currentFiles = currentParent.listFiles();
                        inflateListView(currentFiles);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void inflateListView(File[] files) throws IOException {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < files.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            if (files[i].isDirectory()) {
                listItem.put("icon", R.drawable.folder);
            } else {
                listItem.put("icon", R.drawable.file);
            }
            listItem.put("fileName", files[i].getName());
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.line, new String[]{"icon", "fileName"}, new int[]{R.id.icon, R.id.file_name});
        listView.setAdapter(simpleAdapter);
        textView.setText("当前路径为：" + currentParent.getCanonicalPath());
    }
}
