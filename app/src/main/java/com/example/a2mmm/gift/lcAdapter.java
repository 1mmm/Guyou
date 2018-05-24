package com.example.a2mmm.gift;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by 2mmm on 2017/9/14.
 */

public class lcAdapter extends BaseAdapter {
    private LinkedList<lc> data;
    private LayoutInflater layoutInflater;
    private Context context;

    public lcAdapter(Context context,LinkedList<lc> data){
        this.context=context;
        this.data=data;
        this.layoutInflater=LayoutInflater.from(context);
    }
    public final class Zujian{
        public TextView name;
        public TextView code;
        public TextView bfb;

    }

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


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Zujian zujian=null;
        zujian=new Zujian();
        //获得组件，实例化组件
        convertView=layoutInflater.inflate(R.layout.list_lc, parent,false);
        zujian.name=(TextView)convertView.findViewById(R.id.id);
        zujian.code=(TextView)convertView.findViewById(R.id.name);
        zujian.bfb=(TextView)convertView.findViewById(R.id.code);



        //绑定数据
        String h=data.get(position).getname()+"";
        zujian.name.setText(h);
        h=data.get(position).getbfb()+"";
        zujian.bfb.setText(h);
        h=data.get(position).getcode()+"";
        zujian.code.setText(h);

        return convertView;
    }


}
