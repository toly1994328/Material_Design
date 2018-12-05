package com.toly1994.test.bean;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/3 0003:16:22<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：消息的实体类
 */
public class MsgBean {


    private int type;//类型：0 我  1 他 2 时间

    private String msg;//信息体

    public MsgBean(int type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
