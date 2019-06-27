package com.stu.zhihu.message;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.stu.zhihu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment1 extends Fragment {


    private SwipeRefreshLayout sw;
    private ListView rec;

    public BlankFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment4, container, false);
        initView(view);

        final List<TongZhiBean> list = new ArrayList<>();
        list.add(new TongZhiBean("@了你", "活着的意义是什么?", "1分钟前"));
        list.add(new TongZhiBean("威威君回答了你的问题", "活着的意义是什么?", "2分钟前"));
        list.add(new TongZhiBean("@了你", "活着的意义是什么?", "1分钟前"));
        list.add(new TongZhiBean("@了你", "活着的意义是什么?", "1分钟前"));
        rec.setAdapter(new BaseAdapter() {
              class ViewHolder {
                public View rootView;
                public TextView q1;
                public TextView q2;
                public TextView q3;

                public ViewHolder(View rootView) {
                    this.rootView = rootView;
                    this.q1 = (TextView) rootView.findViewById(R.id.q1);
                    this.q2 = (TextView) rootView.findViewById(R.id.q2);
                    this.q3 = (TextView) rootView.findViewById(R.id.q3);
                }

            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.item_tongzhi_layout, parent, false);
                ViewHolder holder = new ViewHolder(convertView);
                holder.q1.setText(""+list.get(position).getTitle());
                holder.q2.setText(""+list.get(position).getSubtitle());
                holder.q3.setText(""+list.get(position).getTime());
                return convertView;
            }
        });
        sw.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sw.setRefreshing(false);

                    }
                },500);
            }
        });
        return view;
    }

    private void initView(View view) {

        sw = (SwipeRefreshLayout) view.findViewById(R.id.sw);
        rec = (ListView) view.findViewById(R.id.rec);
    }
}
