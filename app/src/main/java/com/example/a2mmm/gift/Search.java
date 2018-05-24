package com.example.a2mmm.gift;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.a2mmm.gift.MainActivity.pre;
import static com.example.a2mmm.gift.MainActivity.a2;
import static com.example.a2mmm.gift.MainActivity.a5;

public class Search extends AppCompatActivity {
    public TextView btn,ans1,ans2;
    public EditText ans;
    public LinearLayout hide1;
    public LinearLayout hide2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        SysApplication.getInstance().addActivity(this);
        btn=(TextView) findViewById(R.id.yes);
        ans1=(TextView) findViewById(R.id.ans1);
        ans2=(TextView) findViewById(R.id.ans2);
        ans=(EditText) findViewById(R.id.txt_upbar);
        hide1=(LinearLayout) findViewById(R.id.dsg);
        hide2=(LinearLayout) findViewById(R.id.sz);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ans.getText().toString().equals("第三关") ) {
                        hide1.setVisibility(View.VISIBLE);
                        hide2.setVisibility(View.GONE);

                }
                else if (ans.getText().toString().equals("设置") ) {
                    hide2.setVisibility(View.VISIBLE);
                    hide1.setVisibility(View.GONE);
                }
                else
                {
                    hide2.setVisibility(View.GONE);
                    hide1.setVisibility(View.GONE);
                }
            }});
        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Search.this,Main2Activity.class);
                pre=2;
                a2=1;
                startActivity(intent);
                Search.this.finish();
            }
        });
        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Search.this,Main2Activity.class);
                pre=5;
                a5=1;
                startActivity(intent);
                Search.this.finish();
            }
        });

    }
}
