package com.mycarhz.myhz.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mycarhz.myhz.R;
import com.mycarhz.myhz.application.MYHZApplication;
import com.mycarhz.myhz.bean.UpdateInfo;
import com.mycarhz.myhz.utils.CheckVersionTask;
import com.mycarhz.myhz.utils.Utils;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.File;

/**
 * Created by Administrator on 2016/8/31.
 */
public class SplashActivity extends Activity {

    private final int SPLASH_DISPLAY_LENGHT = 5000; //延迟三秒
    private TextView tv_version_name;

    private String uid;
    private String username;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        init();
        initLoadingAnimator();
        isNet();

        isLogin();


    }

    private void isNet() {
        //判断是否有网

        if (Utils.isNetworkAvailable(SplashActivity.this))
        {
            Utils.toast(this,"当前有可用网络,我要判断版本号");
       //     showUpdateDialog();
            goMain();
        }
        else
        {
            Utils.toast(this,"当前没有可用网络");
            goMain();
        }
    }

    private void init() {
       showVersionName();
    }

    private void goMain() {
        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }

        }, SPLASH_DISPLAY_LENGHT);
    }

    /**
     * 设置界面的动画
     * */
    private void initLoadingAnimator() {		//设置界面的动画
        ImageView iv_loding = (ImageView) findViewById(R.id.iv_loding);
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv_loding, "rotationY", 0,180);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(iv_loding, "rotation", 0,360);
        animator.setDuration(2500);	//重复时间
        animator1.setDuration(1250);	//重复时间
        animator.setRepeatCount(ObjectAnimator.INFINITE);	//次数
        animator1.setRepeatCount(ObjectAnimator.INFINITE);	//次数
        animator.setRepeatMode(ObjectAnimator.REVERSE);	//方式
        animator1.setRepeatMode(ObjectAnimator.RESTART);	//方式
//		setInterpolator 动画插入器  改变动画的运行轨迹     LinearInterpolator 匀速动画
        animator1.setInterpolator(new LinearInterpolator());			//匀速动画
        animator.setInterpolator(new LinearInterpolator());			//匀速动画
//		animator.setInterpolator(new BounceInterpolator());		//回弹效果
        animator.start();
        animator1.start();
    }

    /**
     * 获取版本的名称
     * */
    private String getVersionName() {		//获取版本的名称
        //PackageManager 获取包管理者 可以通过它获取信息
        PackageManager pm = getPackageManager();
        //获取包信息
        try {
            //Flag 获取包信息的一些特定数据 0代表不获取
            PackageInfo packageInfo = pm.getPackageInfo(getPackageName(), 0);

            return packageInfo.versionName	;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 调用获取版本号
     * */
    private void showVersionName() {	//调用获取版本号
        TextView tv_version_name = (TextView) findViewById(R.id.tv_version_name);
        //获取版本号
        String VersionName =getVersionName();
        if (VersionName!=null) {
            tv_version_name.setText("版本号:V"+VersionName);
        }
    }

    //检查更新
    private void checkUpdate () {
        new Thread(){
            @Override
            public void run() {
                super.run();
                HttpClient client = new DefaultHttpClient();
            }
        }.start();
    }


    /**
     * 显示更新的对话框
     * @param
     * */
    protected void showUpdateDialog() {
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setTitle("版本更新");
        builder.setMessage("08-31 02:19:50.195 25904-25904/com.mycarhz.myhz I/Choreographer: Skipped 166 frames!  The application may be doing too much work on its main thread.");
        builder.setCancelable(false);	//不能点击提示框外面
        builder.setPositiveButton("更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //进入版本更新
                Utils.toast(SplashActivity.this,"我要下载 安装");
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("以后再说", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //进入主界面

                dialog.dismiss(); 	//关闭界面
                goMain();
            }
        });
        builder.create().show();
    }


    public boolean isLogin() {
        SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        uid=sharedPreferences.getString("uid","1");
        username=sharedPreferences.getString("username","");
        if (uid.equals("1")){
            return false;
        }else {
            MYHZApplication.setUid(uid);
            Log.i("!!!splash",""+MYHZApplication.getUid());
            MYHZApplication.setUsername(username);
            Log.i("!!!splash",""+MYHZApplication.getUsername());
            return true;
        }
    }

}
