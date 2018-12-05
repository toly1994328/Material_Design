package com.toly1994.vvi_mds.pkg_08_other.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.toly1994.vvi_mds.R;
import com.toly1994.test.bean.MsgBean;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/2 0002:9:22<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：聊天的适配器
 */
public class ChatRvAdapter extends RecyclerView.Adapter<ChatRvAdapter.MyViewHolder> {
    private static final String TAG = "TolyRvAdapter";
    private List<MsgBean> mData;

    private Context mContext;

    public ChatRvAdapter(List<MsgBean> data) {
        mData = data;
    }

    @NonNull
    @Override//将item布局文件与ViewHolder结合
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = null;
        switch (viewType) {//对不同的viewType加载不同的布局
            case 0:
                view = LayoutInflater.from(mContext)
                        .inflate(R.layout.item_chat_me, parent, false);
                break;
            case 1:
                view = LayoutInflater.from(mContext)
                        .inflate(R.layout.item_chat_he, parent, false);
                break;
            case 2:
                view = LayoutInflater.from(mContext)
                        .inflate(R.layout.item_chat_time, parent, false);
                break;
        }
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MsgBean msgBean = mData.get(position);

        switch (msgBean.getType()) {//对不同的viewType设置不同的数据
            case 0:
            case 1:
                holder.mItemTV.setText(msgBean.getMsg());
                break;
            case 2:
                String time = new SimpleDateFormat("MM月dd日 a HH:mm", Locale.CHINA)
                        .format(System.currentTimeMillis());
                holder.mItemTvTime.setText(time);
                break;

        }
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {//返回条目种类viewType
        return mData.get(position).getType();
    }

    /**
     * ViewHolder
     */
    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mItemTV;
        private TextView mItemTvTime;

        public MyViewHolder(View itemView) {
            super(itemView);
            mItemTV = itemView.findViewById(R.id.id_tv_chat_msg);
            mItemTvTime = itemView.findViewById(R.id.id_tv_time);
        }
    }
}
