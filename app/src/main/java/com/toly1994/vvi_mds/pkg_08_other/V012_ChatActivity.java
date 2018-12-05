package com.toly1994.vvi_mds.pkg_08_other;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.toly1994.test.bean.BeanFactory;
import com.toly1994.vvi_mds.R;
import com.toly1994.vvi_mds.pkg_08_other.adapter.ChatRvAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class V012_ChatActivity extends AppCompatActivity {

    @BindView(R.id.id_rv_content)
    RecyclerView mIdRvContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a12_swipe_refresh);
        ButterKnife.bind(this);

        mIdRvContent.setAdapter(new ChatRvAdapter(BeanFactory.getMsgBeans()));
        mIdRvContent.setLayoutManager(new LinearLayoutManager(this));

    }

}
