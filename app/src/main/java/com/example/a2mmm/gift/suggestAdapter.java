package com.example.a2mmm.gift;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.LinkedList;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.a2mmm.gift.MainActivity.token1;
import static com.example.a2mmm.gift.R.id.sz;
import static com.example.a2mmm.gift.suggestFragment.name;

public class suggestAdapter extends BaseAdapter {
    final Handler handed = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 5:
                    Toast.makeText(context, "发送成功", Toast.LENGTH_SHORT).show();
                    break;
                case 6:
                    Toast.makeText(context, "发送失败", Toast.LENGTH_SHORT).show();
                    break;
                case 1111:
                    Log.d( "handd: ",tt);
                    break;


            }
        }
    };
    private LinkedList<suggest> data;
    public  myWatcher mWatcher;
    String[] text=new String[100];
    String tt="";
    public String base_url="http://101.132.106.1/";
    private final OkHttpClient client = new OkHttpClient();
    public class erro {
        private int errno;
        erro(int errno){
            this.errno = errno;
        }
    }
    private LayoutInflater layoutInflater;
    private Context context;
    public   int index=-1,mrp=-1,mcp=-1;

    public suggestAdapter(Context context,LinkedList<suggest> data){
        this.context=context;
        this.data=data;
        this.layoutInflater=LayoutInflater.from(context);
    }
    public final class Zujian{
        public TextView name;
        public TextView code;
        public TextView bfb;
        public TextView zf;
        public TextView sz;
        public TextView kj;
        public TextView lx;
        public Button mr;
        public Button mc;
        public LinearLayout zk;
        public LinearLayout hide;
        public EditText sl;
    }
    public int clickPosition = -1;
    @Override
    public int getCount() {
        return data.size();
    }
    /**
     * 获得某一位置的数据
     */
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }
    /**
     * 获得唯一标识
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    private  String bfbnum,zfnum,kjnum;

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Zujian zujian=null;
        zujian=new Zujian();
        //获得组件，实例化组件
        convertView=layoutInflater.inflate(R.layout.list_suggest, parent,false);
        zujian.name=(TextView)convertView.findViewById(R.id.name);
        zujian.code=(TextView)convertView.findViewById(R.id.code);
        zujian.bfb=(TextView)convertView.findViewById(R.id.bfb);
        zujian.zf=(TextView)convertView.findViewById(R.id.zf);
        zujian.sl=(EditText)convertView.findViewById(R.id.sl);
        zujian.lx=(TextView)convertView.findViewById(R.id.lx);
        zujian.kj=(TextView)convertView.findViewById(R.id.kj);
        zujian.sz=(TextView)convertView.findViewById(sz);
        zujian.mr=(Button) convertView.findViewById(R.id.mr);
        zujian.mc=(Button) convertView.findViewById(R.id.mc);
        zujian.zk=(LinearLayout) convertView.findViewById(R.id.zk);
        zujian.hide=(LinearLayout) convertView.findViewById(R.id.hide);

        zujian.zk.setSelected(false);
        zujian.bfb.setSelected(false);
        zujian.zf.setSelected(false);
        zujian.kj.setSelected(false);
        //绑定数据
        zujian.name.setText(data.get(position).getname());

        zujian.bfb.setText(data.get(position).getbfb());
        bfbnum=data.get(position).getbfb();
        if (bfbnum.substring(0,1).equals("-")) zujian.bfb.setSelected(true);
        zujian.zf.setText(data.get(position).getzf());
        zfnum=data.get(position).getzf();
        if (zfnum.substring(0,1).equals("-")) zujian.zf.setSelected(true);
        zujian.lx.setText(data.get(position).getlx());
        zujian.kj.setText(data.get(position).getkj());
        kjnum=data.get(position).getkj();
        if (kjnum.substring(0,1).equals("-")) zujian.kj.setSelected(true);
        zujian.sz.setText(data.get(position).getsz());
        convertView.setTag(zujian);
        if (clickPosition == position) {//当条目为刚才点击的条目时
            if (zujian.zk.isSelected()) {//当条目状态图标为选中时，说明该条目处于展开状态，此时让它隐藏，并切换状态图标的状态。
                zujian.zk.setSelected(false);
                zujian.hide.setVisibility(View.GONE);
                clickPosition=-1;
            } else {
                zujian.zk.setSelected(true);
                zujian.hide.setVisibility(View.VISIBLE);
            }
        } else {
            zujian.hide.setVisibility(View.GONE);
            zujian.zk.setSelected(false);

        }

        zujian.mr.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(context, "成功买入"+name[data.get(position).getnn()]+"  "+text[position]+"股", Toast.LENGTH_LONG).show();
                new Thread() {
                    public void run() {
                        try {
                            FormBody.Builder pa = new FormBody.Builder();
                            pa.add("token", token1);
                            pa.add("num", data.get(position).getnn()+ "");
                            pa.add("mon", text[position]);
                            tt = post(pa, "fin.php");
                            handed.sendEmptyMessage(1111);
                            Gson gson = new Gson();
                            int er = gson.fromJson(tt,suggestAdapter.erro.class).errno;
                            if (er==0)
                            {
                                handed.sendEmptyMessage(5);
                            }
                            else if (er==1) handed.sendEmptyMessage(6);
                        } catch (Exception e) {
                            handed.sendEmptyMessage(6);
                        }
                    }
                }.start();
            }

        });
        zujian.mc.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(context, "成功卖出"+name[data.get(position).getnn()]+"  "+text[position]+"股", Toast.LENGTH_LONG).show();
                new Thread() {
                    public void run() {
                        try {
                            FormBody.Builder pa = new FormBody.Builder();
                            pa.add("token", token1);
                            pa.add("num", data.get(position).getnn() + "");
                            pa.add("mon", "-"+text[position]);
                            tt = post(pa, "fin.php");
                            handed.sendEmptyMessage(1111);
                            Gson gson = new Gson();
                            int er = gson.fromJson(tt,suggestAdapter.erro.class).errno;
                            if (er==0)
                            {
                                handed.sendEmptyMessage(5);
                            }
                            else if (er==1) handed.sendEmptyMessage(6);
                        } catch (Exception e) {
                            handed.sendEmptyMessage(6);
                        }
                    }
                }.start();
            }

        });
        zujian.zk.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                clickPosition = position;
                notifyDataSetChanged();
            }

        });
        zujian.sl.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                if(event.getAction()== MotionEvent.ACTION_UP){
                    index=position;
                }
                return false;
            }
        });

        zujian.sl.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            //设置焦点监听，当获取到焦点的时候才给它设置内容变化监听解决卡的问题

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                EditText et=(EditText) v;
                if(mWatcher==null){
                    mWatcher=new myWatcher();
                }
                if(hasFocus){
                    et.addTextChangedListener(mWatcher);//设置edittext内容监听
                }else {
                    et.removeTextChangedListener(mWatcher);
                }

            }
        });

        zujian.sl.clearFocus();//防止点击以后弹出键盘，重新getview导致的焦点丢失
        if (index != -1 && index == position) {
            // 如果当前的行下标和点击事件中保存的index一致，手动为EditText设置焦点。
            zujian.sl.requestFocus();
        }
        zujian.sl.setText(text[position]);//这一定要放在clearFocus()之后，否则最后输入的内容在拉回来时会消失
        zujian.sl.setSelection(zujian.sl.getText().length());


        return convertView;
    }

//        viewHolder.editText.addTextChangedListener(new myWatcher());//放弃直接的为每一个edittext设置监听内容变化

    class myWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            // TODO Auto-generated method stub


        }

        @Override
        public void afterTextChanged(Editable s) {
            text[index]=s.toString();//为输入的位置内容设置数组管理器，防止item重用机制导致的上下内容一样的问题
        }

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

}