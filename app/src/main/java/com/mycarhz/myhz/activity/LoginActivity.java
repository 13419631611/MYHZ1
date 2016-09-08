package com.mycarhz.myhz.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mycarhz.myhz.R;
import com.mycarhz.myhz.application.MYHZApplication;
import com.mycarhz.myhz.bean.LoginData;
import com.mycarhz.myhz.constant.Constant;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Administrator on 2016/8/26.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    //声明控件
    private Button btnRegister;
    private Button btnLogin;
    private EditText etUsername;
    private EditText etPassword;

    //变量
    private String username;
    private String password;

    private LinearLayout llBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();




    }

    private void init() {
        btnRegister= (Button) findViewById(R.id.btn_register);
        btnLogin= (Button) findViewById(R.id.btn_login);
        etUsername= (EditText) findViewById(R.id.et_userName_login);
        etPassword= (EditText) findViewById(R.id.et_passWorld_login);
        llBack= (LinearLayout) findViewById(R.id.ll_back);


        btnRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        llBack.setOnClickListener(this);

    }

//    /*处理返回键消息*/
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//// 指定显示某一个Activity
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);
//            finish();
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_register:
                Intent intent =new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_login:
                getString();
                sendLogin();
                break;
            case R.id.ll_back:
                finish();
                break;


        }

    }



    private void sendLogin() {
        String loginUrl= Constant.LOGIN;
        RequestParams loginParams = new RequestParams(loginUrl);
        loginParams.addBodyParameter("info", "{name:'" + username + "', pwd:'" + password+"'}");
        x.http().post(loginParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                //解析响应并提示
                Gson gson= new Gson();
                LoginData loginData=gson.fromJson(s,LoginData.class);
                String msg=loginData.getMsg();
                Toast.makeText(LoginActivity.this,msg,Toast.LENGTH_LONG).show();

                if(!"".equals(loginData.getId())) {
                    SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("uid", loginData.getId().toString());
                    editor.putString("username", loginData.getUsername().trim());
                    editor.commit();

                    //application中设置全局变量
                    MYHZApplication.setUid(loginData.getId());
                    MYHZApplication.setUsername(loginData.getUsername());
                }


                //当响应-1时关闭该页面
                if ("-1".equals(loginData.getError())){
                    finish();
                }
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Toast.makeText(x.app(), throwable.getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    /**
     * 获得输入框输入的内容
     */
    public void getString() {
        password=etPassword.getText().toString().trim();
        username=etUsername.getText().toString().trim();
    }

}

