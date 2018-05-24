package com.example.a2mmm.gift;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.example.a2mmm.gift.MainActivity.pre;
import static com.example.a2mmm.gift.MainActivity.sh;
import static com.example.a2mmm.gift.MainActivity.tft;
import static com.example.a2mmm.gift.MainActivity.user;
import static java.lang.Math.abs;

public class suggestFragment extends Fragment {
    LinearLayout hh1;
    int zsy=0,zrsy=0;
    ScrollView hh2;
    String item[] ={"这里选择答案","1.A","2.B","3.C","4.D","5.E"};
    TextView btn,aa,k1,k2,k3,k4,k5,k6,k7,k8,k9,k10,zsy1,sy,nh;
    int linshi=0;
    int a[]=new int[11];
    Button sugbt;
    private AlertDialog alertDialog2;
    final Handler hand = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    a[1]=linshi;
                    break;
                case 2:
                    a[2]=linshi;
                    break;
                case 3:
                    a[3]=linshi;
                    break;
                case 4:
                    a[4]=linshi;
                    break;
                case 5:
                    a[5]=linshi;
                    break;
                case 6:
                    a[6]=linshi;
                    break;
                case 7:
                    a[7]=linshi;
                    break;
                case 8:
                    a[8]=linshi;
                    break;
                case 9:
                    a[9]=linshi;
                    break;
                case 10:
                    a[10]=linshi;
                    break;

            }
        }
    };
    public suggestFragment() {

    }
    static   String[] name={"江南+融通", "中铁+ 广发", "山东+中融", "中融+交大",
            "豫光+嘉实", "宏达+国寿", "栖霞+ST东北","厦门+白云",
            "保变+东风", "时代+国贸","理财产品1", "理财产品2", "理财产品3", "理财产品4",
            "理财产品5", "理财产品6", "理财产品7","理财产品8",
            "理财产品9", "理财产品10"};
    private  String[] data={"星期一","星期二","星期三","星期四","星期五","星期六","星期天"};
    private  String[] code={"600527","600528","600529","600530","600531","600532",
            "600533","600549","600550","600551"};
    private  double bfnum[]={1.11,3.17,-4.56,8.12,4.15,-3.16,4.12,8.45,5.55,-6.66};
    private  String sznum[]={"6.77","8.34","7.66","8.76","66.74","36.12","7.86","5.66","7.12","2.33"};
    private  double zfnum[]={7.21,5.67,8.96,0.99,5.66,7.13,5.11,1.15,7.67,8.13};
    private  double kjnum[]={5.21,7.66,1.23,4.51,3.41,6.11,4.64,6.11,1.37,5.25};
    private ListView listView,listView1;
    LineChart mChart;
    LinearLayout kyjl;
    Button kk1,kk2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_suggest,container,false);
        View headerView = getLayoutInflater(savedInstanceState).inflate(R.layout.suggest_head, null);
        SysApplication.getInstance().addActivity(getActivity());
        zsy1=(TextView) headerView.findViewById(R.id.zse);
        sy=(TextView) headerView.findViewById(R.id.se);
        nh=(TextView) headerView.findViewById(R.id.nh);
        kyjl=(LinearLayout) headerView.findViewById(R.id.kyjl);
        kk1=(Button) headerView.findViewById(R.id.k1);
        kk2=(Button) headerView.findViewById(R.id.k2);
        kk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setVisibility(View.VISIBLE);
                listView1.setVisibility(View.GONE);
                kyjl.setBackgroundResource(R.mipmap.biosex_content_female);
            }
        });
        kk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView1.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
                kyjl.setBackgroundResource(R.mipmap.biosex_content_male);
            }
        });
        mChart = (LineChart) headerView.findViewById(R.id.chart);
        mChart.setGridBackgroundColor(Color.rgb(255, 255, 255));
        mChart.setDescription("");
        mChart.setTouchEnabled(false);
        //设置是否可以拖拽，缩放
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(false    );
        //设置是否能扩大扩小
        mChart.setPinchZoom(true);




        XAxis xl = mChart.getXAxis();
//      xl.setAvoidFirstLastClipping(true);
//      xl.setAdjustXLabels(true);
        xl.setPosition(XAxis.XAxisPosition.BOTTOM); // 设置X轴的数据在底部显示
        xl.setTextSize(7f); // 设置字体大小
        xl.setSpaceBetweenLabels(2); // 设置数据之间的间距'
        xl.setDrawGridLines(false);;


//      yl.setLabelCount(5); // 设置Y轴最多显示的数据个数

        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < 7; i++) {
            // x轴显示的数据，这里默认使用数字下标显示
            xVals.add(data[i]);
        }

        // y轴的数据
        java.util.Random r=new java.util.Random();
        ArrayList<Entry> yVals = new ArrayList<Entry>();
        for (int i = 0; i < 7; i++) {
            int val =  r.nextInt(10)-4 ;
            zsy=zsy+val;
            yVals.add(new Entry(val, i));
            if (i==6) zrsy=val;

        }
        String h="总收益："+zsy+".00元";
        zsy1.setText(h);
        h=zrsy+".00";
        sy.setText(h);
        float abc=((float)zsy/700)*365;
        if (zsy>=0) h="七日年化收益率："+(int)abc+"."+abs((int)((abc-(int)abc)*10))+"%";
        else h="七日年化收益率：-"+abs((int)abc)+"."+abs((int)((abc-(int)abc)*10))+"%";
        nh.setText(h);
        // create a dataset and give it a type
        // y轴的数据集合
        LineDataSet set1 = new LineDataSet(yVals,"k-line");
        //set1.setFillAlpha(110);
        // set1.setFillColor(Color.RED);

        set1.setLineWidth(1.75f); // 线宽
        set1.setCircleSize(1f);// 显示的圆形大小
        set1.setColor(Color.BLUE);// 显示颜色
        set1.setDrawValues(false);
        set1.setCircleColor(Color.BLUE);// 圆形的颜色
        set1.setHighLightColor(Color.BLACK); // 高亮的线的颜色
        YAxis yl = mChart.getAxisLeft();
        yl.setDrawAxisLine(false);
        yl.setStartAtZero(false);

        yl.setDrawGridLines(false);;
        yl.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yl.setTextSize(7f); // s设置字体大小
        yl.setAxisMinValue(-5f);
        YAxis yAxisRight = mChart.getAxisRight();
        yAxisRight.setEnabled(false);
        ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();
        dataSets.add(set1);
        getData1(mChart,dataSets,xVals);
        // create a data object with the datasets

        Legend l = mChart.getLegend();
        l.setEnabled(false);

        mChart.invalidate();
        listView1 = (ListView)v.findViewById(R.id.listview1);
        listView1.addHeaderView(headerView);
        List<suggest> mData1=getData2();
        listView1.setAdapter(new suggestAdapter(this.getActivity(), (LinkedList<suggest>) mData1));

        listView = (ListView)v.findViewById(R.id.listview);
        listView.addHeaderView(headerView);
       List<suggest> mData=getData();
        listView.setAdapter(new suggestAdapter(this.getActivity(), (LinkedList<suggest>) mData));
        hh1=(LinearLayout) v.findViewById(R.id.hh1);
        hh2=(ScrollView) v.findViewById(R.id.hh2);
        k1=(TextView) v.findViewById(R.id.k1);
        k2=(TextView) v.findViewById(R.id.k2);
        k3=(TextView) v.findViewById(R.id.k3);
        k4=(TextView) v.findViewById(R.id.k4);
        k5=(TextView) v.findViewById(R.id.k5);
        k6=(TextView) v.findViewById(R.id.k6);
        k7=(TextView) v.findViewById(R.id.k7);
        k8=(TextView) v.findViewById(R.id.k8);
        k9=(TextView) v.findViewById(R.id.k9);
        k10=(TextView) v.findViewById(R.id.k10);
        btn=(TextView) v.findViewById(R.id.btn);
        tft=(sh.read(user+"tt").get(user+"tt"));
        if (tft.equals("1"))
        {
            hh1.setVisibility(View.GONE);
            hh2.setVisibility(View.VISIBLE);
        }
        else
        {
            hh1.setVisibility(View.VISIBLE);
            hh2.setVisibility(View.GONE);
        }
        k1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linshi=0;
                showSingleAlertDialog(v,"选择答案",item,k1,1);
            }
        });
        k2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linshi=0;
                showSingleAlertDialog(v,"选择答案",item,k2,2);
            }
        });
        k3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linshi=0;
                showSingleAlertDialog(v,"选择答案",item,k3,3);
            }
        });
        k4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linshi=0;
                showSingleAlertDialog(v,"选择答案",item,k4,4);
            }
        });
        k5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linshi=0;
                showSingleAlertDialog(v,"选择答案",item,k5,5);
            }
        });
        k6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linshi=0;
                showSingleAlertDialog(v,"选择答案",item,k6,6);
            }
        });
        k7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linshi=0;
                showSingleAlertDialog(v,"选择答案",item,k7,7);
            }
        });
        k8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linshi=0;
                showSingleAlertDialog(v,"选择答案",item,k8,8);
            }
        });
        k9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linshi=0;
                showSingleAlertDialog(v,"选择答案",item,k9,9);
            }
        });
        k10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linshi=0;
                showSingleAlertDialog(v,"选择答案",item,k10,10);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=1;
                int tot=0;
                boolean bo=true;
                while (i<=10)
                {
                    if (a[i]==0) bo=false;
                    tot=tot+a[i];
                    i++;
                }
                if (bo) {
                    Toast.makeText(getActivity(), "提交成功"+tot, Toast.LENGTH_SHORT).show();
                    if (tot<=20) sh.save(user+"le","(保守型)");
                    else if (tot<=30) sh.save(user+"le"," 稳健型");
                    else if (tot<=50) sh.save(user+"le"," 积极型");

                    sh.save(user+"tt", "0");
                    pre = 2;
                    Intent intent = new Intent(getActivity(), Main2Activity.class);
                    startActivity(intent);
                }
                else Toast.makeText(getActivity(), "请先完成表格再提交答案", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
    public void showSingleAlertDialog(final View view, String title, final String[] items , final TextView bb,final int bm){

        aa=bb;
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this.getActivity());
        alertBuilder.setTitle(title);
        alertBuilder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int index) {
                linshi=index;
            }
        });
        alertBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                //TODO 业务逻辑代码
                aa.setText(items[linshi]);
                aa.setTextColor(ContextCompat.getColor(getActivity(),R.color.text_upbar));
                hand.sendEmptyMessage(bm);
                alertDialog2.dismiss();
            }
        });
        alertBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // TODO 业务逻辑代码
                linshi=0;
                hand.sendEmptyMessage(bm);
                // 关闭提示框
                alertDialog2.dismiss();
            }
        });
        alertDialog2 = alertBuilder.create();
        alertDialog2.show();
    }
    public List<suggest> getData(){
        List<suggest> list=new LinkedList<suggest>();
        for (int i = 0; i < 10; i++) {
            list.add(new suggest(name[i],code[i],bfnum[i],sznum[i],zfnum[i],sh.read(user+"le").get(user+"le"),kjnum[i],i));
        }
        return list;
    }
    public List<suggest> getData2(){
        List<suggest> list=new LinkedList<suggest>();
        for (int i = 0; i < 10; i++) {
            list.add(new suggest(name[i+10],code[i],bfnum[9-i],sznum[9-i],zfnum[9-i],"固定产品",kjnum[9-i],i+10));
        }
        return list;
    }
    private void getData1(LineChart mChart, ArrayList<LineDataSet> dataSets, ArrayList<String> xVals){
        LineData data = new LineData(xVals,  dataSets);
        mChart.setData(data);
        mChart.animateX(2000);
        mChart.setScaleMinima(0.5f, 1f);
    }

}
