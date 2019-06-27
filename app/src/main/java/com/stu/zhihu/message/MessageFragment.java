package com.stu.zhihu.message;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stu.zhihu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {


    private TabLayout tabmessage;
    private ViewPager vp;

    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);


/*        sw.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        sw.setRefreshing(false);
                    }
                },800);
            }
        });*/

        initView(view);
        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new BlankFragment1());
        fragments.add(new BlankFragment1());
        vp.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return position==0?"通知":"私信";
            }
        });

        tabmessage.setupWithViewPager(vp);
        return view;
    }


    private void initView(View view) {
        tabmessage = (TabLayout) view.findViewById(R.id.tabmessage);
        vp = (ViewPager) view.findViewById(R.id.vp);
    }
}
