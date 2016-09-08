package com.mycarhz.myhz.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mycarhz.myhz.R;
import com.mycarhz.myhz.activity.AccountSetActivity;
import com.mycarhz.myhz.activity.TopUpActivity;
import com.mycarhz.myhz.activity.WebViewActivity;
import com.mycarhz.myhz.activity.WithdrawActivity;
import com.mycarhz.myhz.application.MYHZApplication;
import com.mycarhz.myhz.bean.RefreshData;
import com.mycarhz.myhz.constant.Constant;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Administrator on 2016/8/26.
 */
public class Fragment_personal_center extends Fragment implements View.OnClickListener{
    private View m_vFindWorkFragment;
    private RelativeLayout rlAccountSet;
    private RelativeLayout rlSystemSet;
    private RelativeLayout rlInviteSet;
    private RelativeLayout rlEscrowSet;
    private LinearLayout llTopUp;
    private LinearLayout llWithdraw;
    private RefreshData refreshdata;

    String uid;
    private TextView tvUserName;
    private TextView tvRegisterJZH;
    private TextView  tvAccountSum;
    private TextView  tvUsableAmount;
    private TextView  tvFrozenAmount;
    private TextView  tvForPaySum;
    private TextView  tvEarnSum;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //  return super.onCreateView(inflater, container, savedInstanceState);
        m_vFindWorkFragment = inflater.inflate(R.layout.fragment_personal_center, container,false);
        init();
        return m_vFindWorkFragment;
    }



    @Override
    public void onStart() {
        Log.i("!!!2",""+MYHZApplication.getUid());

        super.onStart();
        if (isLogin()){
            refresh();

        }
    }

    /**
     * 更新数据
     */
    private void refresh() {
        Log.i("!!!4",""+"refresh"+"!!!uid"+MYHZApplication.getUid());

        final String refreshUrl= Constant.ACCOUNT_INFORMATION;
        RequestParams refreshParams = new RequestParams(refreshUrl);
        refreshParams.addBodyParameter("auth", "{uid:'" + MYHZApplication.getUid()+ "'}");
        x.http().post(refreshParams, new Callback.CommonCallback<String>() {
            //响应成功
            @Override
            public void onSuccess(String s) {
                Log.i("!!!5",""+"onSuccess");
                Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
                Gson gson=new Gson();
                refreshdata=gson.fromJson(s,RefreshData.class);
                tvUserName.setText(refreshdata.getUsername().toString());
                if (isRegisterJZH()){
                    tvRegisterJZH.setText("已开户");
                    tvRegisterJZH.setTextColor(Color.rgb(80,80,80));
                } else {
                    tvRegisterJZH.setText("未开户");
                    tvRegisterJZH.setTextColor(Color.rgb(250,03,03));
                }
                tvUsableAmount.setText(refreshdata.getUsableAmount()+"元");
                tvAccountSum.setText(refreshdata.getAccountSum()+"元");
                tvFrozenAmount.setText(refreshdata.getFreezeAmount()+"元");
                tvEarnSum.setText(refreshdata.getEarnSum()+"元");
                tvForPaySum.setText(refreshdata.getForPaySum()+"元");



            }



            @Override
            public void onError(Throwable throwable, boolean b) {
                Toast.makeText(getActivity(),throwable.toString(),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });


    }

    private void init() {

        llTopUp= (LinearLayout) m_vFindWorkFragment.findViewById(R.id.ll_mycenter_top_up);
        llWithdraw= (LinearLayout) m_vFindWorkFragment.findViewById(R.id.ll_mycenter_withdraw);
        llTopUp.setOnClickListener(this);
        llWithdraw.setOnClickListener(this);


        rlAccountSet= (RelativeLayout) m_vFindWorkFragment.findViewById(R.id.rl_mycenter_account_set);
        rlSystemSet= (RelativeLayout) m_vFindWorkFragment.findViewById(R.id.rl_mycenter_system_set);
        rlInviteSet= (RelativeLayout) m_vFindWorkFragment.findViewById(R.id.rl_mycenter_invite_set);
        rlEscrowSet= (RelativeLayout) m_vFindWorkFragment.findViewById(R.id.rl_mycenter_escrow_set);
        rlAccountSet.setOnClickListener(this);
        rlSystemSet.setOnClickListener(this);
        rlInviteSet.setOnClickListener(this);
        rlEscrowSet.setOnClickListener(this);

        tvUserName= (TextView) m_vFindWorkFragment.findViewById(R.id.tv_myCenter_username);
        tvRegisterJZH= (TextView) m_vFindWorkFragment.findViewById(R.id.tv_myCenter_escrow);
        tvUsableAmount= (TextView) m_vFindWorkFragment.findViewById(R.id.tv_myCenter_usable_Amount);
        tvAccountSum= (TextView) m_vFindWorkFragment.findViewById(R.id.tv_myCenter_totalAmount);
        tvFrozenAmount= (TextView) m_vFindWorkFragment.findViewById(R.id.tv_myCenter_frozenAmount);
        tvEarnSum= (TextView) m_vFindWorkFragment.findViewById(R.id.tv_myCenter_incomeAmount);
        tvForPaySum= (TextView) m_vFindWorkFragment.findViewById(R.id.tv_myCenter_waitAmount);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_mycenter_top_up:
                Intent intent=new Intent(getContext(),TopUpActivity.class);

                startActivity(intent);
                break;
            case R.id.ll_mycenter_withdraw:
                intent = new Intent(getContext(), WithdrawActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_mycenter_account_set:
                intent=new Intent(getContext(),AccountSetActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_mycenter_system_set:
                intent = new Intent(getContext(), AccountSetActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_mycenter_invite_set:
                intent = new Intent(getContext(), AccountSetActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_mycenter_escrow_set:
                intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra("url", Constant.JZH_REGISTER);
                intent.putExtra("money","");
                startActivity(intent);
                break;
        }

    }

    public boolean isLogin() {
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("user", getContext().MODE_PRIVATE);
        uid = sharedPreferences.getString("uid", "1");
        Log.i("!!!3",""+uid);
        if ("1".equals(uid)){
            Toast.makeText(getActivity(),"你还没有登录喔!",Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }

    //判断是否注册金账户，注册返回true 未注册返回false
    public boolean isRegisterJZH() {
        if ( refreshdata.getUsername().equals(refreshdata.getMobilePhone())){
            return false;
        }
        return true;
    }
}
