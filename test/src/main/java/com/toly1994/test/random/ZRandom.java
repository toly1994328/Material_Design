package com.toly1994.test.random;


/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/8/27 0027:12:37<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：随机类拓展
 */
public class ZRandom {
    /**
     * 给定字符串数组,返回随机个数字符串拼接
     *
     * @param len   个数
     * @param chars 字符串数组
     * @return 随机个数字符串拼接
     */
    public static String rangeChar(int len, String[] chars) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(chars[rangeInt(0, chars.length - 1)]);
        }
        return sb.toString();
    }


    /**
     * 获取随机英文名字
     *
     * @return 随机英文名字
     */
    public static String randomEnName() {
        String firstName = upAChar(rangeChar(4, ZData.abc));
        String lastName = upAChar(rangeChar(6, ZData.abc));
        return firstName + " " + lastName;
    }


    /**
     * 将字符串仅首字母大写
     *
     * @param str 待处理字符串
     * @return 将字符串仅首字母大写
     */
    private static String upAChar(String str) {
        String a = str.substring(0, 1);
        String tail = str.substring(1);
        return a.toUpperCase() + tail;
    }

    /**
     * 获取随机中文名字
     *
     * @return 随机中文名字
     */
    public static String randomCnName() {
        StringBuilder sb = new StringBuilder();

        if (rangeInt(1, 2) == 1) {
            sb.append(rangeChar(1, ZData.XING));
            sb.append(rangeChar(1, ZData.MING));
        } else {
            sb.append(rangeChar(1, ZData.XING));
            sb.append(rangeChar(1, ZData.MING));
            sb.append(rangeChar(1, ZData.MING));
        }

        return sb.toString();
    }


    /**
     * 获取范围随机整数：如 rangeInt(1,9)
     *
     * @param s 前数(包括)
     * @param e 后数(包括)
     * @return 范围随机整数
     */
    public static int rangeInt(int s, int e) {
        int max = Math.max(s, e);
        int min = Math.min(s, e) - 1;
        return (int) (min + Math.ceil(Math.random() * (max - min)));
    }

    public static String randomChar(int max) {
        String[] concat = concat(ZData.ABC, ZData.abc);
        return rangeChar(rangeInt(1, max), concat);
    }


    public static String randomChar(String[] strs, int max) {
        return rangeChar(rangeInt(1, max), strs);
    }


    private static String[] concat(String[] a, String[] b) {
        String[] c = new String[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }
}
