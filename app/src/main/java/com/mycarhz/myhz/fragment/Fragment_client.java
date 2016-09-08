package com.mycarhz.myhz.fragment;

import android.content.Intent;
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
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.mycarhz.myhz.R;
import com.mycarhz.myhz.activity.ClientActivity;
import com.mycarhz.myhz.bean.ClientInfo;
import com.mycarhz.myhz.bean.Clientbean;
import com.mycarhz.myhz.constant.Constant;
import com.mycarhz.myhz.ui.PullToRefreshListView;
import com.mycarhz.myhz.utils.Utils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/26.
 */
public class Fragment_client extends Fragment {

    private View m_vFindWorkFragment;
    private ListView lv_client;
    private String url = "http://shuaige.ratoo.net/uploads/allimg/130109/2-130109210422.jpg";
    private String wurl = "http://img5.imgtn.bdimg.com/it/u=2152980172,2086556761&fm=21&gp=0.jpg";
    private List<ClientInfo> list;
    List<Clientbean.TeamListBean> teamList ;
    private Gson gson;

    private PullToRefreshListView ptrList;
    private BaseAdapter adapter;
    private String CLIENT;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1 :
                    myAdapter.notifyDataSetChanged();
                                ptrList.setRefreshFinish();
                    break;
                case 2 :
                    myAdapter.notifyDataSetChanged();
                    ptrList.setLoadMoreFinish();
                    break;
            }
        }
    };
    private MyAdapter myAdapter;
    private RequestParams loginParams;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //  return super.onCreateView(inflater, container, savedInstanceState);
        m_vFindWorkFragment = inflater.inflate(R.layout.fragment_client, container,false);

        return m_vFindWorkFragment;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initHttp();
        initDate();

    }

    private void initHttp() {
        CLIENT = Constant.CLIENT;
        loginParams = new RequestParams(CLIENT);
        x.http().get(loginParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.i("test","9999999"+s);
                gson = new Gson();
                Clientbean clientbean = gson.fromJson(s, Clientbean.class);
               teamList = clientbean.getTeamList();
                init();
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.i("test","9999999555555555555555555");
            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
        }

    private void initDate() {
        list = new ArrayList<>();
        for (int i = 0 ; i < 20 ; i++) {
            list.add(new ClientInfo(url,"吴彦祖","20","30天","3201.1万元","18672360790"));
        }
    }

    private void init() {
        TextView client = (TextView) m_vFindWorkFragment.findViewById(R.id.zhuce);
        client.setText(" 受托人");
        TextView denglu = (TextView) m_vFindWorkFragment.findViewById(R.id.denglu);
        denglu.setVisibility(View.GONE);


        ptrList = (PullToRefreshListView) m_vFindWorkFragment.findViewById(R.id.ptr_list);
        myAdapter = new MyAdapter(teamList);
        ptrList.setAdapter(myAdapter);

        ptrList.setOnPullToRefreshListener(new PullToRefreshListView.OnPullToRefreshListener() {
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
                                Clientbean clientbean = gson.fromJson(s, Clientbean.class);
                                teamList = clientbean.getTeamList();

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
                        message.what = 1;
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
 //                       String data = "宝宝也不知道说啥了";
                //        datas.add(data);
                        list.add(new ClientInfo(wurl,"吴孟达","20","30天","3201.1万元","18672360790"));
//                        runOnUiThread(new Runnable() {
//                            public void run() {
//                                adapter.notifyDataSetChanged();
//                                ptrList.setLoadMoreFinish();
//                            }
//                        });
                        Message message = new Message();
                        //发送消息与处理函数里一致
                        message.what = 2;
                        //内部类调用外部类的变量
                        handler.sendMessage(message);
                    }
                }).start();
            }
        });
    }



        class MyAdapter extends BaseAdapter {

            List<Clientbean.TeamListBean> list;

            public MyAdapter(List<Clientbean.TeamListBean> list) {

                this.list = list;
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int i) {
                return i;
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
                    view = View.inflate(getContext(), R.layout.demo_layout, null);
                    viewholder.imageView = (ImageView) view.findViewById(R.id.imageView);
                    viewholder.textView = (TextView) view.findViewById(R.id.textView1);
                    viewholder.textView2_value = (TextView) view.findViewById(R.id.textView2_value);
                    viewholder.textView3_value = (TextView) view.findViewById(R.id.textView3_value);
                    viewholder.textView4_value = (TextView) view.findViewById(R.id.textView4_value);
                    viewholder.phone = (TextView) view.findViewById(R.id.phone);
                    viewholder.btn = (ImageView) view.findViewById(R.id.btn);
                    view.setTag(viewholder);
                } else {
                    viewholder = (Viewholder) view.getTag();
                }
                Glide.with(Fragment_client.this).load(Constant.BASE+list.get(i).getImgPath()).into(viewholder.imageView);
                viewholder.textView.setText(list.get(i).getUserName());
                viewholder.textView2_value.setText(list.get(i).getNum() + "");
                viewholder.textView3_value.setText(list.get(i).getAvgDay() + "");
                viewholder.textView4_value.setText(list.get(i).getHasInterest() + "");
                viewholder.phone.setText(list.get(i).getPhone() + "");
                viewholder.btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Utils.toast(getContext(),"个梵蒂冈梵蒂冈"+ getItem(i));
                        Intent intent = new Intent(getContext(), ClientActivity.class);
                        startActivity(intent);
                    }
                });

                return view;
            }


        }
        class Viewholder {
            ImageView imageView;
            TextView textView;
            TextView textView2_value;
            TextView textView3_value;
            TextView textView4_value;
            TextView phone;
            ImageView btn;
        }


}
