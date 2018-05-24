package com.example.a2mmm.gift;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.a2mmm.gift.MainActivity.pre;
import static com.example.a2mmm.gift.MainActivity.target;
import static com.example.a2mmm.gift.MainActivity.token1;
import static com.example.a2mmm.gift.newsFragment.x1;
import static com.example.a2mmm.gift.welcome.qq;
import static java.lang.Integer.valueOf;
import static java.lang.Math.abs;

public class mainFragment extends Fragment {

    static  PercentageRing mPercentageRing1;
    private AlertDialog alertDialog2;
    public String base_url="http://101.132.106.1/";
    private final OkHttpClient client = new OkHttpClient();
    String tt="",C="",D="",opt="";
    int linshi=0,a1=0,a2=0,a3=0,a4=0,A,B;
    String[] items1 ={"这里选择期限"};
    String[] items2 ={"此处选择本人还款方式","1.等额本金法","2.等额本息法"};
    String[] items3 ={"此处选择父母还款方式","1.等额本金法","2.等额本息法"};
    String[] items4 ={"这里选择期限","1个月","2个月","3个月","4个月","5个月","6个月","7个月","8个月","9个月","10个月","11个月","1年0个月","1年1个月","1年2个月","1年3个月","1年4个月","1年5个月","1年6个月","1年7个月","1年8个月","1年9个月","1年10个月","1年11个月","2年0个月","2年1个月","2年2个月","2年3个月","2年4个月","2年5个月","2年6个月","2年7个月","2年8个月","2年9个月","2年10个月","2年11个月","3年0个月","3年1个月","3年2个月","3年3个月","3年4个月","3年5个月","3年6个月","3年7个月","3年8个月","3年9个月","3年10个月","3年11个月","4年0个月","4年1个月","4年2个月","4年3个月","4年4个月","4年5个月","4年6个月","4年7个月","4年8个月","4年9个月","4年10个月","4年11个月","5年0个月","5年1个月","5年2个月","5年3个月","5年4个月","5年5个月","5年6个月","5年7个月","5年8个月","5年9个月","5年10个月","5年11个月","6年0个月","6年1个月","6年2个月","6年3个月","6年4个月","6年5个月","6年6个月","6年7个月","6年8个月","6年9个月","6年10个月","6年11个月","7年0个月","7年1个月","7年2个月","7年3个月","7年4个月","7年5个月","7年6个月","7年7个月","7年8个月","7年9个月","7年10个月","7年11个月","8年0个月","8年1个月","8年2个月","8年3个月","8年4个月","8年5个月","8年6个月","8年7个月","8年8个月","8年9个月","8年10个月","8年11个月","9年0个月","9年1个月","9年2个月","9年3个月","9年4个月","9年5个月","9年6个月","9年7个月","9年8个月","9年9个月","9年10个月","9年11个月","10年0个月","10年1个月","10年2个月","10年3个月","10年4个月","10年5个月","10年6个月","10年7个月","10年8个月","10年9个月","10年10个月","10年11个月","11年0个月","11年1个月","11年2个月","11年3个月","11年4个月","11年5个月","11年6个月","11年7个月","11年8个月","11年9个月","11年10个月","11年11个月","12年0个月","12年1个月","12年2个月","12年3个月","12年4个月","12年5个月","12年6个月","12年7个月","12年8个月","12年9个月","12年10个月","12年11个月","13年0个月","13年1个月","13年2个月","13年3个月","13年4个月","13年5个月","13年6个月","13年7个月","13年8个月","13年9个月","13年10个月","13年11个月","14年0个月","14年1个月","14年2个月","14年3个月","14年4个月","14年5个月","14年6个月","14年7个月","14年8个月","14年9个月","14年10个月","14年11个月"};
    final Handler handed = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    a1=linshi;
                    break;
                case 2:
                    a2=linshi;
                    break;
                case 3:
                    a3=linshi;
                    break;
                case 4:
                    a4=linshi;
                    break;
                case 5:
                    Toast.makeText(getActivity(), "发送成功", Toast.LENGTH_SHORT).show();
                    break;
                case 6:
                    Toast.makeText(getActivity(), "发送失败", Toast.LENGTH_SHORT).show();
                    break;
                case 1234:
                    Toast.makeText(getActivity(), token1, Toast.LENGTH_SHORT).show();
                    break;
                case 1111:
                    Log.d( "handd: ",tt);
                    break;
                case 11111:
                    Toast.makeText(getActivity(), "错误", Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    };
    TextView sqdk,yuan,gs,dkqx,gzsj,hkfs1,hkfs2,aa,sx;
    EditText dkee,fmhk;
    boolean boo=false;
    int ff=0;
    static  TextView dke;
    private ProgressDialog pd2 = null;
    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;
    private final static int MAXVALUE = 100;
    private int progressStart = 0;
    private int add = 0;
    private Context mContext = null;
    public mainFragment() {

    }
    public class erro {
        private int errno;
        erro(int errno){
            this.errno = errno;
        }
    }
    final Handler hand = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            //这里的话如果接受到信息码是123
            if(msg.what == 123)
            {
                //设置进度条的当前值
                pd2.setProgress(progressStart);
            }
            //如果当前大于或等于进度条的最大值,调用dismiss()方法关闭对话框
            if(progressStart >= MAXVALUE)
            {
                pd2.dismiss();
            }
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main,container,false);
        SysApplication.getInstance().addActivity(getActivity());
        mPercentageRing1 = (PercentageRing) v.findViewById(R.id.Circle);
        mPercentageRing1.setTargetPercent((float) target);
        sqdk=(TextView ) v.findViewById(R.id.sqdk);
        dkqx=(TextView ) v.findViewById(R.id.dkqx);
        sx=(TextView) v.findViewById(R.id.sx);
        dkqx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linshi=0;
                showSingleAlertDialog(v,"选择贷款期限",items4,dkqx,1);
            }
        });
        gzsj=(TextView ) v.findViewById(R.id.gzsj);
        gzsj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items1=new String[a1+1];
                int tt=0;
                while (tt<=a1)
                {
                    items1[tt]=items4[tt];
                    tt++;
                }
                linshi=0;
                showSingleAlertDialog(v,"选择开始工作时间",items1,gzsj,2);
            }
        });
        hkfs1=(TextView ) v.findViewById(R.id.hkfs1);
        hkfs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linshi=0;
                showSingleAlertDialog(v,"选择父母还款方式",items3,hkfs1,3);
            }
        });
        hkfs2=(TextView ) v.findViewById(R.id.hkfs2);
        hkfs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linshi=0;
                showSingleAlertDialog(v,"选择本人还款方式",items2,hkfs2,4);
            }
        });
        fmhk=(EditText ) v.findViewById(R.id.fmhk);
        dke=(TextView ) v.findViewById(R.id.dke);
        yuan=(TextView ) v.findViewById(R.id.yuan);
        gs=(TextView ) v.findViewById(R.id.gs);

        dkee=(EditText) v.findViewById(R.id.dkee);
        gs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!qq.getpree() .equals("null")) {
                    boo=true;
                    String h;
                    if (valueOf(qq.getpree())<0)  h="￥0";
                     h = "￥" + qq.getpree();
                    dke.setText(h);
                }
                else Toast.makeText(getActivity(), "请检查个人资料必填项的正确性以及完整性", Toast.LENGTH_SHORT).show();
            }});
        sx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pre=1;
                Intent intent=new Intent(getActivity(),Main2Activity.class);
                startActivity(intent);
                getActivity().finish();
            }});
        dkee.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 输入的内容变化的监听
                String c="";
                if (!dkee.getText().toString().equals(""))
                    if (!dkee.getText().toString().substring(0,1).equals("0"))
                          ff=(int)(valueOf(dkee.getText().toString())*0.005);
                c=ff+"元";
                yuan.setText(c);
                Log.e("输入过程中执行该方法", "文字变化");
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // 输入前的监听
                Log.e("输入前确认执行该方法", "开始输入");

            }

            @Override
            public void afterTextChanged(Editable s) {
                // 输入后的监听
                Log.e("输入结束执行该方法", "输入结束");

            }
        });
        //设置目标百分比为30
        mPercentageRing1.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    alert = null;
                                                    builder = new AlertDialog.Builder(getActivity());
                                                    alert = builder
                                                            .setTitle("完善您的信息！")
                                                            .setMessage("是否立刻前去完善您的信息")
                                                            .setNegativeButton("取消", null)
                                                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    pre=3;
                                                                    Intent intent=new Intent(getActivity(),Main2Activity.class);
                                                                    startActivity(intent);
                                                                    getActivity().finish();
                                                                }
                                                            }).create();             //创建AlertDialog对象
                                                    alert.show();
                                                }
                                            });
        sqdk.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        boolean fo=true;
                                        if ((a1==0)|(a2==0)|(a3==0)|(a4==0)|(fmhk.getText().toString().equals(""))) fo=false;
                                        if (fo) {
                                            if (!(fmhk.getText().toString().substring(0, 1).equals("0"))){
                                            if (boo) {
                                                if (!dkee.getText().toString().equals("")) {
                                                    if (!dkee.getText().toString().substring(0, 1).equals("0")) {
                                                        if (target >= 95) {
                                                            if (valueOf(dkee.getText().toString()) <= valueOf(qq.getpree())) {
                                                                CustomDialog.Builder builder = new CustomDialog.Builder(getActivity());
                                                                builder.setTitle("贷 款 详 情");
                                                                int pee = 0, pe = 0;double fmyh=0,brhk=0,zh=0,r=0;
                                                                A = valueOf(dkee.getText().toString());
                                                                B = valueOf(fmhk.getText().toString());
                                                                int t=0;
                                                                t=qq.getpledge().indexOf(",");
                                                                zh=valueOf(qq.getpledge().substring(0,t));
                                                                zh=zh*valueOf(qq.getpledge().substring(t+1));
                                                                double lll = (A / zh)*0.05;
                                                                String lx = "";
                                                                double xxx = 0;
                                                                xxx = (5 - x1 / 0.6) * 0.5 + 0.9 + lll;
                                                                xxx = (15 * xxx / 4 + 5 / 4) / 100 + 1;
                                                                xxx = xxx * 4.9;
                                                                String h = "";
                                                                h = h+"年利率：" + (int) xxx + "." + abs((int) ((xxx - (int) xxx) * 100)) + "%\n";
                                                                xxx=xxx/12;
                                                                h = h+"月利率：" + (int) xxx + "." + abs((int) ((xxx - (int) xxx) * 100)) + "%\n";
                                                                r=xxx/100;

                                                                if (a3==1)
                                                                {
                                                                    double tt=Math.pow(1+r,a2);
                                                                    fmyh=B*r*tt/(tt-1)+(A-B)*r;
                                                                    C=(int) fmyh + "."+abs((int) ((fmyh - (int) fmyh) * 100))+"元";
                                                                    h=h+"父母每月还款："+(int) fmyh + "." + abs((int) ((fmyh - (int) fmyh) * 100))+"元\n";
                                                                }
                                                                else
                                                                {
                                                                    fmyh=(B/a2)*(1+r)+A*r;
                                                                    double ii=(B*r)/a2;
                                                                    C=(int) fmyh + "."+abs((int) ((fmyh - (int) fmyh) * 100))+"-i*"+(int) ii + "." + abs((int) ((ii - (int) ii) * 100))+"元";
                                                                    h=h+"父母第i个月还款："+(int) fmyh + "." + abs((int) ((fmyh - (int) fmyh) * 100))+"-i*"+(int) ii + "." + abs((int) ((ii - (int) ii) * 100))+"元\n";
                                                                }
                                                                if (a4==1)
                                                                {
                                                                    double tt=Math.pow(1+r,a1-a2);
                                                                   brhk=(A-B)*r*tt/(tt-1);
                                                                    D=(int) brhk + "." + abs((int) ((brhk - (int) brhk) * 100))+"元";
                                                                    h=h+"本人每月还款："+(int) brhk + "." + abs((int) ((brhk - (int) brhk) * 100))+"元\n";
                                                                }
                                                                else
                                                                {
                                                                    brhk=((A-B)/(a1-a2))*(1+r)+(A-B)*r;
                                                                    double ii=((A-B)*r)/(a1-a2);
                                                                    D=(int) brhk + "." + abs((int) ((brhk - (int) brhk) * 100))+"-i*"+(int) ii + "." + abs((int) ((ii - (int) ii) * 100))+"元";
                                                                    h=h+"本人第i个月还款："+(int) brhk + "." + abs((int) ((brhk - (int) brhk) * 100))+"-i*"+(int) ii + "." + abs((int) ((ii - (int) ii) * 100))+"元\n";
                                                                }
                                                                opt=(int) xxx + "." + abs((int) ((xxx - (int) xxx) * 100));
                                                                builder.setlx(h);
                                                                pe = (int) (((float) (100 - valueOf(dkee.getText().toString()) * 100 / valueOf(qq.getpree())) * 0.4 + 55));
                                                                pee = (int) ((float) valueOf(dkee.getText().toString()) * 100 / valueOf(qq.getpree()));
                                                                builder.setc1(pe);
                                                                builder.setc2(pee);
                                                                builder.setPositiveButton("确认贷款", new DialogInterface.OnClickListener() {
                                                                    public void onClick(DialogInterface dialog, int which) {
                                                                        progressStart = 0;
                                                                        add = 0;
                                                                        //依次设置一些属性
                                                                        pd2 = new ProgressDialog(getActivity());
                                                                        pd2.setMax(MAXVALUE);
                                                                        pd2.setTitle("发送申请");
                                                                        pd2.setMessage("申请和资料发送中,请稍后...");
                                                                        pd2.setButton(DialogInterface.BUTTON_NEUTRAL, "取消", new DialogInterface.OnClickListener() {
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
                                                                        new Thread() {
                                                                            public void run() {
                                                                                while (progressStart < MAXVALUE) {
                                                                                    //这里的算法是决定进度条变化的,可以按需要写
                                                                                    progressStart = 2 * usetime();
                                                                                    //把信息码发送给handle让更新界面
                                                                                    hand.sendEmptyMessage(123);
                                                                                }

                                                                            }
                                                                        }.start();
                                                                        new Thread() {
                                                                            public void run() {
                                                                                try {
                                                                                    FormBody.Builder pa = new FormBody.Builder();
                                                                                    pa.add("token", token1);
                                                                                    pa.add("want",A+"");
                                                                                    pa.add("ppay",B+"");
                                                                                    pa.add("pmpay",C);
                                                                                    pa.add("selfmpay",D);
                                                                                    pa.add("interest",opt);
                                                                                    pa.add("poundage",ff+"");
                                                                                    tt = post(pa, "apply.php");
                                                                                    Gson gson = new Gson();
                                                                                    int er = gson.fromJson(tt,mainFragment.erro.class).errno;
                                                                                    if (er==0)
                                                                                    {
                                                                                        handed.sendEmptyMessage(5);
                                                                                    }
                                                                                    else if (er==1) handed.sendEmptyMessage(6);
                                                                                }
                                                                                catch (Exception e)
                                                                                {
                                                                                    handed.sendEmptyMessage(6);
                                                                                }
                                                                            }
                                                                        }.start();

                                                                        dialog.dismiss();
                                                                        //设置你的操作事项
                                                                    }

                                                                });

                                                                builder.setNegativeButton("暂时离开",
                                                                        new android.content.DialogInterface.OnClickListener() {
                                                                            public void onClick(DialogInterface dialog, int which) {
                                                                                dialog.dismiss();
                                                                            }
                                                                        });

                                                                builder.create().show();
                                                            } else
                                                                Toast.makeText(getActivity(), "申请失败，不能大于预计贷款金额", Toast.LENGTH_SHORT).show();
                                                        } else
                                                            Toast.makeText(getActivity(), "申请失败，请先完善资料", Toast.LENGTH_SHORT).show();
                                                    } else
                                                        Toast.makeText(getActivity(), "申请失败，错误的数字格式", Toast.LENGTH_SHORT).show();
                                                } else
                                                    Toast.makeText(getActivity(), "请输入您要贷款的金额再提交申请", Toast.LENGTH_SHORT).show();
                                            } else
                                                Toast.makeText(getActivity(), "请先估算预计贷款金额", Toast.LENGTH_SHORT).show();
                                        }else
                                            Toast.makeText(getActivity(), "申请失败，错误的数字格式", Toast.LENGTH_SHORT).show();
                                        }else
                                            Toast.makeText(getActivity(), "请先填写还款方案", Toast.LENGTH_SHORT).show();
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
                handed.sendEmptyMessage(bm);
                alertDialog2.dismiss();
            }
        });
        alertBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // TODO 业务逻辑代码
                linshi=0;
                // 关闭提示框
                alertDialog2.dismiss();
            }
        });
        alertDialog2 = alertBuilder.create();
        alertDialog2.show();
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