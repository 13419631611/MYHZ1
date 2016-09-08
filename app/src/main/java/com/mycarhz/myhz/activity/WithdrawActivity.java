package com.mycarhz.myhz.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mycarhz.myhz.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class WithdrawActivity extends AppCompatActivity implements View.OnClickListener{
    @ViewInject(R.id.ll_back)
    private LinearLayout  llBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);
        x.view().inject(this);
        init();
        listener();

    }

    private void listener() {
        llBack.setOnClickListener(this);
    }

    private void init() {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_back:
                finish();
                break;
        }

    }
}
