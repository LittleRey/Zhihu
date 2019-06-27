package com.stu.zhihu;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.stu.zhihu.home.HomeFragment;
import com.stu.zhihu.message.MessageFragment;
import com.stu.zhihu.my.MyFragment;
import com.stu.zhihu.vip.VipFragment;

public class MainActivity extends AppCompatActivity {


    private FrameLayout fragment;
    private BottomNavigationView bottomnavigationview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        MenuItem home1 = bottomnavigationview.getMenu().findItem(R.id.navigationzx);
        //home1.setIconTintList(null);
        // home1.setIcon(R.mipmap.a1);
        // startActivity(new Intent(this,Main3Activity.class));
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new HomeFragment()).commit();
        //  resetToDefaultIcon();
        int[][] states = new int[][]{new int[]{-android.R.attr.state_checked}, new int[]{android.R.attr.state_checked}};
        //int[] colors = new int[]{ getResources().getColor(R.color.checked_color),  getResources().getColor(R.color.uncheck_color) };
        // ColorStateList csl = new ColorStateList(states, colors);
        bottomnavigationview.setItemIconTintList(null);//.去掉不显示图片默认颜色：
        bottomnavigationview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //resetToDefaultIcon();
                switch (menuItem.getItemId()) {
                    case R.id.navigation1:
                        getWindow().setStatusBarColor(0xffedf1f4);
                        // menuItem.setIcon(R.mipmap.a1_select);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new HomeFragment()).commit();
                        break;
                    case R.id.navigation2:
                        getWindow().setStatusBarColor(0xffedf1f4);
                        //  menuItem.setIcon(R.mipmap.a2);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new VipFragment()).commit();
                        break;
                    case R.id.navigation3:
                        // menuItem.setIcon(R.mipmap.a3);
                        getWindow().setStatusBarColor(0xffedf1f4);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new MessageFragment()).commit();
                        break;
                    case R.id.navigation4:
                        //  menuItem.setIcon(R.mipmap.a4);
                        getWindow().setStatusBarColor(0xff1296db);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new MyFragment()).commit();
                        break;
                }
                return false;
            }

        });
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomnavigationview.getChildAt(0);
        final View iconView = menuView.getChildAt(2).findViewById(android.support.design.R.id.icon);
        final ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
        final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, displayMetrics);
        layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, displayMetrics);
        iconView.setLayoutParams(layoutParams);
        bottomnavigationview.setLabelVisibilityMode(1);
    }


    private void initView() {
        fragment = (FrameLayout) findViewById(R.id.fragment);
        bottomnavigationview = (BottomNavigationView) findViewById(R.id.bottomnavigationview);
    }

    private void resetToDefaultIcon() {
        MenuItem home1 = bottomnavigationview.getMenu().findItem(R.id.navigation1);
        home1.setIcon(R.mipmap.a1);
        MenuItem home2 = bottomnavigationview.getMenu().findItem(R.id.navigation2);
        home2.setIcon(R.mipmap.a2);
        MenuItem home3 = bottomnavigationview.getMenu().findItem(R.id.navigation3);
        home3.setIcon(R.mipmap.a3);
        MenuItem home4 = bottomnavigationview.getMenu().findItem(R.id.navigation4);
        home4.setIcon(R.mipmap.a4);
        MenuItem zx = bottomnavigationview.getMenu().findItem(R.id.navigationzx);

    }
}
