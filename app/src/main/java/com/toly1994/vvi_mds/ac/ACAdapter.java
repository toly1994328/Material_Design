package com.toly1994.vvi_mds.ac;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.toly1994.vvi_mds.R;

import java.util.List;

public class ACAdapter extends RecyclerView.Adapter<ACAdapter.MyViewHolder> {
    private Context mContext;
    private List<String> mData;

    public ACAdapter(Context context, List<String> data) {
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_of_base, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mIdItemName.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mIdItemName;
        public CardView mCvContent;
        public TextView mIdItemInfo;
        public ImageView mIdItemMore;

        public MyViewHolder(View itemView) {
            super(itemView);
            mIdItemName = itemView.findViewById(R.id.id_item_name);
            mCvContent = itemView.findViewById(R.id.cv_content);
            mIdItemInfo = itemView.findViewById(R.id.id_item_info);
            mIdItemMore = itemView.findViewById(R.id.id_item_more);
        }
    }
}