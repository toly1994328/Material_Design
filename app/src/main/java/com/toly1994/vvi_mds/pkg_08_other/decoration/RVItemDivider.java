package com.toly1994.vvi_mds.pkg_08_other.decoration;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/3 0003:10:36<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：RecyclerView的分割线
 */
public class RVItemDivider extends RecyclerView.ItemDecoration {

    public enum Type {
        VERTICAL,//竖直线
        HORIZONTAL,//水平线
    }

    private Paint mPaint;//画笔
    private Drawable mDivider;//Drawable分割线
    private int mDividerHeight = 1;//分割线高度，默认为1px
    private Type mOrientation;//线的方向
    private static final int[] ATTRS = new int[]{android.R.attr.listDivider};


    public RVItemDivider(Context context, Type orientation) {
        mOrientation = orientation;
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
    }

    public RVItemDivider(Context context, Type orientation, int drawableId) {
        this(context, orientation);
        mDivider = ContextCompat.getDrawable(context, drawableId);
        mDividerHeight = mDivider.getIntrinsicHeight();
    }

    /**
     * 自定义分割线
     *
     * @param context       上下文
     * @param orientation   列表方向
     * @param dividerHeight 分割线高度
     * @param dividerColor  分割线颜色
     */
    public RVItemDivider(Context context, Type orientation, int dividerHeight, int dividerColor) {
        this(context, orientation);
        mDividerHeight = dividerHeight;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(dividerColor);
        mPaint.setStyle(Paint.Style.FILL);
    }


    /**
     * 获取分割线尺寸
     *
     * @param outRect 线的矩框
     * @param view    线
     * @param parent  RecyclerView
     * @param state   状态
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        switch (mOrientation) {
            case HORIZONTAL:
                outRect.set(0, 0, 0, mDividerHeight);//横线矩框
                break;
            case VERTICAL:
                outRect.set(0, 0, mDividerHeight, 0);//横线矩框

        }
    }

    /**
     * 绘制分割线
     *
     * @param canvas 画布
     * @param parent RecyclerView
     * @param state  状态
     */
    @Override
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(canvas, parent, state);

        switch (mOrientation) {
            case VERTICAL:
                drawVertical(canvas, parent);//竖线矩框
                break;
            case HORIZONTAL:
                drawHorizontal(canvas, parent);//横线矩框
                break;
        }
    }

    /**
     * 绘制水平线
     *
     * @param canvas 画布
     * @param parent RecyclerView
     */
    private void drawHorizontal(Canvas canvas, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getMeasuredWidth() - parent.getPaddingRight();
        final int childNum = parent.getChildCount();
        for (int i = 0; i < childNum; i++) {//遍历所有的孩子
            final View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            //线的左上角坐标(itemView底部+边距,itemView底部+边距+线高)
            final int top = child.getBottom() + layoutParams.bottomMargin;
            final int bottom = top + mDividerHeight;
            if (mDivider != null) {//有mDivider时---绘制mDivider
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(canvas);
            }
            if (mPaint != null) {//有mPaint时---绘制矩形
                canvas.drawRect(left, top, right, bottom, mPaint);
            }
        }
    }

    /**
     * 绘制竖直线--------同理
     *
     * @param canvas 画布
     * @param parent RecyclerView
     */
    private void drawVertical(Canvas canvas, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getMeasuredHeight() - parent.getPaddingBottom();
        final int childSize = parent.getChildCount();
        for (int i = 0; i < childSize; i++) {
            final View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left = child.getRight() + layoutParams.rightMargin;
            final int right = left + mDividerHeight;
            if (mDivider != null) {
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(canvas);
            }
            if (mPaint != null) {
                canvas.drawRect(left, top, right, bottom, mPaint);
            }
        }
    }
}