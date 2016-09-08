package com.mycarhz.myhz.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.Xml;
import android.widget.Toast;

import com.mycarhz.myhz.bean.UpdateInfo;

import org.xmlpull.v1.XmlPullParser;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/8/30.
 */
public class Utils  {



    public static boolean isNetworkAvailable(Activity activity)
    {
        Context context = activity.getApplicationContext();
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null)
        {
            return false;
        }
        else
        {
            // 获取NetworkInfo对象
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();

            if (networkInfo != null && networkInfo.length > 0)
            {
                for (int i = 0; i < networkInfo.length; i++)
                {
                    System.out.println(i + "===状态===" + networkInfo[i].getState());
                    System.out.println(i + "===类型===" + networkInfo[i].getTypeName());
                    // 判断当前网络状态是否为连接状态
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

        //获取当前版本号
        public static String getVersionName(Context context) throws Exception{
            //获取packagemanager的实例
            PackageManager packageManager = context.getPackageManager();
            //getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packInfo.versionName;
        }

 //   获取服务器端的版本号：
           /*
2. * 用pull解析器解析服务器返回的xml文件 (xml封装了版本号)
3. */
           public static UpdateInfo getUpdataInfo(InputStream is) throws Exception{
           XmlPullParser  parser = Xml.newPullParser();
         parser.setInput(is, "utf-8");//设置解析的数据源
         int type = parser.getEventType();
         UpdateInfo info = new UpdateInfo();//实体
            while(type != XmlPullParser.END_DOCUMENT ){
                  switch (type) {
                        case XmlPullParser.START_TAG:
                          if("version".equals(parser.getName())){
                                      info.setVersion(parser.nextText()); //获取版本号
                              }else if ("url".equals(parser.getName())){
                                    info.setUrl(parser.nextText()); //获取要升级的APK文件
                                }else if ("description".equals(parser.getName())){
                                     info.setDescription(parser.nextText()); //获取该文件的信息
                               }
                             break;
                     }
                 type = parser.next();
             }
           return info;
       }



 //   从服务器下载apk:
          public static File getFileFromServer(String path, ProgressDialog pd) throws Exception{
          //如果相等的话表示当前的sdcard挂载在手机上并且是可用的
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                  URL url = new URL(path);
                 HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
                 //获取到文件的大小
             pd.setMax(conn.getContentLength());
                 InputStream is = conn.getInputStream();
                File file = new File(Environment.getExternalStorageDirectory(), "updata.apk");
                    FileOutputStream fos = new FileOutputStream(file);
                   BufferedInputStream bis = new BufferedInputStream(is);
                  byte[] buffer = new byte[1024];
                 int len ;
                  int total=0;
               while((len =bis.read(buffer))!=-1){
                          fos.write(buffer, 0, len);
                         total+= len;
                        //获取当前下载量
                           pd.setProgress(total);
                        }
                  fos.close();
                  bis.close();
                is.close();
                   return file;
               }
           else{
                  return null;
                }
       }
    /**
     * 开启Activity
     * @param context
     * @param clazz
     */
    public static void startActivity(Context context, Class clazz) {
        context.startActivity(new Intent(context,clazz));

    }

    /**
     * toast工具方法
     * @param context
     * @param text
     */
    public static void toast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }


}