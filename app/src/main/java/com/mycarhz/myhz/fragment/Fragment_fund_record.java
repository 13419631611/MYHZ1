package com.mycarhz.myhz.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mycarhz.myhz.R;
import com.mycarhz.myhz.bean.MoneyInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/26.
 */
public class Fragment_fund_record extends Fragment {
    private View m_vFindWorkFragment;
    private TextView zhuce;
    private TextView denglu;
    private ListView lv;
    private List<MoneyInfo> list;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //  return super.onCreateView(inflater, container, savedInstanceState);
        m_vFindWorkFragment = inflater.inflate(R.layout.fragment_fund_record, container,false);

        return m_vFindWorkFragment;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initDate();
        init();
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    private void init() {
        zhuce = (TextView) m_vFindWorkFragment.findViewById(R.id.zhuce);
        denglu = (TextView) m_vFindWorkFragment.findViewById(R.id.denglu);
        zhuce.setText("资金记录");
        denglu.setVisibility(View.GONE);
        lv = (ListView) m_vFindWorkFragment.findViewById(R.id.lv);
        MyAdapter myAdapter = new MyAdapter(list);
        lv.setAdapter(myAdapter);
    }

    private void initDate() {
        list = new ArrayList<>();
        for (int i = 0 ; i < 100 ; i++ ) {
            list.add(new MoneyInfo("2016-08-25","富友支付","15341元","众筹项目"));
        }
    }

    class MyAdapter extends BaseAdapter {

        List<MoneyInfo> list;

        public MyAdapter(List<MoneyInfo> list) {

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
                view = View.inflate(getContext(), R.layout.listview_money, null);
                viewholder.fund_date = (TextView) view.findViewById(R.id.fund_date);
                viewholder.fund_type = (TextView) view.findViewById(R.id.fund_type);
                viewholder.fund_money = (TextView) view.findViewById(R.id.fund_money);
                viewholder.fund_xm = (TextView) view.findViewById(R.id.fund_xm);
                view.setTag(viewholder);
            } else {
                viewholder = (Viewholder) view.getTag();
            }

            viewholder.fund_date.setText(list.get(i).getDate());
            viewholder.fund_type.setText(list.get(i).getType());
            viewholder.fund_money.setText(list.get(i).getMoney());
            viewholder.fund_xm.setText(list.get(i).getShuoming());


            return view;
        }


    }
    class Viewholder {
        TextView fund_date;
        TextView fund_type;
        TextView fund_money;
        TextView fund_xm;

    }

}



















