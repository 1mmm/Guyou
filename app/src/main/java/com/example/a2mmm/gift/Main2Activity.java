package com.example.a2mmm.gift;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.a2mmm.gift.MainActivity.a2;
import static com.example.a2mmm.gift.MainActivity.a3;
import static com.example.a2mmm.gift.MainActivity.a4;
import static com.example.a2mmm.gift.MainActivity.pre;
import static com.example.a2mmm.gift.MainActivity.sh;


public class Main2Activity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener,View.OnClickListener,GestureDetector.OnGestureListener {

    //UI Object
    public  static boolean f=false;
    private TextView txt_main;
    private TextView txt_suggest;
    private TextView txt_news;
    private TextView txt_chat;
    private static final int ID = 1;
    private TextView txt_me,ztzk;
    private FrameLayout ly_content;
    private LinearLayout ly_tab_bar;
    public  GestureDetector detector;

    public int MARK=0;

    final int DISTANT=75;
    //Fragment Object
    private mainFragment fg1;
    private suggestFragment fg2;
    private newsFragment fg3;
    private chatFragment fg4;
    private Button btnre,tc;
    private TextView txt_upbar;
    private Switch swh_status,zw,zwjs,yj;
    public static DrawerLayout dl;
    LinearLayout zzk;
    static  LinearLayout rlRight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);
        SysApplication.getInstance().addActivity(this);
        bindViews();
        //设置显示图标，该图标会在状态栏显示

        detector=new GestureDetector(this,this);
        if (a2==1) txt_suggest.setVisibility(View.VISIBLE);
        if (a3==1) txt_news.setVisibility(View.VISIBLE);
        if (a4==1)txt_chat.setVisibility(View.VISIBLE);
        switch (pre){
            case 1:txt_main.performClick();pre=1;break;
            case 2:txt_suggest.performClick();pre=2;break;
            case 3:txt_news.performClick();pre=3;break;
            case 4:txt_chat.performClick();pre=4;break;
        }


    }

    //UI组件初始化与事件绑定
    private void bindViews() {
        txt_main = (TextView) findViewById(R.id.txt_main);
        txt_suggest = (TextView) findViewById(R.id.txt_suggest);
        ztzk = (TextView) findViewById(R.id.ztzk);
        tc=(Button) findViewById(R.id.tc);
        ztzk.setSelected(false);
        swh_status = (Switch) findViewById(R.id.swh_status);
        zw= (Switch) findViewById(R.id.zw);
        zwjs = (Switch) findViewById(R.id.zwjs);
        yj = (Switch) findViewById(R.id.yj);
        txt_news = (TextView) findViewById(R.id.txt_news);
        txt_chat = (TextView) findViewById(R.id.txt_chat);
        ly_tab_bar=(LinearLayout) findViewById(R.id.ly_tab_bar);
        zzk=(LinearLayout) findViewById(R.id.zzk);
        ly_content = (FrameLayout) findViewById(R.id.ly_content);
        dl = (DrawerLayout) findViewById(R.id.dl);
        rlRight=(LinearLayout) findViewById(R.id.right);
        swh_status.setOnCheckedChangeListener(this);
        zw.setOnCheckedChangeListener(this);
        zwjs.setOnCheckedChangeListener(this);
        yj.setOnCheckedChangeListener(this);
        ztzk.setOnClickListener(this);
        Drawable drawable1 = ContextCompat.getDrawable(this, R.mipmap.strech_ss);
        drawable1.setBounds(-10, 0, 20, 35);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        ztzk.setCompoundDrawables(null, null, drawable1, null);
        txt_main.setOnClickListener(this);
        tc.setOnClickListener(this);
        txt_suggest.setOnClickListener(this);
        txt_news.setOnClickListener(this);
        txt_chat.setOnClickListener(this);
        dl.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        dl.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // 打开手势滑动
                dl.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                // 关闭手势滑动
                dl.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }


    //重置所有文本的选中状态
    private void setSelected(){
        txt_main.setSelected(false);
        txt_suggest.setSelected(false);
        txt_news.setSelected(false);
        txt_chat.setSelected(false);
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)
        {
            fragmentTransaction.hide(fg1);
            fragmentTransaction.remove(fg1);
        }
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
        if(fg4 != null)fragmentTransaction.hide(fg4);
        fg1=null;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.ztzk)
        {
            if (ztzk.isSelected()) {
                ztzk.setSelected(false);
                Drawable drawable1 = ContextCompat.getDrawable(this, R.mipmap.strech_ss);
                drawable1.setBounds(-10, 0, 20, 35);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
                ztzk.setCompoundDrawables(null, null, drawable1, null);
                zzk.setVisibility(View.GONE);
            }
            else {
                ztzk.setSelected(true);
                Drawable drawable1 = ContextCompat.getDrawable(this, R.mipmap.strech_zk);
                drawable1.setBounds(-10, 0, 30, 20);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
                ztzk.setCompoundDrawables(null, null, drawable1, null);
                zzk.setVisibility(View.VISIBLE);
            }
        }
        else if (v.getId()==R.id.tc)
        {
            new  AlertDialog.Builder(this)
                    .setTitle("退出登陆" )
                    .setMessage("确定吗？" )
                    .setNegativeButton("是" ,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO Auto-generated method stub
                                    finish();
                                    System.exit(0);
                                }
                            })
                    .setPositiveButton("否" , null)
                    .show();
        }
        else {
            FragmentTransaction fTransaction = getSupportFragmentManager().beginTransaction();
            hideAllFragment(fTransaction);
            switch (v.getId()) {
                case R.id.txt_main:
                    ly_tab_bar.setBackgroundResource(R.mipmap.t2);
                    setSelected();

                    txt_main.setSelected(true);
                    if (fg1 == null) {
                        fg1 = new mainFragment();
                        if (pre != 1)
                            fTransaction.setCustomAnimations(R.anim.left_in, R.anim.left_out);
                        fTransaction.add(R.id.ly_content, fg1);
                    } else {
                        if (pre != 1)
                            fTransaction.setCustomAnimations(R.anim.left_in, R.anim.left_out);
                        fTransaction.show(fg1);
                    }
                    pre = 1;
                    MARK = 0;
                    break;
                case R.id.txt_suggest:
                    ly_tab_bar.setBackgroundResource(R.mipmap.tab_bar);
                    setSelected();
                    txt_suggest.setSelected(true);
                    if (fg2 == null) {
                        fg2 = new suggestFragment();
                        if (pre == 1){
                            fg1=null;
                            fTransaction.setCustomAnimations(R.anim.right_in, R.anim.right_out);}
                        else if (pre > 2)
                            fTransaction.setCustomAnimations(R.anim.left_in, R.anim.left_out);
                        fTransaction.add(R.id.ly_content, fg2);
                    } else {
                        if (pre == 1){
                            sh.save("main","1");
                            fTransaction.setCustomAnimations(R.anim.right_in, R.anim.right_out);}
                        else if (pre > 2)
                            fTransaction.setCustomAnimations(R.anim.left_in, R.anim.left_out);
                        fTransaction.show(fg2);
                    }
                    pre = 2;
                    MARK = 1;
                    break;
                case R.id.txt_news:
                    ly_tab_bar.setBackgroundResource(R.mipmap.t1);
                    setSelected();
                    txt_news.setSelected(true);
                    if (fg3 == null) {
                        fg3 = new newsFragment();
                        if (pre == 1){
                            sh.save("main","0");
                            fTransaction.setCustomAnimations(R.anim.right_in, R.anim.right_out);}
                        else if (pre < 3)
                            fTransaction.setCustomAnimations(R.anim.right_in, R.anim.right_out);
                        else if (pre > 3)
                            fTransaction.setCustomAnimations(R.anim.left_in, R.anim.left_out);
                        fTransaction.add(R.id.ly_content, fg3);
                    } else {
                        if (pre == 1){
                            sh.save("main","1");
                            fTransaction.setCustomAnimations(R.anim.right_in, R.anim.right_out);}
                        else if (pre < 3)
                            fTransaction.setCustomAnimations(R.anim.right_in, R.anim.right_out);
                        else if (pre > 3)
                            fTransaction.setCustomAnimations(R.anim.left_in, R.anim.left_out);
                        fTransaction.show(fg3);
                    }
                    pre = 3;
                    MARK = 2;
                    break;
                case R.id.txt_chat:
                    ly_tab_bar.setBackgroundResource(R.mipmap.t4);
                    setSelected();

                    txt_chat.setSelected(true);
                    if (fg4 == null) {
                        fg4 = new chatFragment();
                        if (pre == 1){
                            sh.save("main","1");
                            fTransaction.setCustomAnimations(R.anim.right_in, R.anim.right_out);}
                        else if (pre != 4)
                            fTransaction.setCustomAnimations(R.anim.right_in, R.anim.right_out);
                        fTransaction.add(R.id.ly_content, fg4);
                    } else {
                        if (pre == 1){
                            sh.save("main","1");
                            fTransaction.setCustomAnimations(R.anim.right_in, R.anim.right_out);}
                        else if (pre != 4)
                            fTransaction.setCustomAnimations(R.anim.right_in, R.anim.right_out);
                        fTransaction.show(fg4);
                    }
                    pre = 4;
                    MARK = 3;
                    break;
            }
            fTransaction.commit();
        }
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

    /**滑动切换效果的实现*/
    @Override
    public	boolean	onFling(MotionEvent	arg0,	MotionEvent	arg1,	float	arg2,
                                 float	arg3) {

//	TODO	Auto-generated	method	stub
//当是Fragment0的时候
        if (!((arg0.getY() > arg1.getY()+75) | (arg1.getY() > arg0.getY() +75))) {
            if (!dl.isDrawerOpen(rlRight)) {
            FragmentTransaction fTransaction = getSupportFragmentManager().beginTransaction();
            hideAllFragment(fTransaction);
            if (MARK == 0) {
                if (arg0.getX() > arg1.getX() + DISTANT) {
                    ly_tab_bar.setBackgroundResource(R.mipmap.tab_bar);
                    setSelected();
                    pre = 2;
                    sh.save("main","1");
                    txt_suggest.setSelected(true);
                    if (fg2 == null) {
                        fg2 = new suggestFragment();
                        fTransaction.setCustomAnimations(R.anim.right_in, R.anim.right_out);
                        fTransaction.add(R.id.ly_content, fg2);
                    } else {
                        fTransaction.setCustomAnimations(R.anim.right_in, R.anim.right_out);
                        fTransaction.show(fg2);
                    }
                    MARK = 1;
                } else  {
                    ly_tab_bar.setBackgroundResource(R.mipmap.t2);
                    setSelected();
                    pre = 1;
                    txt_main.setSelected(true);
                    if (fg1 == null) {
                        fg1 = new mainFragment();
                        fTransaction.add(R.id.ly_content, fg1);
                    } else {
                        fTransaction.show(fg1);
                    }
                    MARK = 0;
                }

            }
//当是Fragment1的时候
            else if (MARK == 1) {
                if (arg0.getX() > arg1.getX() + DISTANT) {
                    ly_tab_bar.setBackgroundResource(R.mipmap.t1);
                    setSelected();
                    pre = 3;
                    txt_news.setSelected(true);
                    if (fg3 == null) {
                        fg3 = new newsFragment();
                        fTransaction.setCustomAnimations(R.anim.right_in, R.anim.right_out);
                        fTransaction.add(R.id.ly_content, fg3);
                    } else {
                        fTransaction.setCustomAnimations(R.anim.right_in, R.anim.right_out);
                        fTransaction.show(fg3);
                    }
                    MARK = 2;
                } else if (arg1.getX() > arg0.getX() + DISTANT) {
                    ly_tab_bar.setBackgroundResource(R.mipmap.t2);
                    setSelected();
                    pre = 1;
                    txt_main.setSelected(true);
                    if (fg1 == null) {
                        fg1 = new mainFragment();
                        fTransaction.setCustomAnimations(R.anim.left_in, R.anim.left_out);
                        fTransaction.add(R.id.ly_content, fg1);
                    } else {
                        fTransaction.setCustomAnimations(R.anim.left_in, R.anim.left_out);
                        fTransaction.show(fg1);
                    }
                    MARK = 0;
                }
                else{
                    ly_tab_bar.setBackgroundResource(R.mipmap.tab_bar);
                    setSelected();
                    pre = 2;
                    txt_suggest.setSelected(true);
                    if (fg2 == null) {
                        fg2 = new suggestFragment();
                        fTransaction.add(R.id.ly_content, fg2);
                    } else {
                        fTransaction.show(fg2);
                    }
                    MARK = 1;
                }
            } else if (MARK == 2) {
                if (arg0.getX() > arg1.getX() + DISTANT) {
                    ly_tab_bar.setBackgroundResource(R.mipmap.t4);
                    setSelected();
                    pre = 4;
                    txt_chat.setSelected(true);
                    if (fg4 == null) {
                        fg4 = new chatFragment();
                        fTransaction.setCustomAnimations(R.anim.right_in, R.anim.right_out);
                        fTransaction.add(R.id.ly_content, fg4);
                    } else {
                        fTransaction.setCustomAnimations(R.anim.right_in, R.anim.right_out);
                        fTransaction.show(fg4);
                    }
                    MARK = 3;
                } else if (arg1.getX() > arg0.getX() + DISTANT) {

                    ly_tab_bar.setBackgroundResource(R.mipmap.tab_bar);
                    setSelected();
                    pre = 2;
                    txt_suggest.setSelected(true);
                    if (fg2 == null) {
                        fg2 = new suggestFragment();
                        fTransaction.setCustomAnimations(R.anim.left_in, R.anim.left_out);
                        fTransaction.add(R.id.ly_content, fg2);
                    } else {
                        fTransaction.setCustomAnimations(R.anim.left_in, R.anim.left_out);
                        fTransaction.show(fg2);
                    }
                    MARK = 1;
                }
                else{
                    ly_tab_bar.setBackgroundResource(R.mipmap.t1);
                    setSelected();
                    pre = 3;
                    txt_news.setSelected(true);
                    if (fg3 == null) {
                        fg3 = new newsFragment();
                        fTransaction.add(R.id.ly_content, fg3);
                    } else {
                        fTransaction.show(fg3);
                    }
                    MARK = 2;
                }
            }
//当是Fragment2的时候
            else if (MARK == 3) {
                if (arg1.getX() > arg0.getX() + DISTANT) {

                        ly_tab_bar.setBackgroundResource(R.mipmap.t1);
                        setSelected();
                        pre = 3;
                        txt_news.setSelected(true);
                        if (fg3 == null) {
                            fg3 = new newsFragment();
                            fTransaction.setCustomAnimations(R.anim.left_in, R.anim.left_out);
                            fTransaction.add(R.id.ly_content, fg3);
                        } else {
                            fTransaction.setCustomAnimations(R.anim.left_in, R.anim.left_out);
                            fTransaction.show(fg3);
                        }

                        MARK = 2;

                } else if (arg0.getX() > arg1.getX() + DISTANT) {
                    ly_tab_bar.setBackgroundResource(R.mipmap.t4);
                    setSelected();
                    pre = 4;
                    txt_chat.setSelected(true);
                    if (fg4 == null) {
                        fg4 = new chatFragment();
                        fTransaction.add(R.id.ly_content, fg4);
                    } else {
                        fTransaction.show(fg4);
                    }
                    if (!dl.isDrawerOpen(rlRight)) {
                        dl.openDrawer(rlRight);
                    }
                    MARK = 3;
                }
                else
                {
                    ly_tab_bar.setBackgroundResource(R.mipmap.t4);
                    setSelected();
                    pre = 4;
                    txt_chat.setSelected(true);
                    if (fg4 == null) {
                        fg4 = new chatFragment();
                        fTransaction.add(R.id.ly_content, fg4);
                    } else {
                        fTransaction.show(fg4);
                    }
                    MARK = 3;
                }

            }
            fTransaction.commit();
        }
        else
            {
                dl.closeDrawer(rlRight);
            }
        }
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
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        detector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            new  AlertDialog.Builder(this)
                    .setTitle("退出登录" )
                    .setMessage("确定吗？" )
                    .setNegativeButton("是" ,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO Auto-generated method stub
                                    finish();
                                    System.exit(0);
                                }
                            })
                    .setPositiveButton("否" , null)
                    .show();
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.swh_status:
                if(compoundButton.isChecked()) {
                    Toast.makeText(this,"通知已开启",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this,"通知已关闭",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.zw:
                if(compoundButton.isChecked()) Toast.makeText(this,"指纹登陆:ON",Toast.LENGTH_SHORT).show();
                else Toast.makeText(this,"指纹登陆:OFF",Toast.LENGTH_SHORT).show();
                break;
            case R.id.zwjs:
                if(compoundButton.isChecked()) Toast.makeText(this,"指纹解锁:ON",Toast.LENGTH_SHORT).show();
                else Toast.makeText(this,"指纹解锁:OFF",Toast.LENGTH_SHORT).show();
                break;
            case R.id.yj:
                if(compoundButton.isChecked()) Toast.makeText(this,"切换到夜间模式",Toast.LENGTH_SHORT).show();
                else Toast.makeText(this,"切换到白天模式",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
