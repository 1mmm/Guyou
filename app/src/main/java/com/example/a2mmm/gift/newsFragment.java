package com.example.a2mmm.gift;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.a2mmm.gift.MainActivity.sspp;
import static com.example.a2mmm.gift.MainActivity.target;
import static com.example.a2mmm.gift.MainActivity.token1;
import static com.example.a2mmm.gift.chatFragment.email;
import static com.example.a2mmm.gift.chatFragment.phone;
import static com.example.a2mmm.gift.welcome.qq;
import static java.lang.Integer.valueOf;


public class newsFragment extends Fragment {
    int[] it1={157,97,120,1,83,25,78,42,41,30,88,15,45,68,119,118,138,29,71,70,73,37,115,26,101,131,40,79,24,90,133,104,83,3,83,143,127,9,57,21,139,114,105,67,107,130,149,54,101,149,122,142,33,149,72,93,48,28,31,95,74,13,49,34,11,58,99,126,152,148,81,55,116,36,110,80,112,8,109,61,56,46,50,146,16,106,134,140,146,2,23,21,155,135,100,86,123,64,75,7,113,136,87,116,153,92,98,14,131,63,101,20,107,121,19,4,38,69,137,17,143,47,35,65,141,77,52,51,129,124,111,90,127,59,42,153,5,93,96,62,39,53,12,42,32,6,60,124,143,66,76,18,10,82,89,27,156,156,156 };
    String[] items1={"这里选择学校","安徽大学","安徽师范大学","北京大学","北京工业大学","北京航空航天大学","北京化工大学","北京交通大学","北京科技大学","北京理工大学","北京林业大学","北京师范大学","北京协和医学院","北京邮电大学","北京中医药大学","重庆大学","成都理工大学","大连海事大学","大连理工大学","第二军医大学","第三军医大学","第四军医大学","电子科技大学","东北财经大学","东北大学","东北林业大学","东北农业大学","东北师范大学","东华大学","东南大学","对外经济贸易大学","福建农林大学","福建师范大学","福州大学","复旦大学","广西大学","广西师范大学","贵州大学","国防科学技术大学","哈尔滨工程大学","哈尔滨工业大学","哈尔滨医科大学","海南大学","杭州电子科技大学","合肥工业大学","河北大学","河北工业大学","河北师范大学","河海大学","河南大学","河南农业大学","黑龙江大学","湖北大学","湖南大学","湖南农业大学","湖南师范大学","华北电力大学","华东理工大学","华东师范大学","华南理工大学","华南农业大学","华南师范大学","华中科技大学","华中农业大学","华中师范大学","吉林大学","暨南大学","江南大学","江苏大学","江西财经大学","江西师范大学","解放军理工大学","解放军信息工程大学","昆明理工大学","兰州大学","辽宁大学","南昌大学","南方医科大学","南京大学","南京工业大学","南京航空航天大学","南京理工大学","南京农业大学","南京师范大学","南京邮电大学","南开大学","内蒙古大学","宁波大学","宁夏大学","青岛大学","清华大学","厦门大学","山东大学","山东农业大学","山东师范大学","山西大学","陕西师范大学","汕头大学","上海财经大学","上海大学","上海交通大学","上海理工大学","上海师范大学","深圳大学","石河子大学","首都经济贸易大学","首都师范大学","首都医科大学","四川大学","四川农业大学","苏州大学","太原理工大学","天津大学","天津师范大学","天津医科大学","同济大学","武汉大学","武汉理工大学","西安电子科技大学","西安建筑科技大学","西安交通大学","西安理工大学","西北大学","西北工业大学","西北农林科技大学","西北师范大学","西南财经大学","西南大学","西南交通大学","西南政法大学","湘潭大学","新疆大学","燕山大学","扬州大学","云南大学","长安大学","长春理工大学","浙江大学","浙江工业大学","浙江师范大学","郑州大学","中国地质大学","中国海洋大学","中国科学技术大学","中国矿业大学","中国农业大学","中国人民大学","中国石油大学","中国药科大学","中国医科大学","中国政法大学","中南财经政法大学","中南大学","中山大学","中央财经大学","中央民族大学","其他"};
    String[] items2 ={"这里选择专业类别","1.其他类","2.社科类","2.艺术类","4.文史类","5.理工类","6.金融类"};
    String[] items3 ={"这里选择贷款目的","1.出国读研","2.国内读书","3.其他"};
    String[] items4 ={"这里选择等级","1.国际级","2.国家级","3.省级","4.市级","5.无"};
    String[] items5 ={"在这里选择银行","1.花旗银行","2.中国银行","3.农业银行","4.工商银行","5.建设银行"};
    String[] items6 ={"在这里选择英语成绩","115-120/8.5-9/650-710","110-114/8/600-650","102-109/7.5/550-600","94-101/7/425-550","0-93/1-6.5/0-425"};
    String[] items7 ={"在这里选择时长区间",">24","12-23","6-11","1-5","0"};
    public newsFragment() {

    }

    public class erro {
        private int errno;
        erro(int errno){
            this.errno = errno;
        }
    }
    Button btn1,btn2,btn3,k1,k2;

    private AlertDialog alertDialog2;
    double tot=0;
    static  double x1=0;
    boolean bbb=false;
    static  int y11=0;
    LinearLayout xb,kyjl;
    double gg=0;
    String tt="",reason=qq.getreason();
    public String base_url="http://101.132.106.1/";
    private final OkHttpClient client = new OkHttpClient();
    TextView school,aa,zy,dkmd,zgdj,yh,pz,yycj,sxsc;
    int experiment,sex;
    public  int pre=-1,linshi=-1,schoolno=qq.getschool(),majorno=qq.getmajortype(),rank=qq.getrank(),bank=qq.getbank(),english=qq.getenglish(),workingtime=qq.getworktime();
    EditText name,jtdz,nj,pjpga,qtyy,sr,dyp,ck,kh,sfz,fmxm,fqsfz,mqsfz,xh,dh,yx,dypfj;
    URL url;
    private ProgressDialog pd2 = null;
    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;
    private final static int MAXVALUE = 100;
    private int progressStart = 0;

    private int add = 0;
    final Handler hand = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            //这里的话如果接受到信息码是123
            switch (msg.what) {
                case 0:
                    int y=2;
                    if (!(qq.getname().equals("null")|qq.getname().equals(""))) y++;

                    if (!(qq.getstuid().equals("null")|qq.getstuid().equals(""))) y++;

                    if (!(qq.getgrade().equals("null")|qq.getgrade().equals(""))) y++;
                    if (!(qq.getgpa().equals("null")|qq.getgpa().equals(""))) y++;



                    if (!(qq.getaddr().equals("null")|qq.getaddr().equals("")))y++;
                    if (!(qq.getphone().equals("null")|qq.getphone().equals(""))) y++;
                    if (!(qq.getmail().equals("null")|qq.getmail().equals(""))) y++;

                    if (!(qq.getincome().equals("null")|qq.getincome().equals(""))) y++;
                    if (!(qq.getpledge().equals("null")|qq.getpledge().equals(""))) y=y+3;

                    if (!(qq.getsaving().equals("null")|qq.getsaving().equals(""))) y++;
                    if (!(qq.getbankno().equals("null")|qq.getbankno().equals(""))) y++;
                    if (!(qq.getidno().equals("null")|qq.getidno().equals(""))) y++;
                    if (!(qq.getpname().equals("null")|qq.getpname().equals(""))) y++;
                    if (!(qq.getfidno().equals("null")|qq.getfidno().equals(""))) y++;
                    if (!(qq.getmidno().equals("null")|qq.getmidno().equals(""))) y++;
                    if (rank>0) y++;
                    if (schoolno>0) y++;
                    if (majorno>0) y++;
                    if (bank>0)y++;
                    if (english>0) y++;
                    if (workingtime>0) y++;
                    if (!(qq.getreason().equals("null") |!qq.getreason().equals("")))
                        if (!(qq.getreason().substring(0,1).equals("1")|qq.getreason().substring(0,1).equals("2")|qq.getreason().substring(0,1).equals("3"))) y++;

                    target=(float)y*100/25-1;

                    Toast.makeText(getActivity(), "提交成功", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(getActivity(), "提交失败", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    if (progressStart >=MAXVALUE)
                    {
                        pd2.dismiss();
                    }
                    break;
                case 123:
                    //设置进度条的当前值
                    pd2.setProgress(progressStart);
                    break;
                case 11:
                    schoolno=linshi;
                    break;
                case 22:
                    majorno=linshi;
                    break;
                case 33:
                    reason=items3[linshi];
                    break;
                case 44:
                    rank=linshi;
                    break;
                case 55:
                    bank=linshi;
                    break;
                case 66:
                    english=linshi;
                    break;
                case 77:
                    workingtime=linshi;
                    break;

            }
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_news,container,false);
        SysApplication.getInstance().addActivity(getActivity());
        btn1=(Button) v.findViewById(R.id.male);
        btn2=(Button) v.findViewById(R.id.female);
        kyjl=(LinearLayout)  v.findViewById(R.id.kyjl);
        xb=(LinearLayout)  v.findViewById(R.id.xb);


        school=(TextView) v.findViewById(R.id.school);
        if (qq.getschool()>0)school.setText(items1[qq.getschool()]);
        zy=(TextView) v.findViewById(R.id.zy);
        if (qq.getmajortype()>0)zy.setText(items2[qq.getmajortype()]);
        dkmd=(TextView) v.findViewById(R.id.dkmd);
        yycj=(TextView) v.findViewById(R.id.yycj);
        if (qq.getenglish()>0)yycj.setText(items6[qq.getenglish()]);
        zgdj=(TextView) v.findViewById(R.id.zgdj);
        if (qq.getrank()>0)zgdj.setText(items4[qq.getrank()]);
        yh=(TextView) v.findViewById(R.id.yh);
        if (qq.getbank()>0) yh.setText(items5[qq.getbank()]);
        sxsc=(TextView) v.findViewById(R.id.sxsc);
        if (qq.getworktime()>0) sxsc.setText(items7[qq.getworktime()]);
        pz=(TextView) v.findViewById(R.id.pz);
        name=(EditText) v.findViewById(R.id.name);
        if (!qq.getname().equals("null"))name.setText(qq.getname());
        jtdz=(EditText) v.findViewById(R.id.jtzz);
        if (!qq.getaddr().equals("null"))jtdz.setText(qq.getaddr());
        dyp=(EditText) v.findViewById(R.id.dyp);
        dypfj=(EditText) v.findViewById(R.id.dypfj);
        if (!qq.getpledge().equals("null"))
            if (!qq.getpledge().equals("")) {
                int t=0;
                t=qq.getpledge().indexOf(",");
                dypfj.setText(qq.getpledge().substring(0,t));
                if (t+1<=qq.getpledge().length())
                    dyp.setText(qq.getpledge().substring(t+1));
            }
        sr=(EditText) v.findViewById(R.id.sr);
        if (!qq.getincome().equals("null"))sr.setText(qq.getincome());
        ck=(EditText) v.findViewById(R.id.ck);
        if (!qq.getsaving().equals("null"))ck.setText(qq.getsaving());
        kh=(EditText) v.findViewById(R.id.kh);
        if (!qq.getbankno().equals("null")) kh.setText(qq.getbankno());
        sfz=(EditText) v.findViewById(R.id.sfzh);
        if (!qq.getidno().equals("null"))sfz.setText(qq.getidno());
        fmxm=(EditText) v.findViewById(R.id.fmxm);
        if (!qq.getpname().equals("null"))fmxm.setText(qq.getpname());
        fqsfz=(EditText) v.findViewById(R.id.fqsfz);
        if (!qq.getfidno().equals("null"))fqsfz.setText(qq.getfidno());
        mqsfz=(EditText) v.findViewById(R.id.mqsfz);
        if (!qq.getmidno().equals("null"))mqsfz.setText(qq.getmidno());
        xh=(EditText) v.findViewById(R.id.xh);
        if (!qq.getstuid().equals("null"))xh.setText(qq.getstuid());
        dh=(EditText) v.findViewById(R.id.dh);
        if (!qq.getphone().equals("null"))dh.setText(qq.getphone());
        yx=(EditText) v.findViewById(R.id.yx);
        if (!qq.getmail().equals("null"))yx.setText(qq.getmail());
        nj=(EditText) v.findViewById(R.id.nj);
        if (!qq.getgrade().equals("null"))nj.setText(qq.getgrade());
        pjpga=(EditText) v.findViewById(R.id.pjpga);
        if (!qq.getgpa().equals("null")) pjpga.setText(qq.getgpa());
        qtyy=(EditText) v.findViewById(R.id.qtyy);
        if (!qq.getreason().equals("null"))
            if (qq.getreason().substring(0,1).equals("3"))
            {
                dkmd.setText(qq.getreason().substring(0,4));
                qtyy.setVisibility(View.VISIBLE);
                qtyy.setText(qq.getreason().substring(4));
                reason=qq.getreason().substring(0,4);
            }
            else dkmd.setText(qq.getreason());



        btn3=(Button) v.findViewById(R.id.ok);
        k1=(Button) v.findViewById(R.id.k1);
        k2=(Button) v.findViewById(R.id.k2);


        yycj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linshi=0;
                showSingleAlertDialog(v,"托福/雅思/六级",items6,yycj,66);
            }
        });
        sxsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linshi=0;
                showSingleAlertDialog(v,"选择实习时长所在区间（月）",items7,sxsc,77);
            }
        });
        pz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PhotoActivity.class);
                startActivity(intent);
            }
        });
        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linshi=0;
                showSingleAlertDialog(v,"选择学校",items1,school,11);
            }
        });
        zy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linshi=0;
                showSingleAlertDialog(v,"选择所在专业",items2,zy,22);
            }
        });
        dkmd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linshi=0;
                showSingleAlertDialog(v,"选择贷款目的",items3,dkmd,33);
            }
        });
        zgdj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linshi=0;
                showSingleAlertDialog(v,"选择获奖最高等级",items4,zgdj,44);
            }
        });
        yh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linshi=0;
               showSingleAlertDialog(v,"我们只与以下五家银行合作",items5,yh,55);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sex=1;
                xb.setBackgroundResource(R.mipmap.biosex_content_female);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sex=0;
                xb.setBackgroundResource(R.mipmap.biosex_content_male);
            }
        });
        k1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                experiment=1;
                kyjl.setBackgroundResource(R.mipmap.biosex_content_female);
            }
        });
        k2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                experiment=0;
                kyjl.setBackgroundResource(R.mipmap.biosex_content_male);
            }
        });
        if (qq.getsex()==1) btn1.performClick();
        else btn2.performClick();
        if (qq.getexperiment()==1) k1.performClick();
        else k2.performClick();
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressStart = 0;
                add = 0;
                //依次设置一些属性
                pd2 = new ProgressDialog(getActivity());
                pd2.setMax(MAXVALUE);
                pd2.setTitle("正在提交");
                pd2.setMessage("提交个人资料中,请稍后...");
                pd2.setButton(DialogInterface.BUTTON_NEUTRAL,"取消",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        pd2.dismiss();
                    }
                });
                pd2.setCancelable(false);
                //这里设置为不可以通过按取消按钮关闭进度条
                pd2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                //这里设置的是是否显示进度,设为false才是显示的哦！
                pd2.setIndeterminate(false);
                pd2.show();
                //这里的话新建一个线程,重写run()方法,
                new Thread()
                {
                    public void run()
                    {
                        while(progressStart < MAXVALUE)
                        {
                            //这里的算法是决定进度条变化的,可以按需要写
                            progressStart = 2 * usetime() ;
                            //把信息码发送给handle让更新界面
                            hand.sendEmptyMessage(123);
                        }
                        hand.sendEmptyMessage(3);
                    }
                }.start();
                new Thread()
                {
                    @Override
                    public void run() {
                        try {
                            FormBody.Builder pa=new  FormBody.Builder();
                            pa.add("token",token1);
                            if (!name.getText().toString().equals(""))pa.add("name",name.getText().toString());
                            qq.setname(name.getText().toString());
                            if (!dh.getText().toString().equals(""))pa.add("phone",dh.getText().toString());
                            phone.setText(dh.getText().toString());
                            qq.setphone(dh.getText().toString());
                            if (!jtdz.getText().toString().equals(""))pa.add("addr",jtdz.getText().toString());
                            qq.setaddr(jtdz.getText().toString());
                            if (!yx.getText().toString().equals(""))pa.add("mail",yx.getText().toString());
                            qq.setmail(yx.getText().toString());
                            email.setText(yx.getText().toString());
                            if (schoolno>0) pa.add("school",schoolno+"");
                            qq.setschool(schoolno);
                            if (!xh.getText().toString().equals(""))pa.add("stuid",xh.getText().toString());
                            qq.setstuid(xh.getText().toString());
                            if (reason.substring(0,1).equals("1")|reason.substring(0,1).equals("2")|reason.substring(0,1).equals("3"))pa.add("reason",reason+qtyy.getText().toString());
                            qq.setreason(reason);
                            pa.add("sex",sex+"");
                            qq.setsex(sex);
                            if (majorno>0) pa.add("major",majorno+"");
                            if (majorno>-1) qq.setmajortype(majorno);
                            if (!nj.getText().toString().equals(""))pa.add("grade",nj.getText().toString());
                            qq.setgrade(nj.getText().toString());
                            if (!pjpga.getText().toString().equals(""))pa.add("gpa",pjpga.getText().toString());
                            qq.setgpa(pjpga.getText().toString());
                            pa.add("experiment",experiment+"");
                            qq.setexperiment(experiment);
                            if (english!=-1) pa.add("english",english+"");
                            qq.setenglish(english);
                            if (workingtime!=-1) pa.add("worktime",workingtime+"");
                            qq.setworktime(workingtime);
                            if (rank!=-1) pa.add("rank",rank+"");
                            qq.setrank(rank);
                            if (!sr.getText().toString().equals(""))pa.add("income",sr.getText().toString());
                            qq.setincome(sr.getText().toString());
                            if (!((dypfj.getText().toString().equals(""))&(dyp.getText().toString().equals(""))))
                            pa.add("pledge",dypfj.getText().toString()+","+dyp.getText().toString());
                            qq.setpledge(dypfj.getText().toString()+","+dyp.getText().toString());
                            if (bank!=-1) pa.add("bank",bank+"");
                            qq.setbank(bank);
                            if (!ck.getText().toString().equals(""))pa.add("saving",ck.getText().toString());
                            qq.setsaving(ck.getText().toString());
                            if (!kh.getText().toString().equals(""))pa.add("bankno",kh.getText().toString());
                            qq.setbankno(kh.getText().toString());
                            if (!sfz.getText().toString().equals(""))pa.add("idno",sfz.getText().toString());
                            qq.setidno(sfz.getText().toString());
                            if (!fmxm.getText().toString().equals(""))pa.add("pname",fmxm.getText().toString());
                            qq.setpname(fmxm.getText().toString());
                            if (!fqsfz.getText().toString().equals(""))pa.add("fidno",fqsfz.getText().toString());
                            qq.setfidno(fqsfz.getText().toString());
                            if (!mqsfz.getText().toString().equals(""))pa.add("midno",mqsfz.getText().toString());
                            qq.setmidno(mqsfz.getText().toString());
                            double z1,z2,z3,z4,z5,x2,x3,y1,y2,y3,y4;
                            int y22=0; bbb=true;
                            z1=0;z2=0;z3=0;z4=0;z5=0;x2=0;x3=0;gg=0;
                            if (!pjpga.getText().toString().equals("")) {
                                if (!pjpga.getText().toString().substring(0, 1).equals("0"))
                                    gg = Float.valueOf(pjpga.getText().toString());
                            }
                            else bbb=false;
                            if (english>0)  z2=0.2*(6-english);
                            else bbb=false;
                            if (workingtime>0) z3=0.1*(6-workingtime);
                            else bbb=false;
                            z4=0.15*experiment*5;
                            if (rank>0) z5=0.15*(6-rank);
                            else bbb=false;
                            x1=(z1+z2+z3+z4+z5)*0.6;
                            if (majorno>-1)x2=majorno*0.5;
                            else bbb=false;
                            x3=(((float)(157-it1[schoolno])/156)*5)*0.3;
                            if (!dypfj.getText().toString().equals("")) {
                                if (!dypfj.getText().toString().substring(0, 1).equals("0"))
                                    y11 = valueOf(dypfj.getText().toString());
                                else bbb = false;
                            }
                            else bbb=false;
                            if (!dyp.getText().toString().equals("")) {
                                if (!dyp.getText().toString().substring(0, 1).equals("0"))
                                    y22 = valueOf(dyp.getText().toString());
                                else bbb=false;
                            }
                            else bbb=false;
                            y11=y22*y11;
                            if (y11<200000) y1=1*0.5;
                            else if (y11<500000) y1=2*0.5;
                            else if (y11<1000000) y1=3*0.5;
                            else if (y11<2000000) y1=4*0.5;
                            else y1=5*0.5;
                            y2=(x1+x2+x3)*0.3;
                            if (y2>1.14) y2=1.14;
                            if (y2<0.305) y2=0.305;
                            y3=0;
                            if (!sr.getText().toString().equals("")) {
                                if (!sr.getText().toString().substring(0, 1).equals("0"))
                                    y3 = valueOf(sr.getText().toString())*0.05/8;
                            }
                            else bbb=false;
                            if (y3>0.25) y3=0.25;
                            if (y3<0.0525) y3=0.0525;
                            y4=0;
                            if (!ck.getText().toString().equals("")) {
                                if (!ck.getText().toString().substring(0, 1).equals("0"))
                                    y4 = valueOf(ck.getText().toString()) * 0.15 / 8;
                            }
                            else bbb=false;
                            if (y4>0.75) y4=0.75;
                            if (y4<0.155) y4=0.155;
                            tot=y1+y2+y3+y4+gg*0.072;
                            tot=1500000*(tot-1.0125)/3.9875;
                            pre=(int) tot;
                            qq.setpre(pre+"");
                            pa.add("pre",pre+"");
                            pa.add("photo",sspp);
                            tt=post(pa,"update.php");

                            Gson gson = new Gson();
                            int er = gson.fromJson(tt,erro.class).errno;
                            if (er==0)
                            {
                                hand.sendEmptyMessage(0);

                            }
                            else if (er==1) hand.sendEmptyMessage(1);
                        }
                        catch (Exception e)
                        {
                            hand.sendEmptyMessage(1);
                        }
                    }


                }.start();

            }
        });
        return v;
    }
    private int usetime() {
        add++;
        try{
            Thread.sleep(10);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return add;
    }
    // 单选提示框
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
                hand.sendEmptyMessage(bm);
                // 关闭提示框
                if ((bb== view.findViewById(R.id.dkmd))&(linshi==3))  qtyy.setVisibility(View.VISIBLE);
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
    String post(FormBody.Builder pa,String UR) throws Exception {
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