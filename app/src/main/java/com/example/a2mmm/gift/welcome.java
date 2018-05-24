package com.example.a2mmm.gift;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.a2mmm.gift.MainActivity.target;
import static com.example.a2mmm.gift.MainActivity.token1;
import static java.lang.Integer.valueOf;

public class welcome extends Activity {
    public String base_url="http://101.132.106.1/";
    private final OkHttpClient client = new OkHttpClient();
    String tt="",ttt="",aa="";
    StringBuffer sb = new StringBuffer();
    static public data1 qq;
    final Handler hand = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            //这里的话如果接受到信息码是123
            switch (msg.what) {
                case 0:
                    Toast.makeText(welcome.this, "读取用户资料成功", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(welcome.this, "读取用户资料失败，返回登陆界面", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(welcome.this, MainActivity.class);
                    startActivity(intent);
                    welcome.this.finish();
                    break;
                case 33:
                    Log.d( "handleMessage: ",tt);
                    Log.d( "handleMessage: ",ttt);
                    break;

            }
        }
    };
    public class data1 {
        private String id;
        private String name;
        private int school;
        private String stuid;
        private int sex;
        private int major;
        private String grade;
        private String gpa;
        private String reason;
        private int english;
        private int worktime;
        private int experiment;
        private  String addr;
        private String phone;
        private  String mail;
        private  int rank;
        private  String income;
        private  String pledge;
        private  int bank;
        private  String saving;
        private  String wish;
        private String bankno;
        private  String idno;
        private  String pname;
        private String fidno;
        private String midno;
        private String pre;
        private String photo;
        public void setpre(String ss)
        {
            pre=ss;
        }
        public String getpree(){
            return pre;
        }
        public String getname(){
            return name;
        }
        public int getschool(){
            return school;
        }
        public String getstuid(){
            return stuid;
        }
        public int getsex(){
            return sex;
        }
        public int getmajortype(){
            return major;
        }
        public String getgrade(){
            return grade;
        }
        public String getgpa(){
            return gpa;
        }
        public String getreason(){
            return reason;
        }
        public int getenglish(){
            return english;
        }
        public int getworktime(){
            return worktime;
        }
        public int getexperiment(){
            return experiment;
        }
        public String getid(){
            return id;
        }
        public String getaddr(){
            return addr;
        }
        public String getphone() {
            return phone;
        }
        public String getmail(){
            return mail;
        }
        public int getrank(){
            return rank;
        }
        public String getincome(){
            return income;
        }
        public String getpledge(){
            return pledge;
        }
        public int getbank(){
            return bank;
        }
        public String getsaving(){
            return saving;
        }
        public String getbankno(){
            return bankno;
        }
        public String getidno(){
            return idno;
        }
        public String getpname(){
            return pname;
        }
        public String getfidno(){
            return fidno;
        }
        public String getmidno(){
            return midno;
        }
        public String getPhoto(){return  photo;}
        public int getpre(){
            int ttt=2;
            if (!(name.equals("null")|name.equals(""))) ttt++;

            if (!(stuid.equals("null")|stuid.equals(""))) ttt++;

            if (!(grade.equals("null")|grade.equals(""))) ttt++;
            if (!(gpa.equals("null")|gpa.equals(""))) ttt++;



            if (!(addr.equals("null")|addr.equals("")))ttt++;
            if (!(phone.equals("null")|phone.equals(""))) ttt++;
            if (!(mail.equals("null")|mail.equals(""))) ttt++;

            if (!(income.equals("null")|income.equals(""))) ttt++;
            if (!(pledge.equals("null")|pledge.equals(""))) ttt=ttt+3;

            if (!(saving.equals("null")|saving.equals(""))) ttt++;
            if (!(bankno.equals("null")|bankno.equals(""))) ttt++;
            if (!(idno.equals("null")|idno.equals(""))) ttt++;
            if (!(pname.equals("null")|pname.equals(""))) ttt++;
            if (!(fidno.equals("null")|fidno.equals(""))) ttt++;
            if (!(midno.equals("null")|midno.equals(""))) ttt++;
            if (!(rank+"").equals("0")) ttt++;
            if (!(school+"").equals("0")) ttt++;
            if (!(major+"").equals("0")) ttt++;
            if (!(bank+"").equals("0"))ttt++;
            if (!(english+"").equals("0")) ttt++;
            if (!(worktime+"").equals("0")) ttt++;
            if (!(reason.equals("null") |!reason.equals("")))
                if (!(reason.substring(0,1).equals("1")|reason.substring(0,1).equals("2")|reason.substring(0,1).equals("3"))) ttt++;

            return  ttt*100/25-1;
        }
        public void setname(String name){
            this.name=name;
        }
        public void setschool(int school){
            this.school=school;
        }
        public void setstuid(String stuid){
            this.stuid=stuid;
        }
        public void setsex(int sex){
            this.sex=sex;
        }
        public void setmajortype(int major){
            this.major=major;
        }
        public void setgrade(String grade){
            this.grade=grade;
        }
        public void setgpa(String gpa){
            this.gpa=gpa;
        }
        public void setreason(String reason){
            this.reason=reason;
        }
        public void setenglish(int english){
            this.english=english;
        }
        public void setworktime(int worktime){
            this.worktime=worktime;
        }
        public void setexperiment(int experiment){
            this.experiment=experiment;
        }
        public void setid(String id){
            this.id=id;
        }
        public void setaddr(String addr){
            this.addr= addr;
        }
        public void setphone(String phone) {
            this.phone= phone;
        }
        public void setmail(String mail){
            this.mail= mail;
        }
        public void setrank(int rank){
            this.rank=rank;
        }
        public void setincome(String income){
            this.income= income;
        }
        public void setpledge(String pledge){
            this.pledge=pledge;
        }
        public void setbank(int bank){
            this.bank= bank;
        }
        public void setsaving(String saving){
            this.saving=saving;
        }
        public void setbankno( String bankno){
            this.bankno=bankno;
        }
        public void setidno(String idno){
            this.idno=idno;
        }
        public void setpname(String pname){
            this.pname=pname;
        }
        public void setfidno(String fidno){
            this.fidno=fidno;
        }
        public void setmidno(String midno){
            this.midno= midno;
        }
        public void setphoto(String photo){this.photo= photo;}

        data1(String id,String name,int school,String stuid,int sex,int major,String grade,String gpa,String reason,int english,int worktime
                ,int experiment,String addr,String phone,String mail,int rank,String income,String pledge,int bank,String saving,String bankno,String idno,String pname,String fidno,String midno,String pre,String photo){
            this.school = school;this.name = name;this.stuid=stuid;this.sex=sex;
            this.major=major;this.grade=grade;this.gpa=gpa;this.reason=reason;
            this.english=english;this.worktime=worktime;this.experiment=experiment;
            this.addr=addr;this.phone=phone;this.mail=mail;this.rank=rank;
            this.income=income;this.pledge=pledge;this.bank=bank;
            this.saving=saving;this.bankno=bankno;
            this.idno=idno;this.pname=pname;this.fidno=fidno;
            this.midno=midno;this.photo=photo;
            this.pre=pre;this.id=id;

        }
    }
    public  class data2{
        private int id;
        private int want;
        private int status;
        private int ppay;
        private String selfmpay;
        private String pmpay;
        data2(int id,int want,int status,int ppay,String selfmpay,String pmpay){
            this.id = id;
            this.want=want;
            this.status=status;
            this.ppay=ppay;
            this.selfmpay=selfmpay;
            this.pmpay=pmpay;
        }
        public int getppay(){
            return ppay;
        }
        public String getselfmpay(){
            return selfmpay;
        }
        public String getpmpay(){
            return pmpay;
        }
        public int getid(){
            return id;
        }
        public int getwant(){
            return want;
        }
        public int getstatus(){
            return status;
        }

    }
    public  class sub{
        private int errno;
        private data1 data;
        sub(int errno,data1 data){
            this.errno = errno;
            this.data=data;
        }
    }
    public  class sub1{
        private int errno;
        private data2 data[];
        sub1(int errno,data2 data[]){
            this.errno = errno;
            this.data=data;
        }
    }
    private final long SPLASH_LENGTH = 1000;
    Handler handler = new Handler();
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Thread()
        {
            @Override
            public void run() {
                try {
                    FormBody.Builder pa=new  FormBody.Builder();
                    pa.add("token",token1);
                    tt=post(pa,"info.php");
                    JSONObject result = new JSONObject(tt);
                    int er =valueOf(result.getString("errno"));
                    JSONObject jo1 = result.getJSONObject("data");
                    String s1="0",s2="0",s3="0",s4="0",s5="0",s6="0",s7="0",s8="0";
                    if (!jo1.getString("school").equals("null")) s1=jo1.getString("school");
                    if (!jo1.getString("sex").equals("null")) s2=jo1.getString("sex");
                    if (!jo1.getString("major").equals("null")) s3=jo1.getString("major");
                    if (!jo1.getString("english").equals("null")) s4=jo1.getString("english");
                    if (!jo1.getString("worktime").equals("null")) s5=jo1.getString("worktime");
                    if (!jo1.getString("experiment").equals("null")) s6=jo1.getString("experiment");
                    if (!jo1.getString("rank").equals("null")) s7=jo1.getString("rank");
                    if (!jo1.getString("bank").equals("null")) s8=jo1.getString("bank");
                    ttt=s1+s2+s3+s4+s5+s6+s7;
                    hand.sendEmptyMessage(33);
                    qq = new data1(jo1.getString("id"),jo1.getString("name"),valueOf(s1),jo1.getString("stuid"),valueOf(s2),valueOf(s3)
                    ,jo1.getString("grade"),jo1.getString("gpa"),jo1.getString("reason"),valueOf(s4),valueOf(s5)
                    ,valueOf(s6),jo1.getString("addr"),jo1.getString("phone"),jo1.getString("mail"),valueOf(s7)
                    ,jo1.getString("income"),jo1.getString("pledge"),valueOf(s8),jo1.getString("saving"),jo1.getString("bankno"),
                            jo1.getString("idno"),jo1.getString("pname"),jo1.getString("fidno"),jo1.getString("midno"),jo1.getString("pre"),
                            jo1.getString("photo"));
                    hand.sendEmptyMessage(33);

                    target=qq.getpre();

                    if (er!=0)
                    {
                        hand.sendEmptyMessage(1);
                    }
                }
                catch (Exception e)
                {
                }
            }


        }.start();

        handler.postDelayed(new Runnable() {  //使用handler的postDelayed实现延时跳转

            public void run() {
                Intent intent = new Intent(welcome.this, Main2Activity.class);
                startActivity(intent);
                welcome.this.finish();
            }
        }, SPLASH_LENGTH);//2秒后跳转至应用主界面MainActivity
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
