package com.mycarhz.myhz.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 */
public class Clientbean {

    /**
     * error : -1
     * teamList : [{"phone":"15062224370","sort":1,"post":"资深投资人，通过宝易得平台累计投资金额超过300万元","hasInterest":0,"publishTime":{"date":12,"day":5,"hours":14,"minutes":11,"month":5,"nanos":0,"seconds":15,"time":1434089475000,"timezoneOffset":-480,"year":115},"state":1,"good":"企业管理投资理财","intro":"多萨达<span style=\"line-height:22px;font-family:微软雅黑, 黑体;color:#666666;font-size:14px;\">轻松打算撒好可怜发烧发烧vxzjxzzcxljosfdsdafasd\u2019pf 但很快sad卡拉萨达哈坎松放大范德萨范德萨of撒 加大税收负担好可怜撒啊方式 地方撒理发师立法哦啊分【飞机撒飞机阿斯兰发酵饲料发哦额are龙口粉丝大呼飞洒李开复的撒娇开发商<\/span>","id":1,"num":5,"avgDay":25,"imgPath":"upload/team/20160624/201606240936099443.PNG","userName":"徐伟","qq":"285359505"}]
     * msg : 成功
     */

    private String error;
    private String msg;
    /**
     * phone : 15062224370
     * sort : 1
     * post : 资深投资人，通过宝易得平台累计投资金额超过300万元
     * hasInterest : 0
     * publishTime : {"date":12,"day":5,"hours":14,"minutes":11,"month":5,"nanos":0,"seconds":15,"time":1434089475000,"timezoneOffset":-480,"year":115}
     * state : 1
     * good : 企业管理投资理财
     * intro : 多萨达<span style="line-height:22px;font-family:微软雅黑, 黑体;color:#666666;font-size:14px;">轻松打算撒好可怜发烧发烧vxzjxzzcxljosfdsdafasd’pf 但很快sad卡拉萨达哈坎松放大范德萨范德萨of撒 加大税收负担好可怜撒啊方式 地方撒理发师立法哦啊分【飞机撒飞机阿斯兰发酵饲料发哦额are龙口粉丝大呼飞洒李开复的撒娇开发商</span>
     * id : 1
     * num : 5
     * avgDay : 25
     * imgPath : upload/team/20160624/201606240936099443.PNG
     * userName : 徐伟
     * qq : 285359505
     */

    private List<TeamListBean> teamList;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<TeamListBean> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<TeamListBean> teamList) {
        this.teamList = teamList;
    }

    public static class TeamListBean {
        private String phone;
        private int sort;
        private String post;
        private int hasInterest;
        /**
         * date : 12
         * day : 5
         * hours : 14
         * minutes : 11
         * month : 5
         * nanos : 0
         * seconds : 15
         * time : 1434089475000
         * timezoneOffset : -480
         * year : 115
         */

        private PublishTimeBean publishTime;
        private int state;
        private String good;
        private String intro;
        private int id;
        private int num;
        private int avgDay;
        private String imgPath;
        private String userName;
        private String qq;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getPost() {
            return post;
        }

        public void setPost(String post) {
            this.post = post;
        }

        public int getHasInterest() {
            return hasInterest;
        }

        public void setHasInterest(int hasInterest) {
            this.hasInterest = hasInterest;
        }

        public PublishTimeBean getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(PublishTimeBean publishTime) {
            this.publishTime = publishTime;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getGood() {
            return good;
        }

        public void setGood(String good) {
            this.good = good;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getAvgDay() {
            return avgDay;
        }

        public void setAvgDay(int avgDay) {
            this.avgDay = avgDay;
        }

        public String getImgPath() {
            return imgPath;
        }

        public void setImgPath(String imgPath) {
            this.imgPath = imgPath;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public static class PublishTimeBean {
            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int nanos;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getNanos() {
                return nanos;
            }

            public void setNanos(int nanos) {
                this.nanos = nanos;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }
    }

    @Override
    public String toString() {
        return "Clientbean{" +
                "error='" + error + '\'' +
                ", msg='" + msg + '\'' +
                ", teamList=" + teamList +
                '}';
    }
}
