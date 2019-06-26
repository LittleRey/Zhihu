package com.stu.zhihu;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private ListView llll;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        final List<Goods> list = new ArrayList<>();
        list.add(new Goods("苹果", R.mipmap.ic_launcher));
        list.add(new Goods("苹果qq", R.mipmap.a1));
        list.add(new Goods("苹wew2qe果", R.mipmap.a1_select));
        list.add(new Goods("苹24234果", R.mipmap.a4));
        list.add(new Goods("苹24234果", R.mipmap.ic_launcher));
        list.add(new Goods("苹果", R.mipmap.ic_launcher));
        list.add(new Goods("苹2434果", R.mipmap.ic_launcher));
        list.add(new Goods("苹242424果", R.mipmap.ic_launcher));
        list.add(new Goods("苹24344果", R.mipmap.ic_launcher));
        list.add(new Goods("苹2424果", R.mipmap.ic_launcher));
        list.add(new Goods("苹22424果", R.mipmap.ic_launcher));


        llll.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int position) {
                return list.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //  convertView  = new TextView(context);
                convertView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
                Goods goods = list.get(position);
              //  ((TextView) convertView).setText(goods.getName());
                TextView textView = convertView.findViewById(R.id.name);
                textView.setText(goods.getName());

               ImageView imageView = convertView.findViewById(R.id.img);
               imageView.setBackgroundResource(goods.getImg());

                return convertView;
            }
        });
    }

    private void initView() {
        llll = (ListView) findViewById(R.id.llll);
    }
}
