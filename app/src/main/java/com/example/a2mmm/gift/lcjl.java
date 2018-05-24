package com.example.a2mmm.gift;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.a2mmm.gift.MainActivity.token1;
import static com.example.a2mmm.gift.suggestFragment.name;
import static com.example.a2mmm.gift.welcome.qq;
import static java.lang.Integer.valueOf;

public class lcjl extends AppCompatActivity {
    String tt="";
    String ttt="";
    public JSONArray qqq;
    ListView listView;
    public String base_url="http://101.132.106.1/";
    private final OkHttpClient client = new OkHttpClient();
    final Handler handed = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 5:
                    Toast.makeText(lcjl.this, "发送成功", Toast.LENGTH_SHORT).show();
                    break;
                case 6:
                    Toast.makeText(lcjl.this, "发送失败", Toast.LENGTH_SHORT).show();
                    break;
                case 1111:
                    Log.d( "handd: ",tt);
                    break;


            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lcjl);
        new Thread() {
            public void run() {
                try {
                    FormBody.Builder pa = new FormBody.Builder();
                    pa.add("token", token1);
                    tt = post(pa, "fin.php");
                    handed.sendEmptyMessage(1111);
                    JSONObject result = new JSONObject(tt);
                    qqq = result.getJSONArray("data");

                } catch (Exception e) {
                }
            }
        }.start();
        delay(2000);
        listView = (ListView) findViewById(R.id.listview);
        List<lc> mData=getData();
        listView.setAdapter(new lcAdapter(this, (LinkedList<lc>) mData));
    }
    public List<lc> getData(){
        List<lc> list=new LinkedList<lc>();
        try {
            for (int i = 0; i < qqq.length(); i++) {
                JSONObject jo1 = qqq.getJSONObject(i);
                if (jo1.getString("uid").equals(qq.getid()))
                    list.add(new lc(jo1.getString("id"),name[valueOf(jo1.getString("num"))]+"",jo1.getString("mon")+"股"));  }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
    String post(FormBody.Builder pa, String UR) throws Exception {
        //post方法接收一个RequestBody对象
        //create方法第一个参数都是MediaType类型，create方法的第二个参数可以是String、File、byte[]或okio.ByteString
        Request request = new Request.Builder()
                .url(base_url+UR)
                .post(pa.build())
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        else {
            return response.body().string();

        }
    }
    private void delay(int ms){
        try {
            Thread.currentThread();
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
