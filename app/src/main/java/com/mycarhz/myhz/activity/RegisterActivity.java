package com.mycarhz.myhz.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mycarhz.myhz.R;
import com.mycarhz.myhz.bean.RegisterData;
import com.mycarhz.myhz.utils.StringUtils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Administrator on 2016/8/26.
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    //控件声明
    private Button btnVerificationCode;
    private Button btnRegister;
    private EditText etUserNameRegister;
    private EditText etVerificationCode;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private EditText etRecommendCode;



    //定义变量
    /**
     * 倒计时变量
     */
    public Thread thread = null;
    public boolean isChange = false;
    private boolean tag = true;
    private int i = 60;


    /**
     * et输入的验证码
     */
    private String verificationCode;
    /**
     * et输入的手机号
     */
    private String userName;
    /**
     * et输入的密码
     */
    private String password;
    /**
     * et再次输入的密码
     */
    private String confirmPassword;
    /**
     * et输入的推荐码
     */
    private String recommendCode;
    /**
     * 接口返回解析的
     */
    private String randomCode;


    @ViewInject(R.id.ll_back)
    private LinearLayout llBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        x.view().inject(this);


        init();
    }

    /**
     * 控件初始化
     */
    private void init() {
        //发送验证码按钮
        btnVerificationCode = (Button) findViewById(R.id.btn_verification_code);
        btnRegister = (Button) findViewById(R.id.btn_register);
        etUserNameRegister = (EditText) findViewById(R.id.et_userName_register);
        etPassword = (EditText) findViewById(R.id.et_password);
        etConfirmPassword = (EditText) findViewById(R.id.et_confirm_password);
        etRecommendCode = (EditText) findViewById(R.id.et_recommend_code);
        etVerificationCode = (EditText) findViewById(R.id.et_verificationCode);


        btnVerificationCode.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        llBack.setOnClickListener(this);


    }

    public void getString() {
        verificationCode = etVerificationCode.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        confirmPassword = etConfirmPassword.getText().toString().trim();
        recommendCode = etRecommendCode.getText().toString().trim();
        userName = etUserNameRegister.getText().toString().trim();
    }


    /**
     * 检查输入的号码是否符合规范
     *
     * @return false-不规范 true-规范
     */
    public boolean isPhonenumber() {
        userName = etUserNameRegister.getText().toString().trim();
        if (!StringUtils.isPhoneNumberValid(userName)) {
            Toast.makeText(RegisterActivity.this, "输入的手机号格式有误",
                    Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_verification_code:
                if (!isPhonenumber()) {
                    break;
                }
                btnVerificationCode.setText("发送验证码");
                btnVerificationCode.setClickable(true);
                isChange = true;
                changeBtnGetCode();

                getValidateCode();

                break;
            case R.id.btn_register:
                getString();
                if (!isFill()) {
                    break;
                }
                sendRegister();
                break;

            case R.id.ll_back:
                finish();
                break;


        }
    }


    private void changeBtnGetCode() {
        thread = new Thread() {
            @Override
            public void run() {
                if (tag) {
                    while (i > 0) {
                        i--;
                        if (RegisterActivity.this == null) {
                            break;
                        }
                        RegisterActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                btnVerificationCode.setText("已发送（" + i + ")");
                                btnVerificationCode.setClickable(false);
                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    tag = false;
                }
                i = 60;
                tag = true;
                if (RegisterActivity.this != null) {
                    RegisterActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            btnVerificationCode.setText("获取验证码");
                            btnVerificationCode.setClickable(true);
                        }
                    });
                }
            }
        };
        thread.start();
    }

    private void sendRegister() {
        String registerUrl1 = "http://192.168.199.154:8080/app/register.do?info=" +
                "{name:'" + userName + "',pwd:'" + password + "',cellPhone:'" + userName + "'," +
                "code:'" + verificationCode + "',refferee:'" + recommendCode + "'," +
                " randomCode:'" + randomCode + "'}";
        String registerUrl = "http://192.168.199.154:8080/app/register.do";

        if (!"".equals("randomCode")) {
            RequestParams registerParams = new RequestParams(registerUrl);
            registerParams.addBodyParameter("info", "{name:'" + userName + "', pwd:'" + password + "', cellPhone:'" + userName + "', " +
                    "code:'" + verificationCode + "', refferee:'" + recommendCode + "', randomCode:'" + randomCode + "'}");
            x.http().post(registerParams, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String s) {
                    Toast.makeText(x.app(), s, Toast.LENGTH_LONG).show();
                }

                @Override
                public void onError(Throwable throwable, boolean b) {
                    // Log.i("qwe",""+registerParams.getHeaders().toString());
                    Toast.makeText(x.app(), throwable.getMessage(), Toast.LENGTH_LONG).show();

                }

                @Override
                public void onCancelled(CancelledException e) {
                    Toast.makeText(x.app(), "cancelled", Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFinished() {

                }
            });

        }
    }

    /**
     * 获取验证码
     */
    public void getValidateCode() {
        String validateCodeUrl = "http://192.168.199.154:8080/app/sendSMS.do?info={cellPhone:'" + userName + "'}";
        RequestParams params = new RequestParams(validateCodeUrl);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                //Log.i("123",""+params.getHeaders().toString());
                Toast.makeText(x.app(), s, Toast.LENGTH_LONG).show();
                Gson gson = new Gson();
                RegisterData registerData = gson.fromJson(s, RegisterData.class);
                randomCode = registerData.getRandomCode();
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Toast.makeText(x.app(), throwable.getMessage(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onCancelled(CancelledException e) {
                Toast.makeText(x.app(), "cancelled", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFinished() {

            }
        });

    }

    public boolean isFill() {
        if (!userName.isEmpty()) {
            if (!verificationCode.isEmpty()) {
                if (!password.isEmpty()) {
                    //  Log.i("qwe","qwe"+password.length());
                    if (!confirmPassword.isEmpty()) {
                        if (password.length() >= 6) {
                            if (password.equals(confirmPassword)) {
                                return true;
                            }
                            Toast.makeText(RegisterActivity.this, "两次输入的密码不一致", Toast.LENGTH_LONG).show();
                            return false;
                        }
                        Toast.makeText(RegisterActivity.this, "密码长度需大于6位", Toast.LENGTH_LONG).show();
                        return false;
                    }
                    Toast.makeText(RegisterActivity.this, "确认密码未填写", Toast.LENGTH_LONG).show();
                    return false;
                }
                Toast.makeText(RegisterActivity.this, "密码码未填写", Toast.LENGTH_LONG).show();
                return false;
            }
            Toast.makeText(RegisterActivity.this, "验证码未填写", Toast.LENGTH_LONG).show();
            return false;
        }
        Toast.makeText(RegisterActivity.this, "用户名未填写", Toast.LENGTH_LONG).show();
        return false;
    }


}
