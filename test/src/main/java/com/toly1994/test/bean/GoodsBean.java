package com.toly1994.test.bean;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/4 0004:8:43<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：商品的实体类
 */
public class GoodsBean {

    private int imgId; //资源id
    private String info; //详情
    private float price;//价格
    private int buyNum;//购买人数
    private String ticket;//优惠券

    public GoodsBean() {
    }

    public GoodsBean(int imgId, String info, float price, int buyNum) {
        this.imgId = imgId;
        this.info = info;
        this.price = price;
        this.buyNum = buyNum;
    }

    public GoodsBean(int imgId, String info, float price, int buyNum, String ticket) {
        this.imgId = imgId;
        this.info = info;
        this.price = price;
        this.buyNum = buyNum;
        this.ticket = ticket;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
