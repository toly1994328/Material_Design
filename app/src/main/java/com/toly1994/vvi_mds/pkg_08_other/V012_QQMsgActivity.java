package com.toly1994.vvi_mds.pkg_08_other;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;

import com.toly1994.test.ToastUtil;
import com.toly1994.test.random.DataUtils;
import com.toly1994.test.random.ZRandom;
import com.toly1994.vvi_mds.R;
import com.toly1994.vvi_mds.pkg_08_other.adapter.QQRvAdapter;
import com.toly1994.vvi_mds.pkg_08_other.animator.RItemAnimator;
import com.toly1994.vvi_mds.pkg_08_other.decoration.RVItemDivider;
import com.toly1994.vvi_mds.pkg_08_other.itf.ItemTouchCallback;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class V012_QQMsgActivity extends AppCompatActivity {

    @BindView(R.id.id_rv_content)
    RecyclerView mIdRvContent;
    @BindView(R.id.id_srl)
    SwipeRefreshLayout mIdSrl;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            ToastUtil.showAtOnce(
                    V012_QQMsgActivity.this, "setOnRefreshListener");
            if (mIdSrl.isRefreshing()) {
                //关闭刷新动画
                mIdSrl.setRefreshing(false);
                mACAdapter.notifyDataSetChanged();
            }
        }
    };
    private QQRvAdapter mACAdapter;
    private ArrayList<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a12_swipe_refresh);
        ButterKnife.bind(this);

        mData = DataUtils.getRandomName(5, true);
        mIdRvContent.addItemDecoration(new RVItemDivider(this, RVItemDivider.Type.BOTH));
//        mIdRvContent.addItemDecoration(new RVItemDivider(this, LinearLayoutManager.HORIZONTAL));
        mACAdapter = new QQRvAdapter(mData);

        //实例化ItemTouchHelper
        ItemTouchHelper touchHelper = new ItemTouchHelper(new ItemTouchCallback(mACAdapter));
        //调用ItemTouchHelper的attachToRecyclerView方法建立联系
        touchHelper.attachToRecyclerView(mIdRvContent);

//        mIdRvContent.setItemAnimator(new FadeItemAnimator());
//        mIdRvContent.setItemAnimator(new DefaultItemAnimator());
        mIdRvContent.setItemAnimator(new RItemAnimator());
//        mIdRvContent.setItemAnimator(new ScaleItemAnimator());
//        mIdRvContent.setItemAnimator(new SlideItemAnimator());
//        mIdRvContent.setItemAnimator(new RotateItemAnimator());

        mIdRvContent.setAdapter(mACAdapter);
        mIdRvContent.setLayoutManager(new LinearLayoutManager(this));

        //        //网格流：一排4个,竖直排列
//        mIdRvGoods.setLayoutManager(
//                new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        //瀑布流：一排两个,竖直排列
//        mIdRvContent.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        srl();
    }

    private void srl() {
        //每转一圈，换一种颜色
        mIdSrl.setColorSchemeColors(
                0xffF60C0C,//红
                0xffF3B913,//橙
                0xffE7F716,//黄
                0xff3DF30B,//绿
                0xff0DF6EF,//青
                0xff0829FB,//蓝
                0xffB709F4//紫
        );
        //背景色
        mIdSrl.setProgressBackgroundColorSchemeResource(R.color.yuebai);
        mIdSrl.setOnRefreshListener(() -> {
            mData.add(0, ZRandom.randomCnName());
            mHandler.sendEmptyMessageDelayed(0, 5000);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tool_bar_op, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tab_add:
                mACAdapter.addItem(2, "张风捷特烈");
                break;
            case R.id.tab_remove:
                mACAdapter.removeItem(3);
                break;
            case R.id.tab_refresh:
                mACAdapter.updateItem(4, "龙少");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
