package com.toly1994.vvi_mds.pkg_08_other.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.toly1994.test.ToastUtil;
import com.toly1994.test.random.ZRandom;
import com.toly1994.vvi_mds.R;
import com.toly1994.vvi_mds.pkg_08_other.itf.AdapterItemOp;

import java.util.Collections;
import java.util.List;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/2 0002:9:22<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：qq信息列表Adapter
 */
public class QQRvAdapter extends RecyclerView.Adapter<MyViewHolder> implements AdapterItemOp<String> {
    private static final String TAG = "TolyRvAdapter";
    private List<String> mData;

    private Context mContext;
    private RecyclerView mRecyclerView;

    public QQRvAdapter(List<String> data) {
        mData = data;
    }

    @NonNull
    @Override//将item布局文件与ViewHolder结合
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        mRecyclerView = (RecyclerView) parent;
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_qq_msg, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        String name = mData.get(position);
        holder.itemView.setOnClickListener(v -> {
            addItem(position, ZRandom.randomCnName());
            ToastUtil.show(mContext, "第" + position + "个:" + name);
        });
        holder.mItemTV.setText(name + "-" + position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onItemMove(int from, int to) {
        //交换位置
        ToastUtil.showAtOnce(mContext, "已交换：" + mData.get(from) + "和" + mData.get(to) + "的位置");
        Collections.swap(mData, from, to);
        notifyItemMoved(from, to);//刷新移动数据---将不刷新position
    }

    @Override
    public void onItemDelete(int position) {
        //移除数据
        ToastUtil.showAtOnce(mContext, "已删除：" + mData.get(position));
        mData.remove(position);
        notifyItemRemoved(position);//刷新移除数据---将不刷新position
    }


    public void addItem(int position, String s) {
        mData.add(position, s);
        notifyItemInserted(position);//刷新插入数据---将不刷新position
        if (position == 0) {
            mRecyclerView.scrollToPosition(0);
        }

    }

    public void removeItem(int position) {
        mData.remove(position);
        notifyItemRemoved(position);//刷新插入数据---将不刷新position
    }

    public void updateItem(int position, String s) {
        mData.set(position, s);
        notifyItemRangeChanged(position, 1);//刷新插入数据---将不刷新position
    }


}
