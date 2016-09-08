package com.mycarhz.myhz.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.RadioGroup;

import com.mycarhz.myhz.R;
import com.mycarhz.myhz.application.MYHZApplication;
import com.mycarhz.myhz.fragment.Fragment_client;
import com.mycarhz.myhz.fragment.Fragment_fund_record;
import com.mycarhz.myhz.fragment.Fragment_home_page;
import com.mycarhz.myhz.fragment.Fragment_my_all;
import com.mycarhz.myhz.fragment.Fragment_personal_center;

import java.util.List;

public class MainActivity extends FragmentActivity  implements RadioGroup.OnCheckedChangeListener{


    private List<Fragment> fragments ;
    private RadioGroup group;
    private android.support.v4.app.FragmentManager fm;
    private Fragment_home_page fragment_home_page;
    private Fragment_my_all fragment_my_all;
    private Fragment_client fragment_client;
    private Fragment_fund_record fragment_fund_record;
    private Fragment_personal_center fragment_personal_center;

    //http://192.168.199.154:8080/app/queryInvestList.do

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup group = (RadioGroup) findViewById(R.id.activity_group_radioGroup);
        group.setOnCheckedChangeListener(this);

        //默认初始化第一个
        initFragment1();

        //判断是否有网
//
//        if (Utils.isNetworkAvailable(MainActivity.this))
//        {
//      //      Toast.makeText(getApplicationContext(), "当前有可用网络！", Toast.LENGTH_LONG).show();
//            String versionName = null;
//            try {
//                versionName = Utils.getVersionName(MainActivity.this);
//                Log.i("test","===================="+versionName+"=====================");
//                CheckVersionTask checkVersionTask = new CheckVersionTask(MainActivity.this);
//           //     checkVersionTask.isOK();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }
//        else
//        {
//            Toast.makeText(getApplicationContext(), "当前没有可用网络！", Toast.LENGTH_LONG).show();
//        }


    }



    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.homepage :
                initFragment1();
                break;

            case R.id.myall :
                initFragment2();
                break;

            case R.id.client :
                initFragment3();
                break;

            case R.id.fund :
                SharedPreferences sp=getSharedPreferences("user", Context.MODE_PRIVATE);
                String uid=sp.getString("uid","1");
                if ("1".equals(uid)){
                    radioGroup.check(R.id.homepage);
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                    break;
                } else {
                    initFragment4();
                    break;
                }



            case R.id.personal :
                Log.i("!!!!1",""+ MYHZApplication.getUid());
                sp=getSharedPreferences("user", Context.MODE_PRIVATE);
                uid=sp.getString("uid","1");
                if ("1".equals(uid)){
                    radioGroup.check(R.id.homepage);
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                    break;
                } else {
                    initFragment5();
                    break;
                }
        }
    }



    //显示第一个fragment
    public void initFragment1(){
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if(fragment_home_page == null){
            fragment_home_page = new Fragment_home_page();
            transaction.add(R.id.container, fragment_home_page);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(fragment_home_page);

        transaction.commit();
    }

    //显示第2个fragment
    public void initFragment2(){
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if(fragment_my_all == null){
            fragment_my_all = new Fragment_my_all();
            transaction.add(R.id.container, fragment_my_all);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(fragment_my_all);

        transaction.commit();
    }

    //显示第3个fragment
    public void initFragment3(){
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if(fragment_client == null){
            fragment_client = new Fragment_client();
            transaction.add(R.id.container, fragment_client);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(fragment_client);

        transaction.commit();
    }

    //显示第4个fragment
    public void initFragment4(){
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if(fragment_fund_record == null){
            fragment_fund_record = new Fragment_fund_record();
            transaction.add(R.id.container, fragment_fund_record);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(fragment_fund_record);

        transaction.commit();
    }

    //显示第5个fragment
    private void initFragment5(){
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if(fragment_personal_center == null){
            fragment_personal_center = new Fragment_personal_center();
            transaction.add(R.id.container, fragment_personal_center);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(fragment_personal_center);

        transaction.commit();
    }


    //隐藏所有的fragment
    private void hideFragment(FragmentTransaction transaction){
        if(fragment_home_page != null){
            transaction.hide(fragment_home_page);
        }
        if(fragment_my_all != null){
            transaction.hide(fragment_my_all);
        }
        if(fragment_client != null){
            transaction.hide(fragment_client);
        }
        if(fragment_fund_record != null){
            transaction.hide(fragment_fund_record);
        }
        if(fragment_personal_center != null){
            transaction.hide(fragment_personal_center);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        android.os.Process.killProcess(android.os.Process.myPid());
        //或者下面这种方式
        //android.os.Process.killProcess(android.os.Process.myPid());
    }


}
