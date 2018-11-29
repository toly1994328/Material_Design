//package com.toly1994.vvi_mds.v02_card;
//
//import com.google.gson.Gson;
//
//import java.util.List;
//
///**
// * 作者：张风捷特烈<br/>
// * 时间：2018/8/30 0030:23:39<br/>
// * 邮箱：1981462002@qq.com<br/>
// * 说明：
// */
//public class Poem {
//
//    /**
//     * code : 200
//     * msg : 操作成功
//     * data : [{"id":1,"author":"张风捷特烈","title":"《海与鹿王》","info":"至敬那些永无止境前行的王者。","content":"海与鹿王","imgURL":"poem/海与鹿王.jpg","seeNum":"0","createTime":"2018-08-30T14:29:49.000+0000","editeTime":"2018-08-30T14:29:49.000+0000"},{"id":2,"author":"张风捷特烈","title":"《游梦人·诗的诞生》","info":"海的彼岸,有我未曾见证的风采","content":"游梦人·诗的诞生","imgURL":"poem/游梦人·诗的诞生.jpg","seeNum":"0","createTime":"2018-08-30T15:02:09.000+0000","editeTime":"2018-08-30T15:02:09.000+0000"}]
//     */
//
//    private int code;
//    private String msg;
//    private List<DataBean> data;
//
//    public static Poem objectFromData(String str) {
//
//        return new Gson().fromJson(str, Poem.class);
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public List<DataBean> getData() {
//        return data;
//    }
//
//    public void setData(List<DataBean> data) {
//        this.data = data;
//    }
//
//    public static class DataBean {
//        /**
//         * id : 1
//         * author : 张风捷特烈
//         * title : 《海与鹿王》
//         * info : 至敬那些永无止境前行的王者。
//         * content : 海与鹿王
//         * imgURL : poem/海与鹿王.jpg
//         * seeNum : 0
//         * createTime : 2018-08-30T14:29:49.000+0000
//         * editeTime : 2018-08-30T14:29:49.000+0000
//         */
//
//        private int id;
//        private String author;
//        private String title;
//        private String info;
//        private String content;
//        private String imgURL;
//        private String seeNum;
//        private String createTime;
//        private String editeTime;
//
//        public static DataBean objectFromData(String str) {
//
//            return new Gson().fromJson(str, DataBean.class);
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getAuthor() {
//            return author;
//        }
//
//        public void setAuthor(String author) {
//            this.author = author;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public String getInfo() {
//            return info;
//        }
//
//        public void setInfo(String info) {
//            this.info = info;
//        }
//
//        public String getContent() {
//            return content;
//        }
//
//        public void setContent(String content) {
//            this.content = content;
//        }
//
//        public String getImgURL() {
//            return imgURL;
//        }
//
//        public void setImgURL(String imgURL) {
//            this.imgURL = imgURL;
//        }
//
//        public String getSeeNum() {
//            return seeNum;
//        }
//
//        public void setSeeNum(String seeNum) {
//            this.seeNum = seeNum;
//        }
//
//        public String getCreateTime() {
//            return createTime;
//        }
//
//        public void setCreateTime(String createTime) {
//            this.createTime = createTime;
//        }
//
//        public String getEditeTime() {
//            return editeTime;
//        }
//
//        public void setEditeTime(String editeTime) {
//            this.editeTime = editeTime;
//        }
//
//
//    }
//
//}
