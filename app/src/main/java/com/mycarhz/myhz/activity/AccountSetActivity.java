package com.mycarhz.myhz.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mycarhz.myhz.R;
import com.mycarhz.myhz.application.MYHZApplication;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;


public class AccountSetActivity extends Activity{
    private Button btnExit;
    @ViewInject(R.id.tv_account_username)
    private TextView tvUsername;
    @ViewInject(R.id.ll_back)
    private LinearLayout llBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_set);
        x.view().inject(this);
        btnExit= (Button) findViewById(R.id.btn_exit);

        llBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("".equals(MYHZApplication.getUid())){
                    Toast.makeText(AccountSetActivity.this,"您还没有登录哦！",Toast.LENGTH_SHORT).show();
                }else {
                    SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                    sharedPreferences.edit().clear().commit();
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString("uid","");
//                    editor.commit();
                    //清空Application中的变量
                    MYHZApplication.setUid("");
                    MYHZApplication.setUsername("");
                    Toast.makeText(AccountSetActivity.this,"已退出登录！",Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sp = getSharedPreferences("user",Context.MODE_PRIVATE);
        tvUsername.setText(sp.getString("username",""));
    }


}
