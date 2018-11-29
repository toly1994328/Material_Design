package com.toly1994.vvi_mds.app.home;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.toly1994.vvi_mds.R;
import com.toly1994.vvi_mds.ac.V03_ACActivity;
import com.toly1994.vvi_mds.fab_sna.FabSnaBsX3Activity;
import com.toly1994.vvi_mds.v00_toolbar.V00_ToolBarActivity;
import com.toly1994.vvi_mds.v01_tab.V01_TabLayoutActivity;
import com.toly1994.vvi_mds.v02_card.V02_CardViewActivity;
import com.toly1994.vvi_mds.v03_palette.V02_PaletteActivity;
import com.toly1994.vvi_mds.v04_behavior.V04_BehaviorActivity;

import java.util.List;

public class HomeRVAdapter extends RecyclerView.Adapter<HomeRVAdapter.MyViewHolder> {
    private Context mContext;
    private List<Integer> mData;

    public HomeRVAdapter(Context context, List<Integer> data) {
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_of_cade, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.mIvCover.setImageResource(mData.get(position));

        holder.mIvCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        mContext.startActivity(new Intent(mContext, V00_ToolBarActivity.class));
                        break;
                    case 1:
                        mContext.startActivity(new Intent(mContext, V01_TabLayoutActivity.class));
                        break;
                    case 2:
                        mContext.startActivity(new Intent(mContext, V02_CardViewActivity.class));
                        break;
                    case 3:
                        mContext.startActivity(new Intent(mContext, V03_ACActivity.class));
                        break;
                    case 4:
                        mContext.startActivity(new Intent(mContext, V02_PaletteActivity.class));
                        break;
                    case 5:
                        mContext.startActivity(new Intent(mContext, V04_BehaviorActivity.class));
                        break;
                    case 6:
                        mContext.startActivity(new Intent(mContext, FabSnaBsX3Activity.class));
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView mCvContent;
        public ImageView mIvCover;

        public MyViewHolder(View itemView) {
            super(itemView);
            mCvContent = itemView.findViewById(R.id.cv_content);
            mIvCover = itemView.findViewById(R.id.iv_cover);
        }
    }
}