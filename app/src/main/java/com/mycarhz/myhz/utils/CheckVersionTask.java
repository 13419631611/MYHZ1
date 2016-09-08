package com.mycarhz.myhz.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.mycarhz.myhz.R;
import com.mycarhz.myhz.activity.LoginActivity;
import com.mycarhz.myhz.bean.UpdateInfo;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/8/30.
 */
public class CheckVersionTask {

    private static final int UPDATA_CLIENT = 1 ;
    private static final int GET_UNDATAINFO_ERROR = 2 ;
    private static final int DOWN_ERROR =3 ;


    Context context;
    private UpdateInfo info;

    public CheckVersionTask(Context context) {
        this.context = context;
    }

    public void isOK() {
        try {
            //从资源文件获取服务器 地址    
            String path =context.getResources().getString(R.string.serverurl);
            //包装成url的对象    
            URL url = new URL(path);
            HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            InputStream is =conn.getInputStream();
            info = Utils.getUpdataInfo(is);

            if(info.getVersion().equals(Utils.getVersionName(context))){
                Log.i("TAG","版本号相同无需升级");
                LoginMain();
            }else{
                Log.i("TAG","版本号不同 ,提示用户升级 ");
                Message msg = new Message();
                msg.what = UPDATA_CLIENT;
                handler.sendMessage(msg);
            }
        } catch (Exception e) {
            // 待处理    
            Message msg = new Message();
            msg.what = GET_UNDATAINFO_ERROR;
            handler.sendMessage(msg);
            e.printStackTrace();
        }
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            switch (msg.what) {
                case UPDATA_CLIENT:
                    //对话框通知用户升级程序
                //    showUpdataDialog();
                    Toast.makeText(context, "999999999999999999999999999", Toast.LENGTH_LONG).show();
                    break;
                case GET_UNDATAINFO_ERROR:
                    //服务器超时
                    Toast.makeText(context, "获取服务器更新信息失败", Toast.LENGTH_LONG).show();
                    LoginMain();
                    break;
                case DOWN_ERROR:
                    //下载apk失败
                    Toast.makeText(context, "下载新版本失败", Toast.LENGTH_LONG).show();
                    LoginMain();
                    break;
            }
        }
    };

    private void LoginMain(){
        Intent intent = new Intent(context,LoginActivity.class);
        context.startActivity(intent);
        //结束掉当前的activity

    }
}
