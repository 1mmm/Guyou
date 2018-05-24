package com.example.a2mmm.gift;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by 2mmm on 2017/9/10.
 */

public class dkAdapter extends BaseAdapter {
    private LinkedList<dk> data;
    private LayoutInflater layoutInflater;
    private Context context;

    public dkAdapter(Context context,LinkedList<dk> data){
        this.context=context;
        this.data=data;
        this.layoutInflater=LayoutInflater.from(context);
    }
    public final class Zujian{
        public TextView name;
        public TextView code;
        public TextView bfb;
        public TextView zf;
        public TextView kj;
        public TextView lx;
        public TextView in;
        public TextView po;
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
        convertView=layoutInflater.inflate(R.layout.list_dk, parent,false);
        zujian.name=(TextView)convertView.findViewById(R.id.id);
        zujian.code=(TextView)convertView.findViewById(R.id.name);
        zujian.bfb=(TextView)convertView.findViewById(R.id.code);
        zujian.zf=(TextView)convertView.findViewById(R.id.pm);
        zujian.lx=(TextView)convertView.findViewById(R.id.selfm);
        zujian.kj=(TextView)convertView.findViewById(R.id.status);
        zujian.in=(TextView)convertView.findViewById(R.id.in);
        zujian.po=(TextView)convertView.findViewById(R.id.po);


        //绑定数据
        String h=data.get(position).getname()+"";
        zujian.name.setText(h);
        h=data.get(position).getbfb()+"";
        zujian.bfb.setText(h);
        h=data.get(position).getcode()+"";
        zujian.code.setText(h);
        h=data.get(position).getkj()+"";
        zujian.kj.setText(h);
        zujian.lx.setText(data.get(position).getlx());
        zujian.zf.setText(data.get(position).getzf());
        h=data.get(position).getin()+"";
        zujian.in.setText(h);
        h=data.get(position).getpo()+"";
        zujian.po.setText(h);
        return convertView;
    }


}
