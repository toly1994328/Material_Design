package com.toly1994.vvi_mds.pkg7_behavior;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.toly1994.test.random.DataUtils;
import com.toly1994.vvi_mds.R;
import com.toly1994.vvi_mds.pkg4_app_coo.ACAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class V09_BehaviorActivity extends AppCompatActivity {

//    @BindView(R.id.abl_top)
//    AppBarLayout mAlTitle;
    @BindView(R.id.rv_content)
    RecyclerView mRvContent;
    @BindView(R.id.id_tv_moving)
    TextView mIdTvMoving;
    private float mTextSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a4_behavior);
        ButterKnife.bind(this);
        ACAdapter ACAdapter = new ACAdapter(this, DataUtils.getRandomName(30, true));
        mRvContent.setAdapter(ACAdapter);
        mRvContent.setLayoutManager(new LinearLayoutManager(this));

//        mAlTitle.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
//            //下降分度
//            float fraction = -verticalOffset * 1.f / (mIdTvMoving.getHeight() - mIdTvMoving.getMinHeight());
//            int color = ColUtils.evaluateColor(fraction, 0xffF07054, 0xff3F51B5);
//            mIdTvMoving.setBackgroundColor(color);//颜色过渡
//            mIdTvMoving.setTextSize(40 * (1 - fraction));//字号缩小
//            mIdTvMoving.setTranslationX(-fraction * mIdTvMoving.getWidth());//X平移
//        });


    }

}
