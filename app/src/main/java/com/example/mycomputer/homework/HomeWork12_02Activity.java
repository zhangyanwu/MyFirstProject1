package com.example.mycomputer.homework;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by MyComputer on 2016/5/28.
 */
public class HomeWork12_02Activity extends BaseActivity {

    EditText phone;
    TextView result;
    Handler h = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

                    Bundle b = msg.getData();
            String str = (String) b.get("str");
                Gson gson = new Gson();
                phone pc = gson.fromJson(str, phone.class);
                if ("success".equals(pc.getRetMsg())) {
                    result.setText(pc.getRetData().getProvince() + "省" + pc.getRetData().getCity() + "市" + pc.getRetData().getSupplier());
                } else {
                    result.setText("没找着！！！");
                }
            }
    };

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homework12_03_layout);
        phone = (EditText) findViewById(R.id.phoneNum);
        result = (TextView) findViewById(R.id.result);
    }

    public void chaxun(View view) {
        (new Thread() {
            @Override
            public void run() {
                String httpUrl = "http://apis.baidu.com/apistore/mobilenumber/mobilenumber";
                BufferedReader reader = null;
                String result = null;
                StringBuffer sbf = new StringBuffer();
                httpUrl = httpUrl + "?phone=" + phone.getText().toString();
                try {
                    URL url = new URL(httpUrl);
                    HttpURLConnection connection = (HttpURLConnection) url
                            .openConnection();
                    connection.setRequestMethod("GET");
                    // 填入apikey到HTTP header
                    connection.setRequestProperty("apikey", "8e12d0585679836ab5330c18c5ff7209");
                    connection.connect();
                    InputStream is = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String strRead = null;
                    while ((strRead = reader.readLine()) != null) {
                        sbf.append(strRead);
                        sbf.append("\r\n");
                    }
                    reader.close();
                    result = sbf.toString();

                    Message m = new Message();
                    Bundle b = new Bundle();
                    b.putSerializable("str", result);
                    m.setData(b);
                    h.sendMessage(m);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
