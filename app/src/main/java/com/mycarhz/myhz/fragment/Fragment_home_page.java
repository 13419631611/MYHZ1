package com.mycarhz.myhz.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.mycarhz.myhz.R;
import com.mycarhz.myhz.activity.LoginActivity;
import com.mycarhz.myhz.activity.RegisterActivity;
import com.mycarhz.myhz.bean.HomeLunBo;
import com.mycarhz.myhz.bean.Raise;
import com.mycarhz.myhz.constant.Constant;
import com.mycarhz.myhz.ui.PullToRefreshListView;
import com.mycarhz.myhz.utils.Utils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/26.
 */
public class Fragment_home_page extends Fragment implements View.OnClickListener{

    private View m_vFindWorkFragment;
    private PullToRefreshListView lv;
    private List<Raise> list;
    private ViewPager vp;
    private RollPagerView mRollViewPager;

    private PullToRefreshListView ptrList;
    private LinkedList<HomeLunBo> users;


    String URL = "http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg";

    private int[] imgs = {
            R.drawable.bg11,
            R.drawable.bg_3,


            R.drawable.bgbgbg,

    };

    private String[] url = {"http://pic8.nipic.com/20100720/5386129_182916047789_2.jpg",
            "http://c.hiphotos.bdimg.com/album/w%3D2048/sign=a3a806ef6609c93d07f209f7ab05fadc/d50735fae6cd7b89f4ee76620e2442a7d8330e54.jpg",
            "http://img2.imgtn.bdimg.com/it/u=1541753905,926644873&fm=21&gp=0.jpg"
    };

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 3 :
                    myAdapter.notifyDataSetChanged();
                    lv.setRefreshFinish();
                    Utils.toast(getContext(),"下拉刷新");
                    break;
                case 4 :
                    myAdapter.notifyDataSetChanged();
                    lv.setLoadMoreFinish();
                    Utils.toast(getContext(),"上拉刷新");
                    break;
            }
        }
    };


//    private ScrollView scroll;
    private TextView zhuce;
    private TextView denglu;
    private TextView liaojie;
    private MyAdapter myAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //  return super.onCreateView(inflater, container, savedInstanceState);
        m_vFindWorkFragment = inflater.inflate(R.layout.fragment_home_page, container,false);

        initHttp();
        return m_vFindWorkFragment;

    }

    @Override
    public void onStart() {
        super.onStart();
        if (isLogin()) {
        //    denglu.setVisibility(View.INVISIBLE);
        //    zhuce.setVisibility(View.INVISIBLE);
            //denglu.setClickable(false);
            // zhuce.setClickable(false);
        } else {
        //    denglu.setVisibility(View.VISIBLE);
         //   zhuce.setVisibility(View.VISIBLE);
        }
    }


    private void initHttp() {
        String LUNBOTU = Constant.LUNBO;
        RequestParams loginParams = new RequestParams(LUNBOTU);
        x.http().get(loginParams, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String s) {
                Utils.toast(getContext(),s);
                Log.i("test","11111111111111111"+s);
                Type listType = new TypeToken<LinkedList<HomeLunBo>>(){}.getType();
                Gson gson = new Gson();
                users = gson.fromJson(s, listType);
                Log.i("123!!!!!","3333333"+users.get(1).getCompanyImg());
//                users.get(1).getCompanyImg();
//                for (Iterator iterator = users.iterator(); iterator.hasNext();) {
//                    HomeLunBo user = (HomeLunBo) iterator.next();
//                    System.out.println(user.getCompanyName());
//                    System.out.println(user.getCompanyImg());
//                    Log.i("123!!!!!","!!"+iterator+user.getCompanyImg());
//                }
                init();
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
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.i("test","00000000000000000000000000000000000000000000000");
    }



    private void init() {
  //      lv =   (ListView) m_vFindWorkFragment.findViewById(R.id.lv);
  //      scroll = (ScrollView) m_vFindWorkFragment.findViewById(R.id.scroll);
        lv = (PullToRefreshListView) m_vFindWorkFragment.findViewById(R.id.lv);




        View view = LayoutInflater.from(getContext()).inflate(R.layout.page_home_header, null);
        liaojie = (TextView) view.findViewById(R.id.liaojie);

        list = new ArrayList();

        for (int i = 0 ; i < 20 ; i++) {
            list.add(new Raise("蚂蚁合众第"+i+"期众筹项目丰田凯美瑞", 180000, i, i, 95000));

        }
        denglu = (TextView) m_vFindWorkFragment.findViewById(R.id.denglu);
        zhuce = (TextView) m_vFindWorkFragment.findViewById(R.id.zhuce);
        mRollViewPager = (RollPagerView) view.findViewById(R.id.roll_view_pager);
        denglu.setOnClickListener(this);
        zhuce.setOnClickListener(this);
        liaojie.setOnClickListener(this);
        lv.addHeaderView(view);
        myAdapter = new MyAdapter();
        lv.setAdapter(myAdapter);




  //      scroll.smoothScrollTo(0,20);
 //       scroll.setFocusable(false);
        lv.setFocusable(true);
        initScroll();

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



                        Message message = new Message();
                        //发送消息与处理函数里一致
                        message.what = 3;
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
                        message.what = 4;
                        //内部类调用外部类的变量
                        handler.sendMessage(message);
                    }
                }).start();
            }
        });

    }




    private void initScroll() {
        //设置播放时间间隔
        mRollViewPager.setPlayDelay(3000);
        //设置透明度
        mRollViewPager.setAnimationDurtion(500);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());

        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        mRollViewPager.setHintView(new ColorPointHintView(getContext(), Color.YELLOW,Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.zhuce :
                Log.i("test","===========================注册==========================");
                Intent intent = new Intent(getContext(), RegisterActivity.class);
                startActivity(intent);

                break;
            case R.id.denglu :
                Log.i("test","===========================登录==========================");
                intent = new Intent(getContext(),LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.liaojie:
                Log.i("test","===========================我要了解蚂蚁注册==========================");
                break;
        }
    }


    private class TestNormalAdapter extends StaticPagerAdapter {


        @Override
        public View getView(ViewGroup container, final int position) {
            ImageView view = new ImageView(container.getContext());
          //  view.setImageResource(imgs[position]);
            view.setImageResource(users.size());
//            Glide.with(Fragment_home_page.this).load(url[position]).into(view);
            Glide.with(Fragment_home_page.this).load(Constant.BASE+users.get(position).getCompanyImg()).into(view);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("test","==========================轮播图详情"+position+"===================================");
                }
            });

            return view;
        }


        @Override
        public int getCount() {
            return users.size();
        }

    }

    class MyAdapter extends BaseAdapter {

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
        public View getView(final int i, View view, ViewGroup viewGroup) {
            Viewholder viewholder = null;
            if (view == null) {
                viewholder = new Viewholder();
                view = View.inflate(getContext(),R.layout.listview_homepager,null);
                viewholder.title = (TextView) view.findViewById(R.id.tv_title);
                viewholder.money = (TextView) view.findViewById(R.id.money);
                viewholder.pb = (ProgressBar) view.findViewById(R.id.pb);
                viewholder.percentage = (TextView) view.findViewById(R.id.percentage);
                viewholder.no_money = (TextView) view.findViewById(R.id.no_money);
                viewholder.people = (TextView) view.findViewById(R.id.people);
                viewholder.iv = (ImageView) view.findViewById(R.id.iv);

                view.setTag(viewholder);
            } else {
                viewholder = (Viewholder) view.getTag();
            }

            viewholder.title.setText(list.get(i).getTitle());
            viewholder.money.setText(list.get(i).getMoney()+"");
            viewholder.percentage.setText(list.get(i).getPb()+"");
            viewholder.no_money.setText(list.get(i).getNo_money()+"");
            viewholder.people.setText(list.get(i).getPeople()+"");
            viewholder.pb.setProgress(list.get(i).getPb());



            Glide.with(Fragment_home_page.this).load(URL).into(viewholder.iv);




            return view;
        }
    }
    public boolean isLogin() {
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("user", getContext().MODE_PRIVATE);
        String uid = sharedPreferences.getString("uid", "");
        if ("".equals(uid)){
            Toast.makeText(getActivity(),"你还没有登录喔!",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;

    }


    static class Viewholder {
        TextView title;
        TextView money;
        TextView people;
        ProgressBar pb;
        TextView percentage;
        TextView no_money;
        ImageView iv;

    }







}
