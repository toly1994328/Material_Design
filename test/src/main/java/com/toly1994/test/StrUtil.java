package com.toly1994.test;

import android.webkit.MimeTypeMap;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * 作者：张风捷特烈
 * 时间：2018/2/20:17:57
 * 邮箱：1981462002@qq.com
 * 说明：字符串相关工具类
 */
public class StrUtil {

    /**
     * 将字符串仅首字母大写
     *
     * @param str 待处理字符串
     * @return 将字符串仅首字母大写
     */
    public static String upAChar(String str) {
        StringBuilder sb = new StringBuilder();
        String lastChars = str.substring(1);
        String firstChar = str.split("")[0].toUpperCase();

        sb.append(firstChar);
        sb.append(lastChars);

        return sb.toString();
    }

    /**
     * 获取现在时间
     *
     * @return 返回短时间字符串格式yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentTime(String pattern) {
        return new SimpleDateFormat(pattern, Locale.CHINA).format(System.currentTimeMillis());
    }

    /**
     * 返回短时间字符串格式yyyy-MM-dd HH:mm:ss
     *
     * @return 返回短时间字符串格式yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentTime_yyyy_MM_dd_HH_mm_ss() {

        return getCurrentTime("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 返回短时间字符串格式yyyyMMddHHmmss
     *
     * @return 返回短时间字符串格式yyyyMMddHHmmss
     */
    public static String getCurrentTime_yyyyMMddHHmmss() {
        return getCurrentTime("yyyyMMddHHmmss");
    }

    /**
     * 格式化文件大小
     *
     * @param length 文件长度
     * @return 文件大小
     */
    public static String formatLong2M(long length) {
        String result = "";
        if (length < 1024) {
            result = length + "B";
        } else if (length < 1024 * 1024) {
            result = length / 1024.f + "KB";
        } else if (length > 1024 * 1024) {
            result = length / 1024.f / 1024 + "MB";
        }
        if (length > 1024 * 1024 * 1024) {
            result = length / 1024.f / 1024 / 1024 + "GB";
        }
        return result;
    }

    /**
     * 获取文件的mimeType
     * @param file 文件
     * @return 文件的mimeType
     */
    public static String mimeType(File file) {
        if (file.isDirectory()) {
            return "not dir";
        }
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        String path = file.getAbsolutePath();
        String extension = MimeTypeMap.getFileExtensionFromUrl(path);
        return mimeTypeMap.getMimeTypeFromExtension(extension);
    }

    /**
     * 判断字符串是否有值
     *
     * @param value 字符串
     * @return 如果为null, 空字符串, 只有空格, 为"null"字符串，则返回true
     */
    public static boolean isEmpty(String value) {
        if (value != null && !"".equalsIgnoreCase(value.trim())
                && !"null".equalsIgnoreCase(value.trim())) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 字符串数组转集合
     *
     * @param strs 字符串
     * @return 字符串集合
     */
    public static List<String> strs2List(String[] strs) {

        List<String> strings = new ArrayList<>();
        strings.addAll(Arrays.asList(strs));

        return strings;
    }

    /**
     * 集合转字符串数组
     *
     * @param strsList 符串数组
     * @return 字符串集合
     */
    public static String[] List2strs(List<String> strsList) {
        String[] strs = new String[strsList.size()];
        for (int i = 0; i < strsList.size(); i++) {
            strs[i] = strsList.get(i);
        }

        return strs;
    }

}
