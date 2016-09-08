package com.mycarhz.myhz.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mycarhz.myhz.R;
import com.mycarhz.myhz.bean.ClientJJInfo;
import com.mycarhz.myhz.ui.PullToRefreshListView;
import com.mycarhz.myhz.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/1.
 */
public class ClientActivity extends Activity implements View.OnClickListener {

    private PullToRefreshListView lv;
    private List<ClientJJInfo> list;
    private List<ClientJJInfo> list2;
    private TextView tv_client_xm;
    private TextView tv_client_jj;
    private boolean isok = false;
    private View weituo_line;
    private View wancheng_line;
    private MyAdapter myAdapter;
    private TextView zhuce;
    private TextView denglu;
    private int mPosition;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avtivity_client);
        init();
    }

    private void init() {
        lv = (PullToRefreshListView) findViewById(R.id.lv);
        list = new ArrayList<>();
        list2 = new ArrayList<>();

        for (int i = 0 ; i < 20 ; i++) {
            list.add(new ClientJJInfo("第"+i+"期【津港】奔驰要你命3000","98万元","101万元","4.12%","进行中"));
            list2.add(new ClientJJInfo("我以完成第"+i+"期【津港】奔驰要你命3000","98万元","101万元","4.12%","20天"));
        }

        zhuce = (TextView) findViewById(R.id.zhuce);
        denglu = (TextView) findViewById(R.id.denglu);

        zhuce.setText("受托人简介");
        denglu.setVisibility(View.GONE);

        //   View view = LayoutInflater.from(this).inflate(R.layout.client_header, null);
        View view = getLayoutInflater().inflate(R.layout.client_header, null);

        View weituo = view.findViewById(R.id.weituo);
        View wancheng = view.findViewById(R.id.wancheng);
        tv_client_jj = (TextView) view.findViewById(R.id.tv_client_jj);
        weituo_line = view.findViewById(R.id.weituo_line);
        tv_client_xm = (TextView) view.findViewById(R.id.tv_client_xm);
        wancheng_line = view.findViewById(R.id.wancheng_line);

        weituo.setOnClickListener(this);
        wancheng.setOnClickListener(this);
        lv.addHeaderView(view);
        myAdapter = new MyAdapter();
        myAdapter.setList(list);
        lv.setAdapter(myAdapter);
        if (isok == false) {
            tv_client_xm.setTextColor(Color.BLACK);
            wancheng_line.setVisibility(View.GONE);
        }

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
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (!isok) {
                                    list.add(0,new ClientJJInfo("111下拉刷新【津港】奔驰要你命3000","98万元","101万元","4.12%","跑路了"));
                                    myAdapter.notifyDataSetChanged();
                                    lv.setRefreshFinish();
                                } else {
                                    list2.add(0,new ClientJJInfo("222下拉刷新【津港】奔驰要你命3000","98万元","101万元","4.12%","20天"));
                                    myAdapter.notifyDataSetChanged();
                                    lv.setRefreshFinish();
                                }
                            }
                        });
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

                        runOnUiThread(new Runnable() {
                            public void run() {
                                if (isok) {
                                    list2.add(new ClientJJInfo("222上拉【津港】奔驰要你命3000","98万元","101万元","4.12%","20天"));
                                    myAdapter.notifyDataSetChanged();
                                    lv.setLoadMoreFinish();
                                } else {
                                    list.add(new ClientJJInfo("111上拉【津港】奔驰要你命3000","98万元","101万元","4.12%","20天"));
                                    myAdapter.notifyDataSetChanged();
                                    lv.setLoadMoreFinish();
                                }
                            }
                        });
                    }
                }).start();
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.weituo :
                isok = false ;
                Utils.toast(this,"委托");
                tv_client_jj.setTextColor(android.graphics.Color.parseColor("#fcb80f"));
                weituo_line.setVisibility(View.VISIBLE);
                tv_client_xm.setTextColor(Color.BLACK);
                wancheng_line.setVisibility(View.GONE);


                myAdapter.setList(list);
                lv.setAdapter(myAdapter);
                break;
            case R.id.wancheng :
                isok = true ;
                Utils.toast(this,"完成");
                tv_client_xm.setTextColor(android.graphics.Color.parseColor("#fcb80f"));
                wancheng_line.setVisibility(View.VISIBLE);
                tv_client_jj.setTextColor(Color.BLACK);
                weituo_line.setVisibility(View.GONE);


                myAdapter.setList(list2);
                lv.setAdapter(myAdapter);
                break;
        }
    }

    class MyAdapter extends BaseAdapter {

        List<ClientJJInfo> list ;

        public List<ClientJJInfo> getList() {
            return list;
        }

        public void setList(List<ClientJJInfo> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
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
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder = null ;
            if (view == null) {
                viewHolder = new ViewHolder();
                view = View.inflate(ClientActivity.this,R.layout.listview_client_jj,null);
                viewHolder.name = (TextView) view.findViewById(R.id.client_jj_name);
                viewHolder.price = (TextView) view.findViewById(R.id.client_jj_price);
                viewHolder.money = (TextView) view.findViewById(R.id.client_jj_money);
                viewHolder.profit = (TextView) view.findViewById(R.id.client_jj_profit);
                viewHolder.time = (TextView) view.findViewById(R.id.client_jj_time);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.name.setText(list.get(i).getName());
            viewHolder.price.setText(list.get(i).getPrice());
            viewHolder.money.setText(list.get(i).getMoney());
            viewHolder.profit.setText(list.get(i).getPrice());
            viewHolder.time.setText(list.get(i).getTime());
            if (!isok) {
                viewHolder.time.setTextColor(Color.WHITE);
            } else {
                viewHolder.time.setBackground(null);
            }


            return view;
        }
    }


    static class ViewHolder {
        TextView name;
        TextView price;
        TextView money;
        TextView profit;
        TextView time;
    }
}

















