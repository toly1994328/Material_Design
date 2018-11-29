package com.toly1994.vvi_mds.v01_tab;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.toly1994.test.common.DataUtils;
import com.toly1994.test.common.ZRandom;
import com.toly1994.vvi_mds.R;

import java.util.ArrayList;
import java.util.List;

public class V01_TabLayoutActivity extends AppCompatActivity {

    private TabLayout mTabTl;
    private ViewPager mContentVp;

    private List<Fragment> tabFragments;
    private FragmentPagerAdapter contentAdapter;
    private TabLayout mBottomTabTl;

    private List<String> tabIndicators;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a01_tablayout);

        mContentVp = findViewById(R.id.vp_content);
        //上面的TabLayout
        mTabTl = findViewById(R.id.tl_top_tab);
        //下面的TabLayout
        mBottomTabTl = findViewById(R.id.tl_bottom_tab);

        initContent();
        initTab();
        initBottomTab();
    }

    private void initBottomTab() {
        mBottomTabTl.setTabMode(TabLayout.MODE_FIXED);
        String[] bottomStr = new String[]{"热点", "首页", "创作", "动态", "我"};
        //去除下面线
        mBottomTabTl.setSelectedTabIndicatorHeight(0);
        ViewCompat.setElevation(mBottomTabTl, 10);
        mBottomTabTl.setupWithViewPager(mContentVp);
        for (int i = 0; i < tabIndicators.size(); i++) {
            //获取Tab对应条目
            TabLayout.Tab itemTab = mBottomTabTl.getTabAt(i);
            if (itemTab != null) {
                //自定义布局加到对应条目上
                itemTab.setCustomView(R.layout.item_01_bottom);
                TextView itemTv = itemTab.getCustomView().findViewById(R.id.tv_menu_item);
                itemTv.setText(bottomStr[i]);
            }
        }
    }

    private void initContent() {
        tabIndicators = DataUtils.getRandomName(5, true);
        tabFragments = new ArrayList<>();
        for (String s : tabIndicators) {
            tabFragments.add(V01_ContentV4Fragment.newInstance(s));
        }
        //创建适配器对象
        contentAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return tabFragments.get(position);
            }

            @Override
            public int getCount() {
                return tabIndicators.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabIndicators.get(position);
            }
        };
        //为ViewPager设置适配器
        mContentVp.setAdapter(contentAdapter);
    }

    private void initTab() {
        //MODE_FIXED:均匀分布,排不下挤一挤
        //MODE_SCROLLABLE:可以滑动,从左向右排
        mTabTl.setTabMode(TabLayout.MODE_FIXED);
        mTabTl.setBackgroundColor(Color.WHITE);
        //设置颜色：(未选中的,选中的)
        mTabTl.setTabTextColors(Color.GRAY, Color.BLACK);
        //设置指示器的颜色
        mTabTl.setSelectedTabIndicatorColor(0xffFF7F47);
        //设置底线高
        mTabTl.setSelectedTabIndicatorHeight(2);
        //设置阴影
        ViewCompat.setElevation(mTabTl, 5);

        //TabLayout设置mContentVp
        mTabTl.setupWithViewPager(mContentVp);
    }


    //菜单栏点击
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tab_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tab_add:
                //创建随机名字
                String addName = ZRandom.randomCnName();
                //Fragment集合增加
                tabFragments.add(V01_ContentV4Fragment.newInstance(addName));
                //刷新，
                contentAdapter.notifyDataSetChanged();
                mTabTl.setupWithViewPager(mContentVp);
                return true;

            case R.id.tab_mode_fixed:
                mTabTl.setTabMode(TabLayout.MODE_FIXED);
                return true;

            case R.id.tab_mode_scrollable:
                mTabTl.setTabMode(TabLayout.MODE_SCROLLABLE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
