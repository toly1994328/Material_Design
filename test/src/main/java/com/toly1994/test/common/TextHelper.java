package com.toly1994.test.common;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/9/1 0001:21:56<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：
 */
public class TextHelper {


    /**
     * @param ctx  上下文
     * @param tv   TextView
     * @param font 字体位置
     * @return TextView
     */
    public static TextView setFont(Context ctx, TextView tv, String font) {
        tv.setTypeface(Typeface.createFromAsset(ctx.getAssets(), font));//设置字体
        return tv;
    }

    /**
     * 获取一个textview
     *
     * @param ctx 上下文
     * @param str 字符串
     * @return TextView
     */
    public static TextView getTextView(Context ctx, String str) {
        TextView textView = new TextView(ctx);
        textView.setTextColor(Color.BLACK);
        textView.setText(str);
        return textView;
    }

}
