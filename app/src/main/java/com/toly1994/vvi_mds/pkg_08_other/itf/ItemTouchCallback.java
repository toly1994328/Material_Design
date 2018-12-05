package com.toly1994.vvi_mds.pkg_08_other.itf;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/3 0003:20:20<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：条目触摸时的回调
 */
public class ItemTouchCallback extends ItemTouchHelper.Callback {

    private AdapterItemOp mAdapter;//操作接口

    public ItemTouchCallback(AdapterItemOp adapter) {
        mAdapter = adapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //上下左右拖动
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN |
                ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT;

        //可向左滑动---删除
        int swipeFlags = ItemTouchHelper.LEFT;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override//长按拖动
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override//滑动删除
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        //移动时：---交换两个ViewHolder的位置
        mAdapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        //滑动删除时：---
        mAdapter.onItemDelete(viewHolder.getAdapterPosition());
    }
}

