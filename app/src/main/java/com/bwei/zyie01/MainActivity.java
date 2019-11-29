package com.bwei.zyie01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RadioGroup group;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取资源ID
        group = findViewById(R.id.group);
        viewpager = findViewById(R.id.viewpager);
        //创建集合
        final ArrayList<Fragment> list = new ArrayList<>();
        //创建数组
        OneFragment oneFragment = new OneFragment();
        list.add(oneFragment);
        TwoFragment twoFragment = new TwoFragment();
        list.add(twoFragment);
        ThreeFragment threeFragment = new ThreeFragment();
        list.add(threeFragment);
        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        //点击切换
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case  R.id.but1:
                        viewpager.setCurrentItem(0);
                        break;
                    case  R.id.but2:
                        viewpager.setCurrentItem(1);
                        break;
                    case  R.id.but3:
                        viewpager.setCurrentItem(2);
                        break;
                }
            }
        });
        //滑动切换
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                    group.check(group.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    public void  jump(){
        viewpager.setCurrentItem(2);
    }
}
