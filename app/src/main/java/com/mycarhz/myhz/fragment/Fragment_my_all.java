package com.mycarhz.myhz.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.mycarhz.myhz.R;
import com.mycarhz.myhz.bean.MyAllInfo;
import com.mycarhz.myhz.bean.ZCInfo;
import com.mycarhz.myhz.constant.Constant;
import com.mycarhz.myhz.ui.PullToRefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/26.
 */
public class Fragment_my_all extends Fragment{

    private View m_vFindWorkFragment2;
    private List<MyAllInfo> list;
    private String URL = "http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg";
    private PullToRefreshListView lv;
    private Gson gson;
    private ZCInfo.PageBeanBean pageBean;
    /**
     * error : -1
     * pageBean : {"page":[{"paymentMode":4,"setDuein":0,"borrowWay":3,"borrowShow":1,"openTime":-1473057675,"purpose":10,"id":64,"vip":1,"username":"13986200253","isDayThe":2,"imgPath":"images/pro2.jpg","hasPWD":-1,"credit":1,"isRecommend":1,"borrowTitle":"第十期众筹项目\u2014\u2014保时捷Boxster","borrowStatus":4,"schedules":"100.00","investAll":"2","vipStatus":1,"publishTime":{"date":18,"day":1,"hours":13,"minutes":51,"month":0,"nanos":0,"seconds":17,"time":1453096277000,"timezoneOffset":-480,"year":116},"investNum":"0.00","creditrating":0,"borrow_num":"20160118135046","excitationSum":0,"minTenderedSum":100,"borrowAmount":"1.08","annualRate":12,"excitationType":1,"deadline":3,"util":"万"},{"paymentMode":4,"setDuein":0,"borrowWay":3,"borrowShow":1,"openTime":-1473057675,"purpose":17,"id":5,"vip":1,"username":"PCWR20151016111314837","isDayThe":2,"imgPath":"images/pro3.jpg","hasPWD":-1,"credit":1,"isRecommend":2,"borrowTitle":"哇车宝C20151030-01","borrowStatus":5,"schedules":"100.00","investAll":"7","vipStatus":1,"publishTime":{"date":30,"day":5,"hours":14,"minutes":16,"month":9,"nanos":0,"seconds":45,"time":1446185805000,"timezoneOffset":-480,"year":115},"investNum":"0.00","creditrating":1,"borrow_num":"20151030140928","excitationSum":0,"minTenderedSum":100,"borrowAmount":"21.00","annualRate":8,"excitationType":1,"deadline":15,"util":"万"},{"paymentMode":4,"setDuein":0,"borrowWay":3,"borrowShow":1,"openTime":-1473057675,"purpose":17,"id":4,"vip":1,"username":"PCWR20151016111314837","isDayThe":2,"imgPath":"images/pro3.jpg","hasPWD":-1,"credit":1,"isRecommend":2,"borrowTitle":"哇车宝C20151016-02","borrowStatus":4,"schedules":"100.00","investAll":"18","vipStatus":1,"publishTime":{"date":16,"day":5,"hours":16,"minutes":23,"month":9,"nanos":0,"seconds":15,"time":1444983795000,"timezoneOffset":-480,"year":115},"investNum":"0.00","creditrating":1,"borrow_num":"20151016162231","excitationSum":0,"minTenderedSum":100,"borrowAmount":"25.90","annualRate":8,"excitationType":1,"deadline":15,"util":"万"}],"pageNum":1,"pageSize":20,"startOfPage":0,"totalNum":3,"totalPageNum":1}
     * msg : 成功
     */

    private String error;
    private List<ZCInfo.PageBeanBean.PageBean> page;
    private RequestParams loginParams;


    /**
     * page : [{"paymentMode":4,"setDuein":0,"borrowWay":3,"borrowShow":1,"openTime":-1473057675,"purpose":10,"id":64,"vip":1,"username":"13986200253","isDayThe":2,"imgPath":"images/pro2.jpg","hasPWD":-1,"credit":1,"isRecommend":1,"borrowTitle":"第十期众筹项目\u2014\u2014保时捷Boxster","borrowStatus":4,"schedules":"100.00","investAll":"2","vipStatus":1,"publishTime":{"date":18,"day":1,"hours":13,"minutes":51,"month":0,"nanos":0,"seconds":17,"time":1453096277000,"timezoneOffset":-480,"year":116},"investNum":"0.00","creditrating":0,"borrow_num":"20160118135046","excitationSum":0,"minTenderedSum":100,"borrowAmount":"1.08","annualRate":12,"excitationType":1,"deadline":3,"util":"万"},{"paymentMode":4,"setDuein":0,"borrowWay":3,"borrowShow":1,"openTime":-1473057675,"purpose":17,"id":5,"vip":1,"username":"PCWR20151016111314837","isDayThe":2,"imgPath":"images/pro3.jpg","hasPWD":-1,"credit":1,"isRecommend":2,"borrowTitle":"哇车宝C20151030-01","borrowStatus":5,"schedules":"100.00","investAll":"7","vipStatus":1,"publishTime":{"date":30,"day":5,"hours":14,"minutes":16,"month":9,"nanos":0,"seconds":45,"time":1446185805000,"timezoneOffset":-480,"year":115},"investNum":"0.00","creditrating":1,"borrow_num":"20151030140928","excitationSum":0,"minTenderedSum":100,"borrowAmount":"21.00","annualRate":8,"excitationType":1,"deadline":15,"util":"万"},{"paymentMode":4,"setDuein":0,"borrowWay":3,"borrowShow":1,"openTime":-1473057675,"purpose":17,"id":4,"vip":1,"username":"PCWR20151016111314837","isDayThe":2,"imgPath":"images/pro3.jpg","hasPWD":-1,"credit":1,"isRecommend":2,"borrowTitle":"哇车宝C20151016-02","borrowStatus":4,"schedules":"100.00","investAll":"18","vipStatus":1,"publishTime":{"date":16,"day":5,"hours":16,"minutes":23,"month":9,"nanos":0,"seconds":15,"time":1444983795000,"timezoneOffset":-480,"year":115},"investNum":"0.00","creditrating":1,"borrow_num":"20151016162231","excitationSum":0,"minTenderedSum":100,"borrowAmount":"25.90","annualRate":8,"excitationType":1,"deadline":15,"util":"万"}]
     * pageNum : 1
     * pageSize : 20
     * startOfPage : 0
     * totalNum : 3
     * totalPageNum : 1
     */
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 9 :
                    myAdapter.notifyDataSetChanged();
                    lv.setRefreshFinish();
                    break;
                case 8 :
                    myAdapter.notifyDataSetChanged();
                    lv.setLoadMoreFinish();
                    break;
            }
        }
    };
    private MyAdapter myAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //  return super.onCreateView(inflater, container, savedInstanceState);
        m_vFindWorkFragment2 = inflater.inflate(R.layout.fragment_my_all, container,false);

        return m_vFindWorkFragment2;

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initHttp();

        Log.i("test","00000000000000000000000000000000000000000000000");


    }

    private void initHttp() {
        String loginUrl= Constant.FUND_XM;
        loginParams = new RequestParams(loginUrl);
        x.http().get(loginParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.i("test",s);
                gson = new Gson();
                ZCInfo zcInfo = gson.fromJson(s, ZCInfo.class);
                pageBean = zcInfo.getPageBean();
                page = pageBean.getPage();
                Log.i("tesy", "第一个执行");
                Log.i("tesy", Fragment_my_all.this.page.toString());
                Log.i("test", Fragment_my_all.this.page.size()+"");
                Log.i("test",page.get(0).getImgPath());
                init();
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.i("test","222222222222222");
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
        initDate();

        lv = (PullToRefreshListView) m_vFindWorkFragment2.findViewById(R.id.lv);
        myAdapter = new MyAdapter(page);

        lv.setAdapter(myAdapter);
        Log.i("tesy", "第二个执行");

        lv.setOnPullToRefreshListener(new PullToRefreshListView.OnPullToRefreshListener() {
            @Override
            public void onRefersh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
//                        list.add(0,new ClientInfo(wurl,"吴孟达","20","30天","3201.1万元","18672360790"));
                        x.http().get(loginParams, new Callback.CommonCallback<String>() {
                            @Override
                            public void onSuccess(String s) {
                                ZCInfo zcInfo = gson.fromJson(s, ZCInfo.class);
                                pageBean = zcInfo.getPageBean();
                                page = pageBean.getPage();
                            }

                            @Override
                            public void onError(Throwable throwable, boolean b) {

                            }

                            @Override
                            public void onCancelled(CancelledException e) {

                            }

                            @Override
                            public void onFinished() {

                            }
                        });


                        Message message = new Message();
                        //发送消息与处理函数里一致
                        message.what = 9;
                        //内部类调用外部类的变量
                        handler.sendMessage(message);

                    }
                }).start();
            }

            @Override
            public void onLoadMore() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Message message = new Message();
                        //发送消息与处理函数里一致
                        message.what = 8;
                        //内部类调用外部类的变量
                        handler.sendMessage(message);
                    }
                }).start();
            }

        });
    }

    private void initDate() {
        list = new ArrayList<>();

        for (int i = 0 ; i < 30 ; i++) {
            list.add(new MyAllInfo("蚂蚁合众第"+i+"期众筹项目丰田凯美瑞", 180000, i, i, 95000,2));
        }
    }







    class MyAdapter extends BaseAdapter {
        private List<ZCInfo.PageBeanBean.PageBean> page;

        public MyAdapter(List<ZCInfo.PageBeanBean.PageBean> page) {
            this.page = page;
        }

        @Override
        public int getCount() {
            return page.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            Viewholder viewholder = null;
            if (view == null) {
                viewholder = new Viewholder();
                view = View.inflate(getContext(),R.layout.listview_homepager2,null);
                viewholder.title = (TextView) view.findViewById(R.id.tv_title);
                viewholder.money = (TextView) view.findViewById(R.id.money);
                viewholder.pb = (ProgressBar) view.findViewById(R.id.pb);
                viewholder.percentage = (TextView) view.findViewById(R.id.percentage);
                viewholder.no_money = (TextView) view.findViewById(R.id.no_money);
                viewholder.people = (TextView) view.findViewById(R.id.people);
                viewholder.danwei = (TextView) view.findViewById(R.id.danwei);
                viewholder.iv = (ImageView) view.findViewById(R.id.iv);

                view.setTag(viewholder);
            } else {
                viewholder = (Viewholder) view.getTag();
            }

            viewholder.title.setText(page.get(i).getBorrowTitle());
            viewholder.money.setText(page.get(i).getBorrowAmount());
            viewholder.danwei.setText(page.get(i).getUtil());
            viewholder.no_money.setText(page.get(i).getInvestNum());
            viewholder.people.setText(page.get(i).getInvestAll());
            double v = Double.parseDouble((page.get(i).getSchedules()));
            Log.i("test",v+"vvvvvvvvvvvvvvvvvvv");
            int b = (int) v;
            Log.i("test",b+"bbbbbbbbbbbbbbbbbbb");
            viewholder.pb.setProgress(b);

            viewholder.percentage.setText(b+"");

            Glide.with(Fragment_my_all.this).load(Constant.BASE+page.get(i).getImgPath()).into(viewholder.iv);



            viewholder.iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("text","图片详情"+i);
                }
            });

            return view;
        }
    }

    static class Viewholder {
        TextView title;
        TextView money;
        TextView people;
        ProgressBar pb;
        TextView percentage;
        TextView no_money;
        TextView danwei;
        ImageView iv;

    }



}
