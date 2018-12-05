package com.toly1994.vvi_mds.pkg_08_other;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.toly1994.test.bean.BeanFactory;
import com.toly1994.vvi_mds.R;
import com.toly1994.vvi_mds.pkg_08_other.adapter.GridAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class V012_GridActivity extends AppCompatActivity {


    @BindView(R.id.id_rv_goods)
    RecyclerView mIdRvGoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv_goods);
        ButterKnife.bind(this);

        mIdRvGoods.setAdapter(new GridAdapter(BeanFactory.getIconsInfo()));
        //一排4个,竖直排列
        mIdRvGoods.setLayoutManager(
                new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false));

    }

}
