package com.mycarhz.myhz.constant;

/**
 * Created by Administrator on 2016/9/2.
 */
public class Constant {
    public static final String BASE="http://192.168.199.154:8080/";//服务器地址


    public static final String LOGIN=BASE+"app/login.do";//登录
    public static final String SEND_SMS =BASE+"app/sendSMS.do";//获取短信验证码
    public static final String  REGISTER=BASE+"app/register.do";//获取短信验证码
    public static final String  ACCOUNT_INFORMATION=BASE+"app/queryHome.do";//用户登陆后账户信息接口
    public static final String  UP_DATE_LOGIN_PWD=BASE+"app/updateLoginPwd.do";//用户登陆后修改登陆密码
    public static final String  JZH_REGISTER="app/appOpen.do";//金账户开户
    public static final String  JZH_TOPUP="app/appRecharge.do";//金账户开户
    public static final String  FUND_XM=BASE+"app/queryInvestList.do";//众筹项目
    public static final String  LUNBO=BASE+"/app/queryBannerList.do";//轮播图
    public static final String  ZIJINJILU=BASE+"/app/queryFundsRecodeList.do";//资金记录
    public static final String  CLIENT=BASE+"/app/queryTeam.do";//委托人列表
}
