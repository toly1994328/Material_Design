package com.toly1994.vvi_mds.app.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.toly1994.vvi_mds.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/11/25 0025:10:50<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：
 */
public class HomeActivity extends AppCompatActivity {

    private List<Integer> mData = new ArrayList<>();
    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mData.add(R.mipmap.md_toolbar);
        mData.add(R.mipmap.md_cardview);

        mData.add(R.mipmap.fsb);

        mData.add(R.mipmap.md_bnb);
        mData.add(R.mipmap.md_tablayout);

        mData.add(R.mipmap.ac);

        mData.add(R.mipmap.collapsingtoolbarlayout_palette);

        mData.add(R.mipmap.md_dnt);
        mData.add(R.mipmap.md_behavior);

        setContentView(R.layout.activity_home);

        mRecyclerView = findViewById(R.id.id_rv);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(new HomeRVAdapter(this, mData));
    }
}
