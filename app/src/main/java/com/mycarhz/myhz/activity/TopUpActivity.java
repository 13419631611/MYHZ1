package com.mycarhz.myhz.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mycarhz.myhz.R;
import com.mycarhz.myhz.constant.Constant;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class TopUpActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et;
    private String topUpAmount;
    private Button btn;
    @ViewInject(R.id.tv_top_up_un)
    private TextView tvUsername;
    @ViewInject(R.id.ll_back)
    private LinearLayout llBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        x.view().inject(this);


        init();
        SharedPreferences sp = getSharedPreferences("user", Context.MODE_PRIVATE);
        tvUsername.setText(sp.getString("username",""));


    }

    private void init() {
        et= (EditText) findViewById(R.id.et_top_up_amount);
        btn= (Button) findViewById(R.id.btn_top_up);
        btn.setOnClickListener(this);
        llBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_top_up:
                Intent intent=new Intent(TopUpActivity.this,WebViewActivity.class);
                intent.putExtra("url", Constant.JZH_TOPUP);
                topUpAmount=et.getText().toString().trim();
                intent.putExtra("money",topUpAmount);
                //Log.i("!!!!!1",""+topUpAmount+"!!"+et.toString());
                startActivity(intent);
                break;
            case R.id.ll_back:
                finish();
                break;
        }

    }
}
