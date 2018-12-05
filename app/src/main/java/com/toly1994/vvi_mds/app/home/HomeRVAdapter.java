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
import com.toly1994.vvi_mds.pkg1_toolbar_card.V01_ToolBarActivity;
import com.toly1994.vvi_mds.pkg1_toolbar_card.V02_CardViewActivity;
import com.toly1994.vvi_mds.pkg2_fab_sna_sheet.V03_FabSnaBsX3Activity;
import com.toly1994.vvi_mds.pkg3_bnb_tab.V04_BottomNavigationBarActivity;
import com.toly1994.vvi_mds.pkg3_bnb_tab.V05_TabLayoutActivity;
import com.toly1994.vvi_mds.pkg4_app_coo.V06_ACActivity;
import com.toly1994.vvi_mds.pkg5_coll_palette.V07_CollapsingPaletteActivity;
import com.toly1994.vvi_mds.pkg6_drawer_nav_input.V08_DrawerNavigationTextInputActivity;
import com.toly1994.vvi_mds.pkg7_behavior.V09_BehaviorActivity;
import com.toly1994.vvi_mds.pkg7_behavior.V11_BehaviorActivity;
import com.toly1994.vvi_mds.pkg_08_other.V012_SwipeRefreshActivity;

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
                        mContext.startActivity(new Intent(mContext, V01_ToolBarActivity.class));
                        break;
                    case 1:
                        mContext.startActivity(new Intent(mContext, V02_CardViewActivity.class));
                        break;
                    case 2:
                        mContext.startActivity(new Intent(mContext, V03_FabSnaBsX3Activity.class));
                        break;
                    case 3:
                        mContext.startActivity(new Intent(mContext, V04_BottomNavigationBarActivity.class));
                        break;
                    case 4:
                        mContext.startActivity(new Intent(mContext, V05_TabLayoutActivity.class));
                        break;
                    case 5:
                        mContext.startActivity(new Intent(mContext, V06_ACActivity.class));
                        break;
                    case 6:
                        mContext.startActivity(new Intent(mContext, V07_CollapsingPaletteActivity.class));
                        break;
                    case 7:
                        mContext.startActivity(new Intent(mContext, V08_DrawerNavigationTextInputActivity.class));
                        break;
                    case 8:
                        mContext.startActivity(new Intent(mContext, V09_BehaviorActivity.class));
                        break;
                    case 9:
                        mContext.startActivity(new Intent(mContext, V11_BehaviorActivity.class));
                        break;
                    case 10:
                        mContext.startActivity(new Intent(mContext, V012_SwipeRefreshActivity.class));
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