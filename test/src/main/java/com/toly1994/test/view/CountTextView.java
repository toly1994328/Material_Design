package com.toly1994.test.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.toly1994.test.R;


public class CountTextView extends View {
    private int mCtvFontSize = sp(100);
    private int mCtvNum = 5;
    private int mCtvBgColor = 0xffBFF3F7;
    private int mCtvTxtColor = Color.WHITE;
    private Paint mPaint;//主画笔
    private Paint mTxtPaint;
    private Rect mRect;
    private String mStr;
    private int mOffSet;

    public CountTextView(Context context) {
        this(context, null);
    }

    public CountTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CountTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CountTextView);
        mCtvFontSize = (int) a.getDimension(R.styleable.CountTextView_z_ctv_font_size, mCtvFontSize);
        mCtvNum = a.getInteger(R.styleable.CountTextView_z_ctv_num, mCtvNum);
        mCtvTxtColor = a.getColor(R.styleable.CountTextView_z_txt_color, mCtvTxtColor);
        mCtvBgColor = a.getColor(R.styleable.CountTextView_z_bg_color, mCtvBgColor);
        a.recycle();
        init();
    }

    private void init() {
        //初始化主画笔
        mTxtPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTxtPaint.setColor(mCtvTxtColor);
        mTxtPaint.setTextSize(mCtvFontSize);
        mRect = new Rect();

        mStr = mCtvNum + "";
        if (mCtvNum >= 1000) {
            mStr = "999+";
        }
        mTxtPaint.getTextBounds(mStr, 0, mStr.length(), mRect);
        int AChartLen = mRect.width() / mStr.length();
        mOffSet = (int) ((mStr.length() - 1) * AChartLen * 0.7f);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mCtvBgColor);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //文字左侧距圆心的偏移
        int offsetX = mRect.height() - mRect.width() / 2 + mOffSet;
        setMeasuredDimension(2 * offsetX + mRect.width(), 2 * mRect.height());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        int offsetX = mRect.height() - mRect.width() / 2 + mOffSet;
        canvas.translate(offsetX, mRect.height() / 2);
        //圆角矩形左上点
        int topX = mRect.width() / 2 - mRect.height();
        int topY = -mRect.height() / 2;
        //圆角矩形右下点
        int bottomX = mRect.height() + mRect.width() / 2;
        int bottomY = mRect.height() / 2 + mRect.height();

        canvas.drawRoundRect(topX - mOffSet, topY, bottomX + mOffSet, bottomY,
                mRect.height(), mRect.height(), mPaint);

        canvas.drawText(mStr, 0, mRect.height(), mTxtPaint);
        canvas.restore();
    }

    private int sp(float sp) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, sp, getResources().getDisplayMetrics());
    }

    public int getCtvFontSize() {
        return mCtvFontSize;
    }

    public void setCtvFontSize(int ctvFontSize) {
        mCtvFontSize = ctvFontSize;
    }

    public int getCtvNum() {
        return mCtvNum;
    }

    public void setCtvNum(int ctvNum) {
        mCtvNum = ctvNum;
        mStr = mCtvNum + "";
        if (mCtvNum >= 1000) {
            mStr = "999+";
        }
//        mTxtPaint.getTextBounds(mStr, 0, mStr.length(), mRect);
//        int AChartLen = mRect.width() / mStr.length();
//        mOffSet = (int) ((mStr.length() - 1) * AChartLen * 0.7f);
    }

    public int getCtvBgColor() {
        return mCtvBgColor;
    }

    public void setCtvBgColor(int ctvBgColor) {
        mCtvBgColor = ctvBgColor;
    }

    public int getCtvTxtColor() {
        return mCtvTxtColor;
    }

    public void setCtvTxtColor(int ctvTxtColor) {
        mCtvTxtColor = ctvTxtColor;
    }
}