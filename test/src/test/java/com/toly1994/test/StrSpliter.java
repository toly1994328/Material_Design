package com.toly1994.test;

import com.toly1994.test.common.StrUtils;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

/**
 * 作者：张风捷特烈
 * 时间：2018/10/31 0031:8:47
 * 邮箱：1981462002@qq.com
 * 说明：初始化RecyclerView的Adapter
 */
public class StrSpliter {
    @Test
    public void main() {
        //你的布局xml所在路径
        File file = new File("C:\\Users\\Administrator\\Desktop\\匆匆.txt");
        String name = "congcong";
        split(file, name);

    }

    @Test
    public void sheng() {
        String str = "北京市，天津市，上海市，重庆市，河北省，山西省，辽宁省，吉林省，黑龙江省，江苏省，浙江省，安徽省，福建省，江西省，山东省，河南省，湖北省，湖南省，广东省，海南省，四川省，贵州省，云南省，陕西省，甘肃省，青海省，台湾省，内蒙古自治区，广西壮族自治区，西藏自治区，宁夏回族自治区，新疆维吾尔自治区，香港特别行政区，澳门特别行政区";
        StringBuilder sb = new StringBuilder("public static String[] " + "PROVINCES" + " = new String[]{");
        String[] strings = str.split("，");
        for (int i = 0; i < strings.length; i++) {
            if (i == strings.length - 1) {
                sb.append("\"" + strings[i] + "\"};");
                break;
            }
            sb.append("\"" + strings[i] + "\",");
        }
        System.out.println(sb.toString());
    }

    @Test
    public void xing() {
        String str = "赵    钱    孙    李    周    吴    郑    王    冯    陈    褚    卫    蒋    沈    韩    杨    朱    秦    尤    许    " +
                "何    吕    施    张    孔    曹    严    华    金    魏    陶    姜    戚    谢    邹    喻    柏    水    窦    章    " +
                "云    苏    潘    葛    奚    范    彭    郎    鲁    韦    昌    马    苗    凤    花    方    俞    任    袁    柳    " +
                "酆    鲍    史    唐    费    廉    岑    薛    雷    贺    倪    汤    滕    殷    罗    毕    郝    邬    安    常    " +
                "乐    于    时    傅    皮    卞    齐    康    伍    余    元    卜    顾    孟    平    黄    和    穆    萧    尹    " +
                "姚    邵    湛    汪    祁    毛    禹    狄    米    贝    明    臧    计    伏    成    戴    谈    宋    茅    庞    " +
                "熊    纪    舒    屈    项    祝    董    粱    杜    阮    蓝    闵    席    季    麻    强    贾    路    娄    危    " +
                "江    童    颜    郭    梅    盛    林    刁    钟    徐    邱    骆    高    夏    蔡    田    樊    胡    凌    霍    " +
                "虞    万    支    柯    昝    管    卢    莫    经    房    裘    缪    干    解    应    宗    丁    宣    贲    邓    " +
                "郁    单    杭    洪    包    诸    左    石    崔    吉    钮    龚    程    嵇    邢    滑    裴    陆    荣    翁    " +
                "荀    羊    於    惠    甄    麴    家    封    芮    羿    储    靳    汲    邴    糜    松    井    段    富    巫    " +
                "乌    焦    巴    弓    牧    隗    山    谷    车    侯    宓    蓬    全    郗    班    仰    秋    仲    伊    宫    " +
                "宁    仇    栾    暴    甘    钭    厉    戎    祖    武    符    刘    景    詹    束    龙    叶    幸    司    韶    " +
                "郜    黎    蓟    薄    印    宿    白    怀    蒲    邰    从    鄂    索    咸    籍    赖    卓    蔺    屠    蒙    " +
                "池    乔    阴    欎    胥    能    苍    双    闻    莘    党    翟    谭    贡    劳    逄    姬    申    扶    堵    " +
                "冉    宰    郦    雍    舄    璩    桑    桂    濮    牛    寿    通    边    扈    燕    冀    郏    浦    尚    农    " +
                "温    别    庄    晏    柴    瞿    阎    充    慕    连    茹    习    宦    艾    鱼    容    向    古    易    慎    " +
                "戈    廖    庾    终    暨    居    衡    步    都    耿    满    弘    匡    国    文    寇    广    禄    阙    东    " +
                "殴    殳    沃    利    蔚    越    夔    隆    师    巩    厍    聂    晁    勾    敖    融    冷    訾    辛    阚    " +
                "那    简    饶    空    曾    毋    沙    乜    养    鞠    须    丰    巢    关    蒯    相    查    後    荆    红    " +
                "游    竺    权    逯    盖    益    桓    公    万俟    司马    上官    欧阳    夏侯    诸葛    " +
                "闻人    东方    赫连    皇甫    尉迟    公羊    澹台    公冶    宗政    濮阳    " +
                "淳于    单于    太叔    申屠    公孙    仲孙    轩辕    令狐    钟离    宇文    " +
                "长孙    慕容    鲜于    闾丘    司徒    司空    亓官    司寇    仉    督    子车    " +
                "颛孙    端木    巫马    公西    漆雕    乐正    壤驷    公良    拓跋    夹谷    " +
                "宰父    谷梁    晋    楚    闫    法    汝    鄢    涂    钦    段干    百里    东郭    南门    " +
                "呼延    归    海    羊舌    微生    岳    帅    缑    亢    况    后    有    琴    梁丘    左丘    " +
                "东门    西门    商    牟    佘    佴    伯    赏    南宫    墨    哈    谯    笪    年    爱    阳    佟    ";
        StringBuilder sb = new StringBuilder("public static String[] " + "XING" + " = new String[]{");
        String[] strings = str.split("    ");
        for (int i = 0; i < strings.length; i++) {
            if (i == strings.length - 1) {
                sb.append("\"" + strings[i] + "\"};");
                break;
            }
            sb.append("\"" + strings[i] + "\",");
        }
        System.out.println(sb.toString());
    }

    private void split(File file, String name) {
        String readFile = readFile(file);
        String str = StrUtils.beLine(readFile);
        StringBuilder sb = new StringBuilder("public static String[] " + name + " = new String[]{");
        char[] chars = str.toCharArray();


        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1) {
                sb.append("\"" + chars[i] + "\"};");
                break;
            }
            sb.append("\"" + chars[i] + "\",");
        }
        System.out.println(sb.toString());
    }


    /**
     * 读取文件
     *
     * @param in
     * @return
     */
    private static String readFile(File in) {
        if (!in.exists() && in.isDirectory()) {
            return "";
        }

        FileReader fr = null;
        try {
            fr = new FileReader(in);
            //字符数组循环读取
            char[] buf = new char[1024];
            int len = 0;
            StringBuilder sb = new StringBuilder();
            while ((len = fr.read(buf)) != -1) {
                sb.append(new String(buf, 0, len));
            }

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 直接拼接出Adapter
     */
    private static String contactAdapter(File file, File out, String name, HashMap<String, String> map) {
        StringBuilder sb = new StringBuilder();
        String path = out.getAbsolutePath();
        path.split("java");

        sb.append("package " + path.split("java\\\\")[1].replaceAll("\\\\", ".") + ";\n");
        sb.append("import android.content.Context;\n" +
                "import android.support.annotation.NonNull;\n" +
                "import android.support.constraint.ConstraintLayout;\n" +
                "import android.support.v7.widget.RecyclerView;\n" +
                "import android.view.LayoutInflater;\n" +
                "import android.view.View;\n" +
                "import android.view.ViewGroup;\n" +
                "import android.widget.Button;\n" +
                "import java.util.List;\n" +
                "import android.widget.TextView;\n");
        sb.append("public class " + name + " extends RecyclerView.Adapter<" + name + ".MyViewHolder> {\n");
        sb.append("private Context mContext;\n");
        sb.append("private List<String> mData;\n");
        sb.append("public " + name + "(List<String> data) {\n" +
                "    mData = data;\n" +
                "}");

        String layoutId = file.getName().substring(0, file.getName().indexOf(".x"));
        sb.append("@NonNull\n" +
                "@Override\n" +
                "public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {\n" +
                "mContext = parent.getContext();\n" +
                "    View view = LayoutInflater.from(mContext).inflate(R.layout." + layoutId + ", parent, false);\n" +
                "    return new MyViewHolder(view);\n" +
                "}\n");

        sb.append("@Override \n" +
                "public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {\n" +
                "String str = mData.get(position);"
        );

        map.forEach((id, view) -> {

            if (view.contains("\n")) {
                view = view.split("\n")[0];
            }

            if ("Button".equals(view)) {
                sb.append("holder." + formatId2Field(id) + ".setOnClickListener(v -> {\n" +
                        "        });\n");
            }

            if ("TextView".equals(view)) {
                sb.append("holder." + formatId2Field(id) + ".setText(str);\n");
            }
            if ("ImageView".equals(view)) {
                sb.append("holder." + formatId2Field(id) + ".setImageBitmap(null);\n");
            }
        });

        sb.append("}\n" +
                "@Override\n" +
                "public int getItemCount() {\n" +
                "return mData.size();\n" +
                "}");

        sb.append(contactViewHolder(map));
        return sb.toString();
    }

    /**
     * 连接字符串:ViewHolder
     */
    private static String contactViewHolder(HashMap<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("class MyViewHolder extends RecyclerView.ViewHolder {\r\n");
        map.forEach((id, view) -> {
            if (view.contains("\n")) {
                view = view.split("\n")[0];
            }

            sb.append("public ").append(view).append(" ")
                    .append(formatId2Field(id)).append(";").append("\r\n");
        });

        sb.append("public MyViewHolder(View itemView) {\n" +
                "super(itemView);");

        map.forEach((id, view) -> {
            sb.append(formatId2Field(id))
                    .append("= itemView.findViewById(R.id.")
                    .append(id).append(");").append("\r\n");
        });
        sb.append("}\n" +
                "}\n}");

        return sb.toString();
    }

    private static String formatId2Field(String id) {
        if (id.contains("_")) {
            String[] partStrArray = id.split("_");
            id = "";
            for (String part : partStrArray) {
                String partStr = upAChar(part);
                id += partStr;
            }
        }
        return "m" + id;
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

    private static HashMap<String, String> split(String res) {
        String[] split = res.split("<");
        HashMap<String, String> viewMap = new HashMap<>();
        for (String s : split) {
            if (s.contains("android:id=\"@+id") && !s.contains("Guideline")) {
                String id = s.split("@")[1];
                id = id.substring(id.indexOf("/") + 1, id.indexOf("\""));
                String view = s.split("\r\n")[0];
                String[] viewNameArr = view.split("\\.");
                if (viewNameArr.length > 0) {
                    view = viewNameArr[viewNameArr.length - 1];
                }
                viewMap.put(id, view);
            }
        }
        return viewMap;
    }
}
