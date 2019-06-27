package com.stu.zhihu.home;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stu.zhihu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment1 extends Fragment {


    private RecyclerView rec;
    private SwipeRefreshLayout sw;

    public BlankFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment1, container, false);


        initView(view);
        sw.setRefreshing(true);
        sw.setColorSchemeColors(Color.parseColor("#018dff"));
        sw.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sw.setRefreshing(false);
                    }
                }, 500);
            }
        });
        final List<Data1> list = new ArrayList<>();
        for (int i = 90; i < 999; i++) {
            list.add(new Data1("挂科是世界上最恐怖的事情!", "据统计,没10秒就有一个人因挂科死亡据统计,没10秒就有一个人因挂科死亡", i + "赞同 .  " + 206 + i + "评论"));
        }
        list.add(new Data1("挂科是世界上最恐怖的事情!", "据统计,没10秒就有一个人因挂科死亡据统计,没10秒就有一个人因挂科死亡", ""));
        list.add(new Data1("挂科是世界上最恐怖的事情!", "据统计,没10秒就有一个人因挂科死亡据统计,没10秒就有一个人因挂科死亡", ""));
        list.add(new Data1("挂科是世界上最恐怖的事情!", "据统计,没10秒就有一个人因挂科死亡据统计,没10秒就有一个人因挂科死亡", ""));
        list.add(new Data1("挂科是世界上最恐怖的事情!", "据统计,没10秒就有一个人因挂科死亡据统计,没10秒就有一个人因挂科死亡", ""));
        list.add(new Data1("挂科是世界上最恐怖的事情!", "据统计,没10秒就有一个人因挂科死亡据统计,没10秒就有一个人因挂科死亡", ""));

        rec.setLayoutManager(new LinearLayoutManager(getActivity()));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sw.setRefreshing(false);
                rec.setAdapter(new RecyclerView.Adapter() {
                    class ViewHolder extends RecyclerView.ViewHolder {
                        public View rootView;
                        public TextView t1;
                        public TextView t2;
                        public TextView t3;

                        public ViewHolder(View rootView) {
                            super(rootView);
                            this.rootView = rootView;
                            this.t1 = (TextView) rootView.findViewById(R.id.t1);
                            this.t2 = (TextView) rootView.findViewById(R.id.t2);
                            this.t3 = (TextView) rootView.findViewById(R.id.t3);
                        }

                    }

                    @NonNull
                    @Override
                    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                        return new ViewHolder(LayoutInflater.from(getActivity()).inflate(R.layout.item_1, viewGroup, false));
                    }

                    @Override
                    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                        ViewHolder holder = (ViewHolder) viewHolder;
                        holder.t1.setText(list.get(i).getTitle());
                        holder.t2.setText(list.get(i).getContent());
                        holder.t3.setText(list.get(i).getSub());
                    }

                    @Override
                    public int getItemCount() {
                        return list.size();
                    }


                });
            }
        }, 1000);
        return view;
    }

    private void initView(View view) {
        rec = (RecyclerView) view.findViewById(R.id.rec);
        sw = (SwipeRefreshLayout) view.findViewById(R.id.sw);
    }
}
