package com.toly1994.test;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

/**
 * 作者：张风捷特烈
 * 时间：2018/10/31 0031:8:47
 * 邮箱：1981462002@qq.com
 * 说明：安卓自定义属性，代码生成器
 */
public class Attrs2View {
    @Test
    public void main() {
        //你的attr.xml所在路径
        File file = new File("I:\\Java\\Android\\Unit\\B\\test\\src\\main\\res\\values\\attrs.xml");
        //你的Adapter的java类放在哪个包里
        File out = new File("I:\\Java\\Android\\Unit\\B\\asyn\\src\\main\\java\\com\\toly1994\\app");
        String preFix = "z_";
        //你的前缀
        initAttr(preFix, file, out);
    }

    public static void initAttr(String preFix, File file, File out) {
        HashMap<String, String> format = format(preFix, file);
        String className = format.get("className");
        String result = format.get("result");

        StringBuilder sb = initTop(out, className, result);
        sb.append("TypedArray a = context.obtainStyledAttributes(attrs, R.styleable." + className + ");\r\n");
        format.forEach((s, s2) -> {
            String styleableName = className + "_" + preFix + s;
            if (s.contains("_")) {
                String[] partStrArray = s.split("_");
                s = "";
                for (String part : partStrArray) {
                    String partStr = upAChar(part);
                    s += partStr;
                }
            }
            if (s2.equals("dimension")) {
                // mPbBgHeight = (int) a.getDimension(R.styleable.TolyProgressBar_z_pb_bg_height, mPbBgHeight);
                sb.append("m" + s + " = (int) a.getDimension(R.styleable." + styleableName + ", m" + s + ");\r\n");
            }
            if (s2.equals("color")) {
                // mPbTxtColor = a.getColor(R.styleable.TolyProgressBar_z_pb_txt_color, mPbTxtColor);
                sb.append("m" + s + " =  a.getColor(R.styleable." + styleableName + ", m" + s + ");\r\n");
            }
            if (s2.equals("boolean")) {
                // mPbTxtColor = a.getColor(R.styleable.TolyProgressBar_z_pb_txt_color, mPbTxtColor);
                sb.append("m" + s + " =  a.getBoolean(R.styleable." + styleableName + ", m" + s + ");\r\n");
            }
            if (s2.equals("string")) {
                // mPbTxtColor = a.getColor(R.styleable.TolyProgressBar_z_pb_txt_color, mPbTxtColor);
                sb.append("m" + s + " =  a.getString(R.styleable." + styleableName + ");\r\n");
            }
        });
        sb.append("a.recycle();\r\n");

        sb.append("init();\n" +
                "    }");
        sb.append("private void init() {\n" +
                "\n" +
                "    }\n}");
        System.out.println(sb.toString());

        FileWriter fw = null;
        try {
            //写出到磁盘
            File outFile = new File(out, className + ".java");
            fw = new FileWriter(outFile);
            fw.write(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    /*
     *
     * @param out
     * @param name
     */
    private static StringBuilder initTop(File out, String name, String field) {
        StringBuilder sb = new StringBuilder();
        String path = out.getAbsolutePath();
        path.split("java");
        sb.append("package " + path.split("java\\\\")[1].replaceAll("\\\\", ".") + ";\n");
        sb.append("public class " + name + " extends View {\n");
        sb.append(field);
        sb.append("public " + name + "(Context context) {\n" +
                "    this(context, null);\n" +
                "}\n" +
                "public " + name + "(Context context, AttributeSet attrs) {\n" +
                "    this(context, attrs, 0);\n" +
                "}\n" +
                "public " + name + "(Context context, AttributeSet attrs, int defStyleAttr) {\n" +
                "    super(context, attrs, defStyleAttr);\n");

        return sb;
    }

    /**
     * 读取文件+解析
     *
     * @param preFix 前缀
     * @param file   文件路径
     */
    public static HashMap<String, String> format(String preFix, File file) {
        HashMap<String, String> container = new HashMap<>();
        if (!file.exists() && file.isDirectory()) {
            return null;
        }
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            //字符数组循环读取
            char[] buf = new char[1024];
            int len = 0;
            StringBuilder sb = new StringBuilder();
            while ((len = fr.read(buf)) != -1) {
                sb.append(new String(buf, 0, len));
            }
            String className = sb.toString().split("<declare-styleable name=\"")[1];
            className = className.substring(0, className.indexOf("\">"));
            container.put("className", className);
            String[] split = sb.toString().split("<");
            String part1 = "private";
            String type = "";//类型
            String name = "";
            String result = "";
            String def = "";//默认值

            StringBuilder sb2 = new StringBuilder();
            for (String s : split) {
                if (s.contains(preFix)) {
                    result = s.split(preFix)[1];
                    name = result.substring(0, result.indexOf("\""));
                    type = result.split("format=\"")[1];
                    type = type.substring(0, type.indexOf("\""));
                    container.put(name, type);
                    if (type.contains("color") || type.contains("dimension") || type.contains("integer")) {
                        type = "int";
                        def = "0";
                    }
                    if (result.contains("fraction")) {
                        type = "float";
                        def = "0.f";
                    }
                    if (result.contains("string")) {
                        type = "String";
                        def = "\"toly\"";
                    }
                    if (result.contains("boolean")) {
                        type = "boolean";
                        def = "false";

                    }
                    if (name.contains("_")) {
                        String[] partStrArray = name.split("_");
                        name = "";
                        for (String part : partStrArray) {
                            String partStr = upAChar(part);
                            name += partStr;
                        }
                        sb2.append(part1 + " " + type + " m" + name + "= " + def + ";\r\n");
                    }
                    container.put("result", sb2.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return container;
    }

    /**
     * 将字符串仅首字母大写
     *
     * @param str 待处理字符串
     * @return 将字符串仅首字母大写
     */
    public static String upAChar(String str) {
        String a = str.substring(0, 1);
        String tail = str.substring(1);
        return a.toUpperCase() + tail;
    }
}
