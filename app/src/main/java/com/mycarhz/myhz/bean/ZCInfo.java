package com.mycarhz.myhz.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/5.
 */
public class ZCInfo {


    /**
     * error : -1
     * pageBean : {"page":[{"paymentMode":4,"setDuein":0,"borrowWay":3,"borrowShow":1,"openTime":-1473059252,"purpose":10,"id":64,"vip":1,"username":"13986200253","isDayThe":2,"imgPath":"images/pro2.jpg","hasPWD":-1,"credit":1,"isRecommend":1,"borrowTitle":"第十期众筹项目\u2014\u2014保时捷Boxster","borrowStatus":4,"schedules":"100.00","investAll":"2","vipStatus":1,"publishTime":{"date":18,"day":1,"hours":13,"minutes":51,"month":0,"nanos":0,"seconds":17,"time":1453096277000,"timezoneOffset":-480,"year":116},"investNum":"0.00","creditrating":0,"borrow_num":"20160118135046","excitationSum":0,"minTenderedSum":100,"borrowAmount":"1.08","annualRate":12,"excitationType":1,"deadline":3,"util":"万"},{"paymentMode":4,"setDuein":0,"borrowWay":3,"borrowShow":1,"openTime":-1473059252,"purpose":17,"id":5,"vip":1,"username":"PCWR20151016111314837","isDayThe":2,"imgPath":"images/pro3.jpg","hasPWD":-1,"credit":1,"isRecommend":2,"borrowTitle":"哇车宝C20151030-01","borrowStatus":5,"schedules":"100.00","investAll":"7","vipStatus":1,"publishTime":{"date":30,"day":5,"hours":14,"minutes":16,"month":9,"nanos":0,"seconds":45,"time":1446185805000,"timezoneOffset":-480,"year":115},"investNum":"0.00","creditrating":1,"borrow_num":"20151030140928","excitationSum":0,"minTenderedSum":100,"borrowAmount":"21.00","annualRate":8,"excitationType":1,"deadline":15,"util":"万"},{"paymentMode":4,"setDuein":0,"borrowWay":3,"borrowShow":1,"openTime":-1473059252,"purpose":17,"id":4,"vip":1,"username":"PCWR20151016111314837","isDayThe":2,"imgPath":"images/pro3.jpg","hasPWD":-1,"credit":1,"isRecommend":2,"borrowTitle":"哇车宝C20151016-02","borrowStatus":4,"schedules":"100.00","investAll":"18","vipStatus":1,"publishTime":{"date":16,"day":5,"hours":16,"minutes":23,"month":9,"nanos":0,"seconds":15,"time":1444983795000,"timezoneOffset":-480,"year":115},"investNum":"0.00","creditrating":1,"borrow_num":"20151016162231","excitationSum":0,"minTenderedSum":100,"borrowAmount":"25.90","annualRate":8,"excitationType":1,"deadline":15,"util":"万"}],"pageNum":1,"pageSize":20,"startOfPage":0,"totalNum":3,"totalPageNum":1}
     * msg : 成功
     */

    private String error;
    /**
     * page : [{"paymentMode":4,"setDuein":0,"borrowWay":3,"borrowShow":1,"openTime":-1473059252,"purpose":10,"id":64,"vip":1,"username":"13986200253","isDayThe":2,"imgPath":"images/pro2.jpg","hasPWD":-1,"credit":1,"isRecommend":1,"borrowTitle":"第十期众筹项目\u2014\u2014保时捷Boxster","borrowStatus":4,"schedules":"100.00","investAll":"2","vipStatus":1,"publishTime":{"date":18,"day":1,"hours":13,"minutes":51,"month":0,"nanos":0,"seconds":17,"time":1453096277000,"timezoneOffset":-480,"year":116},"investNum":"0.00","creditrating":0,"borrow_num":"20160118135046","excitationSum":0,"minTenderedSum":100,"borrowAmount":"1.08","annualRate":12,"excitationType":1,"deadline":3,"util":"万"},{"paymentMode":4,"setDuein":0,"borrowWay":3,"borrowShow":1,"openTime":-1473059252,"purpose":17,"id":5,"vip":1,"username":"PCWR20151016111314837","isDayThe":2,"imgPath":"images/pro3.jpg","hasPWD":-1,"credit":1,"isRecommend":2,"borrowTitle":"哇车宝C20151030-01","borrowStatus":5,"schedules":"100.00","investAll":"7","vipStatus":1,"publishTime":{"date":30,"day":5,"hours":14,"minutes":16,"month":9,"nanos":0,"seconds":45,"time":1446185805000,"timezoneOffset":-480,"year":115},"investNum":"0.00","creditrating":1,"borrow_num":"20151030140928","excitationSum":0,"minTenderedSum":100,"borrowAmount":"21.00","annualRate":8,"excitationType":1,"deadline":15,"util":"万"},{"paymentMode":4,"setDuein":0,"borrowWay":3,"borrowShow":1,"openTime":-1473059252,"purpose":17,"id":4,"vip":1,"username":"PCWR20151016111314837","isDayThe":2,"imgPath":"images/pro3.jpg","hasPWD":-1,"credit":1,"isRecommend":2,"borrowTitle":"哇车宝C20151016-02","borrowStatus":4,"schedules":"100.00","investAll":"18","vipStatus":1,"publishTime":{"date":16,"day":5,"hours":16,"minutes":23,"month":9,"nanos":0,"seconds":15,"time":1444983795000,"timezoneOffset":-480,"year":115},"investNum":"0.00","creditrating":1,"borrow_num":"20151016162231","excitationSum":0,"minTenderedSum":100,"borrowAmount":"25.90","annualRate":8,"excitationType":1,"deadline":15,"util":"万"}]
     * pageNum : 1
     * pageSize : 20
     * startOfPage : 0
     * totalNum : 3
     * totalPageNum : 1
     */

    private PageBeanBean pageBean;
    private String msg;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public PageBeanBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBeanBean pageBean) {
        this.pageBean = pageBean;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class PageBeanBean {
        private int pageNum;
        private int pageSize;
        private int startOfPage;
        private int totalNum;
        private int totalPageNum;
        /**
         * paymentMode : 4
         * setDuein : 0
         * borrowWay : 3
         * borrowShow : 1
         * openTime : -1473059252
         * purpose : 10
         * id : 64
         * vip : 1
         * username : 13986200253
         * isDayThe : 2
         * imgPath : images/pro2.jpg
         * hasPWD : -1
         * credit : 1
         * isRecommend : 1
         * borrowTitle : 第十期众筹项目——保时捷Boxster
         * borrowStatus : 4
         * schedules : 100.00
         * investAll : 2
         * vipStatus : 1
         * publishTime : {"date":18,"day":1,"hours":13,"minutes":51,"month":0,"nanos":0,"seconds":17,"time":1453096277000,"timezoneOffset":-480,"year":116}
         * investNum : 0.00
         * creditrating : 0
         * borrow_num : 20160118135046
         * excitationSum : 0
         * minTenderedSum : 100
         * borrowAmount : 1.08
         * annualRate : 12
         * excitationType : 1
         * deadline : 3
         * util : 万
         */

        private List<PageBean> page;

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getStartOfPage() {
            return startOfPage;
        }

        public void setStartOfPage(int startOfPage) {
            this.startOfPage = startOfPage;
        }

        public int getTotalNum() {
            return totalNum;
        }

        public void setTotalNum(int totalNum) {
            this.totalNum = totalNum;
        }

        public int getTotalPageNum() {
            return totalPageNum;
        }

        public void setTotalPageNum(int totalPageNum) {
            this.totalPageNum = totalPageNum;
        }

        public List<PageBean> getPage() {
            return page;
        }

        public void setPage(List<PageBean> page) {
            this.page = page;
        }

        public static class PageBean {
            private int paymentMode;
            private int setDuein;
            private int borrowWay;
            private int borrowShow;
            private int openTime;
            private int purpose;
            private int id;
            private int vip;
            private String username;
            private int isDayThe;
            private String imgPath;
            private int hasPWD;
            private int credit;
            private int isRecommend;
            private String borrowTitle;
            private int borrowStatus;
            private String schedules;
            private String investAll;
            private int vipStatus;

            @Override
            public String toString() {
                return "PageBean{" +
                        "paymentMode=" + paymentMode +
                        ", setDuein=" + setDuein +
                        ", borrowWay=" + borrowWay +
                        ", borrowShow=" + borrowShow +
                        ", openTime=" + openTime +
                        ", purpose=" + purpose +
                        ", id=" + id +
                        ", vip=" + vip +
                        ", username='" + username + '\'' +
                        ", isDayThe=" + isDayThe +
                        ", imgPath='" + imgPath + '\'' +
                        ", hasPWD=" + hasPWD +
                        ", credit=" + credit +
                        ", isRecommend=" + isRecommend +
                        ", borrowTitle='" + borrowTitle + '\'' +
                        ", borrowStatus=" + borrowStatus +
                        ", schedules='" + schedules + '\'' +
                        ", investAll='" + investAll + '\'' +
                        ", vipStatus=" + vipStatus +
                        ", publishTime=" + publishTime +
                        ", investNum='" + investNum + '\'' +
                        ", creditrating=" + creditrating +
                        ", borrow_num='" + borrow_num + '\'' +
                        ", excitationSum=" + excitationSum +
                        ", minTenderedSum=" + minTenderedSum +
                        ", borrowAmount='" + borrowAmount + '\'' +
                        ", annualRate=" + annualRate +
                        ", excitationType=" + excitationType +
                        ", deadline=" + deadline +
                        ", util='" + util + '\'' +
                        '}';
            }

            /**
             * date : 18
             * day : 1
             * hours : 13
             * minutes : 51
             * month : 0
             * nanos : 0
             * seconds : 17
             * time : 1453096277000
             * timezoneOffset : -480
             * year : 116
             */



            private PublishTimeBean publishTime;
            private String investNum;
            private int creditrating;
            private String borrow_num;
            private int excitationSum;
            private int minTenderedSum;
            private String borrowAmount;
            private int annualRate;
            private int excitationType;
            private int deadline;
            private String util;

            public int getPaymentMode() {
                return paymentMode;
            }

            public void setPaymentMode(int paymentMode) {
                this.paymentMode = paymentMode;
            }

            public int getSetDuein() {
                return setDuein;
            }

            public void setSetDuein(int setDuein) {
                this.setDuein = setDuein;
            }

            public int getBorrowWay() {
                return borrowWay;
            }

            public void setBorrowWay(int borrowWay) {
                this.borrowWay = borrowWay;
            }

            public int getBorrowShow() {
                return borrowShow;
            }

            public void setBorrowShow(int borrowShow) {
                this.borrowShow = borrowShow;
            }

            public int getOpenTime() {
                return openTime;
            }

            public void setOpenTime(int openTime) {
                this.openTime = openTime;
            }

            public int getPurpose() {
                return purpose;
            }

            public void setPurpose(int purpose) {
                this.purpose = purpose;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getVip() {
                return vip;
            }

            public void setVip(int vip) {
                this.vip = vip;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public int getIsDayThe() {
                return isDayThe;
            }

            public void setIsDayThe(int isDayThe) {
                this.isDayThe = isDayThe;
            }

            public String getImgPath() {
                return imgPath;
            }

            public void setImgPath(String imgPath) {
                this.imgPath = imgPath;
            }

            public int getHasPWD() {
                return hasPWD;
            }

            public void setHasPWD(int hasPWD) {
                this.hasPWD = hasPWD;
            }

            public int getCredit() {
                return credit;
            }

            public void setCredit(int credit) {
                this.credit = credit;
            }

            public int getIsRecommend() {
                return isRecommend;
            }

            public void setIsRecommend(int isRecommend) {
                this.isRecommend = isRecommend;
            }

            public String getBorrowTitle() {
                return borrowTitle;
            }

            public void setBorrowTitle(String borrowTitle) {
                this.borrowTitle = borrowTitle;
            }

            public int getBorrowStatus() {
                return borrowStatus;
            }

            public void setBorrowStatus(int borrowStatus) {
                this.borrowStatus = borrowStatus;
            }

            public String getSchedules() {
                return schedules;
            }

            public void setSchedules(String schedules) {
                this.schedules = schedules;
            }

            public String getInvestAll() {
                return investAll;
            }

            public void setInvestAll(String investAll) {
                this.investAll = investAll;
            }

            public int getVipStatus() {
                return vipStatus;
            }

            public void setVipStatus(int vipStatus) {
                this.vipStatus = vipStatus;
            }

            public PublishTimeBean getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(PublishTimeBean publishTime) {
                this.publishTime = publishTime;
            }

            public String getInvestNum() {
                return investNum;
            }

            public void setInvestNum(String investNum) {
                this.investNum = investNum;
            }

            public int getCreditrating() {
                return creditrating;
            }

            public void setCreditrating(int creditrating) {
                this.creditrating = creditrating;
            }

            public String getBorrow_num() {
                return borrow_num;
            }

            public void setBorrow_num(String borrow_num) {
                this.borrow_num = borrow_num;
            }

            public int getExcitationSum() {
                return excitationSum;
            }

            public void setExcitationSum(int excitationSum) {
                this.excitationSum = excitationSum;
            }

            public int getMinTenderedSum() {
                return minTenderedSum;
            }

            public void setMinTenderedSum(int minTenderedSum) {
                this.minTenderedSum = minTenderedSum;
            }

            public String getBorrowAmount() {
                return borrowAmount;
            }

            public void setBorrowAmount(String borrowAmount) {
                this.borrowAmount = borrowAmount;
            }

            public int getAnnualRate() {
                return annualRate;
            }

            public void setAnnualRate(int annualRate) {
                this.annualRate = annualRate;
            }

            public int getExcitationType() {
                return excitationType;
            }

            public void setExcitationType(int excitationType) {
                this.excitationType = excitationType;
            }

            public int getDeadline() {
                return deadline;
            }

            public void setDeadline(int deadline) {
                this.deadline = deadline;
            }

            public String getUtil() {
                return util;
            }

            public void setUtil(String util) {
                this.util = util;
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
    }
}
