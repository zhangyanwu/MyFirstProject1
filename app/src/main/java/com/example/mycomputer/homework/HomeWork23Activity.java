package com.example.mycomputer.homework;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/5/31.
 */
public class HomeWork23Activity extends BaseActivity {
    Button btn;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework23_layout);
        btn = (Button) findViewById(R.id.button36);
    }
    public void tanchu(View view){
        AlertDialog b = new AlertDialog.Builder(this)
                .setTitle("对话框")
                .setIcon(R.drawable.icon_11)
                .setMessage("你打开了对话框！")
                .setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(HomeWork23Activity.this, "你确定了！", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(HomeWork23Activity.this, "你取消了！", Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        b.show();
    }
}
