package com.example.a2mmm.gift;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

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
import static java.lang.Integer.valueOf;

public class wczd extends AppCompatActivity {

    ListView listView;
    String[] aaa={"未审核","已通过","已拒绝"};
    int aa;
    String ttt="";
    public JSONArray qqq;
    public String base_url="http://101.132.106.1/";
    private final OkHttpClient client = new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wczd);
        new Thread() {
            public void run() {
                try {
                    FormBody.Builder pa = new FormBody.Builder();
                    pa.add("token", token1);
                    ttt = post(pa, "apply.php");
                    JSONObject result = new JSONObject(ttt);

                    qqq = result.getJSONArray("data");

                }catch (Exception e)
                {
                }

            }
        }.start();
        delay(2000);
        listView = (ListView) findViewById(R.id.listview);
        List<dk> mData=getData();
        listView.setAdapter(new dkAdapter(this, (LinkedList<dk>) mData));

    }
    public List<dk> getData(){
        List<dk> list=new LinkedList<dk>();
        try {
            for (int i = 0; i < qqq.length(); i++) {
                JSONObject jo1 = qqq.getJSONObject(i);
                if (jo1.getString("status").equals("0"))
                    list.add(new dk(jo1.getString("id"),jo1.getString("want")+"元",jo1.getString("ppay")+"元", jo1.getString("interest")+"%",jo1.getString("poundage")+"元", jo1.getString("pmpay") ,jo1.getString("selfmpay"), aaa[valueOf(jo1.getString("status"))]));
            }
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
