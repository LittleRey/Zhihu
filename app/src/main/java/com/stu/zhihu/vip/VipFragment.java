package com.stu.zhihu.vip;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stu.zhihu.R;
import com.stu.zhihu.ViewUtils;

import net.lucode.hackware.magicindicator.MagicIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class VipFragment extends Fragment {


    private MagicIndicator tab;
    private ViewPager vp;

    public VipFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vip, container, false);
        initView(view);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new BlankFragmentvip1());
        fragments.add(new BlankFragmentvip1());
        fragments.add(new BlankFragmentvip1());
        fragments.add(new BlankFragmentvip1());
        String[] strings = {"会员推荐","读书会","私家课","Live讲座"};

        ViewUtils.initVP(vp,fragments,getChildFragmentManager());
        ViewUtils.init(tab,vp,fragments,strings,getActivity());

        return view;
    }

    private void initView(View view) {
        tab = (MagicIndicator) view.findViewById(R.id.tab);
        vp = (ViewPager) view.findViewById(R.id.vp);
    }
}
