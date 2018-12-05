package com.toly1994.test.bean;

import com.toly1994.test.R;
import com.toly1994.test.random.ZData;
import com.toly1994.test.random.ZRandom;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/4 0004:8:48<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：
 */
public class BeanFactory {

    public static List<GoodsBean> getGoodsBean() {
        List<GoodsBean> beans = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            beans.add(new GoodsBean(R.mipmap.pic4, "混沌战士,等比例人形,附加刀及盔甲,2030年爆款,限额三百件,先到先得,售完为止", 6666, 277, "店铺优惠,满100送10"));
            beans.add(new GoodsBean(R.mipmap.pic1, "蓝夜皮肤,2030年爆款,限额三件,先到先得,售完为止", 99999, 2));

            beans.add(new GoodsBean(R.mipmap.pic3, "古典美女,等比例人形,2030年爆款,限额三百件,先到先得,售完为止", 999, 177, "店铺优惠,满100送1000"));
            beans.add(new GoodsBean(R.mipmap.pic6, "珍藏,非卖品", 9999999, 1));
            beans.add(new GoodsBean(R.mipmap.pic2, "黑夜皮肤,附加魔法加成,2030年爆款,限额三百件,先到先得,售完为止", 8888, 277, "店铺优惠,满100送100000"));


            beans.add(new GoodsBean(R.mipmap.pic5, "买洞爷湖送银时,只要998,绝对良心价,2030年爆款,限额三百件,先到先得,售完为止", 998, 277, "店铺优惠,满100送100000"));

        }

        return beans;
    }

    public static List<IconInfo> getIconsInfo() {
        List<IconInfo> beans = new ArrayList<>();

        beans.add(new IconInfo(R.drawable.icon_t, "todo"));
        beans.add(new IconInfo(R.drawable.icon_o, "open"));
        beans.add(new IconInfo(R.drawable.icon_l, "love"));
        beans.add(new IconInfo(R.drawable.icon_y, "yes"));
        beans.add(new IconInfo(R.drawable.icon_a, "about"));
        beans.add(new IconInfo(R.drawable.icon_b, "below"));
        beans.add(new IconInfo(R.drawable.icon_c, "care"));
        beans.add(new IconInfo(R.drawable.icon_d, "dall"));
        beans.add(new IconInfo(R.drawable.icon_e, "exe"));
        beans.add(new IconInfo(R.drawable.icon_f, "fox"));
        return beans;
    }

    /**
     * 获取随机聊天消息
     * @return
     */
    public static List<MsgBean> getMsgBeans() {
        List<MsgBean> beans = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            if (i % 10 == 0) {
                beans.add(new MsgBean(2, ""));
                continue;
            }
            beans.add(new MsgBean(ZRandom.rangeInt(0, 1),
                    ZRandom.randomChar(ZData.congcong, 100)));
        }
        return beans;
    }


}
