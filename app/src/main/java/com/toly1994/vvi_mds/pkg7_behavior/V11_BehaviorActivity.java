package com.toly1994.vvi_mds.pkg7_behavior;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.toly1994.test.random.DataUtils;
import com.toly1994.vvi_mds.R;
import com.toly1994.vvi_mds.pkg4_app_coo.ACAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class V11_BehaviorActivity extends AppCompatActivity {
    @BindView(R.id.rv_content)
    RecyclerView mRvContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a4_behavior_3);
        ButterKnife.bind(this);
        ACAdapter ACAdapter = new ACAdapter(this, DataUtils.getRandomName(60, true));
        mRvContent.setAdapter(ACAdapter);
        mRvContent.setLayoutManager(new LinearLayoutManager(this));


    }

}
