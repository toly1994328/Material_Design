package com.toly1994.test.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/4 0004:15:10<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：
 */
public class StrUtils {
    public static String beLine(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("，|。|\\?|？|！|!|—|:|：|;|；|,|\\.|_|　|\"|“|”|\\s");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
}
