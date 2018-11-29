package com.toly1994.test.common;

import android.content.res.ColorStateList;
import android.graphics.Color;

import java.util.Random;

/**
 * 作者：张风捷特烈
 * 时间：2018/5/19:17:02
 * 邮箱：1981462002@qq.com
 * 说明：颜色工具类
 */
public class ColUtils {
    /**
     * 改变一个颜色的透明度
     *
     * @param color
     * @param alpha
     */
    public static int changeColorAlpha(int color, int alpha) {
        int a = (color >> 24) & 0xFF;
        a = (int) (a * (alpha / 255f));
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = color & 0xFF;
        return (a << 24) | (r << 16) | (g << 8) | b;
    }

    /**
     * 返回随机颜色
     *
     * @return 随机颜色
     */
    public static int randomColor() {
        Random random = new Random();
        int a = 250 + random.nextInt(255);
        int r = 30 + random.nextInt(200);
        int g = 30 + random.nextInt(200);
        int b = 30 + random.nextInt(200);
        int randomColor = Color.argb(a, r, g, b);

        return randomColor;

    }

    /**
     * 返回随机颜色
     *
     * @return 随机颜色
     */
    public static int randomRGB() {
        Random random = new Random();
        int r = 30 + random.nextInt(200);
        int g = 30 + random.nextInt(200);
        int b = 30 + random.nextInt(200);
        return Color.rgb(r, g, b);
    }

    /**
     * 颜色变换
     *
     * @param fraction 分度值
     * @param startValue 开始色
     * @param endValue 结束色
     * @return 分度值处颜色
     */
    public static int evaluateColor(float fraction, int startValue,
                                       int endValue) {
        int startA = (startValue >> 24) & 0xff;
        int startR = (startValue >> 16) & 0xff;
        int startG = (startValue >> 8) & 0xff;
        int startB = startValue & 0xff;

        int endA = (endValue >> 24) & 0xff;
        int endR = (endValue >> 16) & 0xff;
        int endG = (endValue >> 8) & 0xff;
        int endB = endValue & 0xff;

        return (startA + (int) (fraction * (endA - startA)) << 24)
                | (startR + (int) (fraction * (endR - startR)) << 16)
                | (startG + (int) (fraction * (endG - startG)) << 8)
                | startB + (int) (fraction * (endB - startB));
    }

    private static final int ENABLE_ATTR = android.R.attr.state_enabled;
    private static final int CHECKED_ATTR = android.R.attr.state_checked;
    private static final int PRESSED_ATTR = android.R.attr.state_pressed;

    /**
     * @param tintColor
     * @return
     */
    public static ColorStateList generateThumbColorWithTintColor(final int tintColor) {
        int[][] states = new int[][]{
                {-ENABLE_ATTR, CHECKED_ATTR},
                {-ENABLE_ATTR},
                {PRESSED_ATTR, -CHECKED_ATTR},
                {PRESSED_ATTR, CHECKED_ATTR},
                {CHECKED_ATTR},
                {-CHECKED_ATTR}
        };

        int[] colors = new int[]{
                tintColor - 0xAA000000,
                0xFFBABABA,
                tintColor - 0x99000000,
                tintColor - 0x99000000,
                tintColor | 0xFF000000,
                0xFFEEEEEE
        };
        return new ColorStateList(states, colors);
    }

    /**
     * @param tintColor
     * @return
     */
    public static ColorStateList generateBackColorWithTintColor(final int tintColor) {
        int[][] states = new int[][]{
                {-ENABLE_ATTR, CHECKED_ATTR},
                {-ENABLE_ATTR},
                {CHECKED_ATTR, PRESSED_ATTR},
                {-CHECKED_ATTR, PRESSED_ATTR},
                {CHECKED_ATTR},
                {-CHECKED_ATTR}
        };

        int[] colors = new int[]{
                tintColor - 0xE1000000,
                0x10000000,
                tintColor - 0xD0000000,
                0x20000000,
                tintColor - 0xD0000000,
                0x20000000
        };
        return new ColorStateList(states, colors);
    }

    /**
     * 颜色加深处理
     *
     * @param RGBValues RGB的值，由alpha（透明度）、red（红）、green（绿）、blue（蓝）构成，
     *                  Android中我们一般使用它的16进制，
     *                  例如："#FFAABBCC",最左边到最右每两个字母就是代表alpha（透明度）、
     *                  red（红）、green（绿）、blue（蓝）。每种颜色值占一个字节(8位)，值域0~255
     *                  所以下面使用移位的方法可以得到每种颜色的值，然后每种颜色值减小一下，在合成RGB颜色，颜色就会看起来深一些了
     * @return
     */
    public static int colorBurn(int RGBValues) {
        int red = RGBValues >> 16 & 0xFF;
        int green = RGBValues >> 8 & 0xFF;
        int blue = RGBValues & 0xFF;
        red = (int) Math.floor(red * (1 - 0.1));
        green = (int) Math.floor(green * (1 - 0.1));
        blue = (int) Math.floor(blue * (1 - 0.1));
        return Color.rgb(red, green, blue);
    }
}
