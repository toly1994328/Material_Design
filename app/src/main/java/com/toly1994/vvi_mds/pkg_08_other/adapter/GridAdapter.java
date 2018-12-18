package com.toly1994.vvi_mds.pkg_08_other.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.toly1994.test.bean.IconInfo;
import com.toly1994.vvi_mds.R;

import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MyViewHolder> {
    private Context mContext;
    private List<IconInfo> mData;

    public GridAdapter(List<IconInfo> data) {
        mData = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_img_txt, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        IconInfo info = mData.get(position);
        holder.mIdIvIcon.setImageResource(info.getIcon());
        holder.mIdIvInfo.setText(info.getInfo());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView mIdIvIcon;
        public TextView mIdIvInfo;

        public MyViewHolder(View itemView) {
            super(itemView);
            mIdIvIcon = itemView.findViewById(R.id.id_iv_icon);
            mIdIvInfo = itemView.findViewById(R.id.id_iv_info);
        }
    }
}