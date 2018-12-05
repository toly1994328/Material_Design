package com.toly1994.vvi_mds.pkg_08_other;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.toly1994.test.bean.BeanFactory;
import com.toly1994.vvi_mds.R;
import com.toly1994.vvi_mds.pkg_08_other.adapter.GoodsAdapter;
import com.toly1994.vvi_mds.pkg_08_other.animator.RItemAnimator;
import com.toly1994.vvi_mds.pkg_08_other.itf.ItemTouchCallback;

import butterknife.BindView;
import butterknife.ButterKnife;

public class V012_GoodsActivity extends AppCompatActivity {


    @BindView(R.id.id_rv_goods)
    RecyclerView mIdRvGoods;
    private GoodsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv_goods);
        ButterKnife.bind(this);

        mAdapter = new GoodsAdapter(BeanFactory.getGoodsBean());
        //实例化ItemTouchHelper
        ItemTouchHelper touchHelper = new ItemTouchHelper(new ItemTouchCallback(mAdapter));
//调用ItemTouchHelper的attachToRecyclerView方法建立联系
        touchHelper.attachToRecyclerView(mIdRvGoods);

        mIdRvGoods.setAdapter(mAdapter);
//        mIdRvGoods.setItemAnimator(new FadeItemAnimator());
        mIdRvGoods.setItemAnimator(new RItemAnimator());
        //边线相关
//        mIdRvGoods.addItemDecoration(new RVItemDivider(this, RVItemDivider.Type.HORIZONTAL,10,Color.BLACK));
//        mIdRvGoods.addItemDecoration(new RVItemDivider(this, RVItemDivider.Type.HORIZONTAL));
//        mIdRvGoods.addItemDecoration(new RVItemDivider(this, RVItemDivider.Type.BOTH,R.drawable.shape_div));
//        mIdRvGoods.addItemDecoration(new RVItemDivider(this, RVItemDivider.Type.BOTH,10,Color.BLACK));

//        //线性流
//        mIdRvGoods.setLayoutManager(new LinearLayoutManager(this));
//        //网格流：一排4个,竖直排列
//        mIdRvGoods.setLayoutManager(
//                new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        //瀑布流：一排两个,竖直排列
        mIdRvGoods.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));


    }

}
