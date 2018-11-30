package com.toly1994.vvi_mds.pkg3_bnb_tab;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.toly1994.test.L;
import com.toly1994.test.ToastUtil;
import com.toly1994.test.common.DataUtils;
import com.toly1994.vvi_mds.R;
import com.toly1994.vvi_mds.pkg4_app_coo.ACAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class V04_BottomNavigationBarActivity extends AppCompatActivity {


    @BindView(R.id.id_bnb)
    BottomNavigationBar mIdBnb;
    @BindView(R.id.id_root_cl_bnb)
    CoordinatorLayout mIdRootClBnb;
    @BindView(R.id.id_rv_bnb)
    RecyclerView mIdRvBnb;

    private boolean isShow = true;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.v09_bnb);
        ButterKnife.bind(this);


        bnbInit();
        bnbAction();

        rvInit();
    }

    private void rvInit() {
        ACAdapter ACAdapter = new ACAdapter(this, DataUtils.getRandomName(40, true));
        mIdRvBnb.setAdapter(ACAdapter);
        mIdRvBnb.setLayoutManager(new LinearLayoutManager(this));
    }

    private void bnbInit() {
        mIdBnb.addItem(new BottomNavigationItem(R.drawable.icon_a, "about")
                .setActiveColorResource(R.color.feise));
        mIdBnb.addItem(
                new BottomNavigationItem(R.drawable.icon_b, "before")
                        .setActiveColorResource(R.color.yase));
        mIdBnb.addItem(
                new BottomNavigationItem(R.drawable.icon_c, "card")
                        .setActiveColorResource(R.color.jietelan));
        mIdBnb.addItem(
                new BottomNavigationItem(R.drawable.icon_d, "dall")
                        .setActiveColorResource(R.color.zhuqing));
        mIdBnb.addItem(
                new BottomNavigationItem(R.drawable.icon_e, "element")
                        .setActiveColorResource(R.color.yuebai)
                        .setBadgeItem(new BadgeItem()
                                .setBackgroundColorResource(android.R.color.holo_red_dark) //设置角标背景色
                                .setText("99") //设置角标的文字
                                .setTextColorResource(android.R.color.white) //设置角标文字颜色
                                .setHideOnSelect(true) //在选中时是否隐藏角标
                        )
        );
        //5.初始化
        mIdBnb.setFirstSelectedPosition(2).initialise();
    }

    private void bnbAction() {
        mIdBnb.selectTab(3);
        mIdBnb.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                ToastUtil.showAtOnce(V04_BottomNavigationBarActivity.this, "第" + position + "个");
            }

            @Override
            public void onTabUnselected(int position) {
                L.d("setTabSelectedListener:" + position + L.l());
            }

            @Override
            public void onTabReselected(int position) {
                L.d("onTabReselected:" + position + L.l());

            }
        });
    }


//    @OnClick(R.id.id_root_cl_bnb)
//    public void onViewClicked() {
//        if (isShow) {
//            mIdBnb.hide(true);
//        } else {
//            mIdBnb.unHide(true);
//        }
//        isShow = !isShow;
//    }
}
