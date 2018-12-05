package com.toly1994.vvi_mds.pkg_08_other.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.toly1994.test.ToastUtil;
import com.toly1994.vvi_mds.R;

import java.util.List;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/2 0002:9:22<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：
 */
public class JianshuRvAdapter extends RecyclerView.Adapter<JianshuRvAdapter.MyViewHolder> {
    private static final String TAG = "TolyRvAdapter";
    private List<String> mData;

    private Context mContext;

    public JianshuRvAdapter(List<String> data) {
        mData = data;
    }

    @NonNull
    @Override//将item布局文件与ViewHolder结合
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_jianshu_article, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.mItemTV.setText(mData.get(position) + "-" + position);


        holder.itemView.setOnClickListener(v -> {
            ToastUtil.show(mContext, "第" + position);
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * ViewHolder
     */
    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mItemTV;

        public MyViewHolder(View itemView) {
            super(itemView);
            mItemTV = itemView.findViewById(R.id.id_item_article_title);
        }
    }
}
