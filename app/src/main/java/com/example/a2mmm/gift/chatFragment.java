package com.example.a2mmm.gift;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.a2mmm.gift.Main2Activity.rlRight;
import static com.example.a2mmm.gift.Main2Activity.dl;
import static com.example.a2mmm.gift.MainActivity.sh;
import static com.example.a2mmm.gift.MainActivity.user;
import static com.example.a2mmm.gift.welcome.qq;


public class chatFragment extends Fragment implements GestureDetector.OnGestureListener {


    public chatFragment() {

    }
    TextView yczd,wczd,hkls,dkjl,lcjl,yhls,rmbz,lxkf,gywm;
    TextView name,sz;
    static  TextView phone,email;
    public GestureDetector detector;
    Context mContext;
    EditText ans;
    final int DISTANT=50;
    static ScrollView hhh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chat,container,false);

        SysApplication.getInstance().addActivity(getActivity());
        sz=(TextView) v.findViewById(R.id.sz);
        hhh=(ScrollView) v.findViewById(R.id.hhh);
        name=(TextView) v.findViewById(R.id.name);
        phone=(TextView) v.findViewById(R.id.phone);
        email=(TextView) v.findViewById(R.id.email);
        String t=qq.getid()+sh.read(user+"le").get(user+"le");
        name.setText(t);
        if (qq.getmail()==null) email.setText("暂未填写");
        else email.setText(qq.getmail());
        if (qq.getphone()==null) phone.setText("暂未填写");
        else phone.setText(qq.getphone());
        rmbz=(TextView) v.findViewById(R.id.rmbz);
        rmbz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"暂无帮助！",Toast.LENGTH_SHORT).show();
            }
        });
        lxkf=(TextView) v.findViewById(R.id.lxkf);
        lxkf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //用intent启动拨打电话
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin="+"23580151"+"&version=1")));

            }
        });
        gywm=(TextView) v.findViewById(R.id.gywm);
        gywm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //用intent启动拨打电话
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:13297034233"));
                startActivity(intent);
            }
        });
        yczd=(TextView) v.findViewById(R.id.yczd);
        yczd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), yczd.class);
                    startActivity(intent);
            }
        });
        wczd=(TextView) v.findViewById(R.id.wczd);
        wczd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), wczd.class);
                startActivity(intent);
            }
        });
        hkls=(TextView) v.findViewById(R.id.hkls);
        hkls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),hkls.class);
                startActivity(intent);
            }
        });
        lcjl=(TextView) v.findViewById(R.id.lcjl);
        lcjl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), lcjl.class);
                startActivity(intent);
            }
        });
        yhls=(TextView) v.findViewById(R.id.yhls);
        yhls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), yhls.class);
                startActivity(intent);
            }
        });
        dkjl=(TextView) v.findViewById(R.id.jdjl);
        dkjl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), jdjl.class);
                startActivity(intent);
            }
        });
        sz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!dl.isDrawerOpen(rlRight)) {
                    dl.openDrawer(rlRight);
                }
            }
        });
        detector=new GestureDetector(mContext,this);
        return v;
    }

    public	boolean	onTouchEvent(MotionEvent	event)	{
//	TODO	Auto-generated	method	stub
//将该Activity上触碰事件交给GestureDetector处理
        return	detector.onTouchEvent(event);
    }
    @Override
    public	boolean	onDown(MotionEvent	arg0)	{
//	TODO	Auto-generated	method	stub
        return	false;
    }
    @Override
    public	boolean	onFling(MotionEvent arg0, MotionEvent	arg1, float	arg2,
                                 float	arg3) {

//	TODO	Auto-generated	method	stub
//当是Fragment0的时候
        if ((arg0.getY() > arg1.getY() + DISTANT) | (arg1.getY() > arg0.getY() + DISTANT)) {
            hhh.setFocusable(true);
        }
        else hhh.setFocusable(false);
       return false;
    }
    @Override
    public	void	onLongPress(MotionEvent	arg0)	{
//	TODO	Auto-generated	method	stub

    }

    @Override
    public	boolean	onScroll(MotionEvent	arg0,	MotionEvent	arg1,	float	arg2,
                                  float	arg3)	{
//	TODO	Auto-generated	method	stub
        return	false;
    }

    @Override
    public	void	onShowPress(MotionEvent arg0)	{
//	TODO	Auto-generated	method	stub

    }

    @Override
    public	boolean	onSingleTapUp(MotionEvent	arg0)	{
//	TODO	Auto-generated	method	stub
        return	false;
    }


}
