package com.toly1994.vvi_mds.pkg_08_other;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.toly1994.test.ToastUtil;
import com.toly1994.test.random.DataUtils;
import com.toly1994.test.random.ZRandom;
import com.toly1994.vvi_mds.R;
import com.toly1994.vvi_mds.pkg_08_other.adapter.QQRvAdapter;
import com.toly1994.test.bean.MsgBean;
import com.toly1994.vvi_mds.pkg_08_other.decoration.RVItemDivider;
import com.toly1994.vvi_mds.pkg_08_other.itf.ItemTouchCallback;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class V012_SwipeRefreshActivity extends AppCompatActivity {

    @BindView(R.id.id_rv_content)
    RecyclerView mIdRvContent;
    @BindView(R.id.id_srl)
    SwipeRefreshLayout mIdSrl;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            ToastUtil.showAtOnce(
                    V012_SwipeRefreshActivity.this, "setOnRefreshListener");
            if (mIdSrl.isRefreshing()) {
                //关闭刷新动画
                mIdSrl.setRefreshing(false);
                mACAdapter.notifyDataSetChanged();
            }
        }
    };
    private QQRvAdapter mACAdapter;
    private ArrayList<String> mData;
    private ArrayList<MsgBean> mMsgData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a12_swipe_refresh);
        ButterKnife.bind(this);
//        mData = DataUtils.getRandomName(60, true);
        mData = DataUtils.getRandomChar(60, 60);

        mIdRvContent.addItemDecoration(new RVItemDivider(this, RVItemDivider.Type.VERTICAL,R.drawable.shape_div));
//        mACAdapter = new JianshuRvAdapter(mData);
        mACAdapter = new QQRvAdapter(DataUtils.getRandomName(5, true));
        //实例化ItemTouchHelper
        ItemTouchHelper touchHelper = new ItemTouchHelper(new ItemTouchCallback(mACAdapter));
//调用ItemTouchHelper的attachToRecyclerView方法建立联系
        touchHelper.attachToRecyclerView(mIdRvContent);

        for (int i = 0; i < 60; i++) {
            mMsgData.add(new MsgBean(ZRandom.rangeInt(0, 1), ZRandom.randomChar(500)));
        }
//
//        mACAdapter = new ChatRvAdapter(mMsgData);
        mIdRvContent.setAdapter(mACAdapter);
        mIdRvContent.setLayoutManager(new LinearLayoutManager(this));
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
            mHandler.sendEmptyMessageDelayed(0, 7000);
        });
    }
}
