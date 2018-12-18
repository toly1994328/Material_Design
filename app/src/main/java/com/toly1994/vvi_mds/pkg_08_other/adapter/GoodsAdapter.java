package com.toly1994.vvi_mds.pkg_08_other.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.toly1994.test.ToastUtil;
import com.toly1994.test.bean.GoodsBean;
import com.toly1994.vvi_mds.R;
import com.toly1994.vvi_mds.pkg_08_other.itf.AdapterItemOp;

import java.util.Collections;
import java.util.List;

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.MyViewHolder> implements AdapterItemOp<GoodsBean> {
    private Context mContext;
    private List<GoodsBean> mData;
    private RecyclerView mRecyclerView;

    public GoodsAdapter(List<GoodsBean> data) {
        mData = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        mRecyclerView = (RecyclerView) parent;
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_goods_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        GoodsBean str = mData.get(position);
        holder.mIdIvGoods.setImageResource(str.getImgId());
        holder.mIdGoodsPrice.setText(str.getPrice() + "");
        holder.mIdIvInfo.setText(str.getInfo());
        holder.mIdGoodsBuyNum.setText(str.getBuyNum() + "人已付款");

        holder.itemView.setOnClickListener(v -> {
            addItem(position, str);
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onItemMove(int from, int to) {
        //交换位置
        ToastUtil.showAtOnce(mContext, "已交换：" + from + "和" + to + "的位置");
        Collections.swap(mData, from, to);
        notifyItemMoved(from, to);//刷新移动数据---将不刷新position
    }

    @Override
    public void onItemDelete(int position) {
        //移除数据
        ToastUtil.showAtOnce(mContext, "已删除：" + position);
        mData.remove(position);
        notifyItemRemoved(position);//刷新移除数据---将不刷新position
    }

    public void addItem(int position, GoodsBean bean) {
        mData.add(position, bean);
        notifyItemInserted(position);//刷新插入数据---将不刷新position
        if (position == 0) {
            mRecyclerView.scrollToPosition(0);
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView mIdIvGoods;
        public TextView mIdYang;
        public TextView mIdGoodsPrice;
        public TextView mIdIvInfo;
        public TextView mIdGoodsBuyNum;
        public ImageView mIdIvBtnMore;

        public MyViewHolder(View itemView) {
            super(itemView);
            mIdIvGoods = itemView.findViewById(R.id.id_iv_goods);
            mIdYang = itemView.findViewById(R.id.id_yang);
            mIdGoodsPrice = itemView.findViewById(R.id.id_goods_price);
            mIdIvInfo = itemView.findViewById(R.id.id_iv_info);
            mIdGoodsBuyNum = itemView.findViewById(R.id.id_goods_buy_num);
            mIdIvBtnMore = itemView.findViewById(R.id.id_iv_btn_more);
        }
    }
}