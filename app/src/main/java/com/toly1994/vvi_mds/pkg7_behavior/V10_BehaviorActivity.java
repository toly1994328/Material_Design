package com.toly1994.vvi_mds.pkg7_behavior;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.toly1994.test.random.DataUtils;
import com.toly1994.vvi_mds.R;
import com.toly1994.vvi_mds.pkg4_app_coo.ACAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class V10_BehaviorActivity extends AppCompatActivity {
    @BindView(R.id.rv_content)
    RecyclerView mRvContent;
    @BindView(R.id.id_fab_b)
    FloatingActionButton mIdFabB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a4_behavior_2);
        ButterKnife.bind(this);
        ACAdapter ACAdapter = new ACAdapter(this, DataUtils.getRandomName(60, true));
        mRvContent.setAdapter(ACAdapter);
        mRvContent.setLayoutManager(new LinearLayoutManager(this));


    }

    @OnClick(R.id.id_fab_b)
    public void onViewClicked() {
    }
}
