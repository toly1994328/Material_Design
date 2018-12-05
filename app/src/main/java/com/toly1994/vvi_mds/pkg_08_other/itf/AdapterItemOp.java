package com.toly1994.vvi_mds.pkg_08_other.itf;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/3 0003:20:20<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：Item 操作的接口
 */
public interface AdapterItemOp<T> {

    /**
     * 交换条目
     *
     * @param from 起点
     * @param to 终点
     */
    void onItemMove(int from, int to);

    /**
     * 删除条目
     *
     * @param position 位置
     */
    void onItemDelete(int position);
}