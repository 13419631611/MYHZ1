package com.mycarhz.myhz.utils;

/**
 * Created by Administrator on 2016/8/26.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/8/24.
 */
public class StringUtils {


    /* 说明：移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
          * 联通：130、131、132、152、155、156、185、186
          * 电信：133、153、180、189
          * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
          * 验证号码 手机号 固话均可
          */
    public static boolean isPhoneNumberValid(String phoneNumber) {
        boolean isValid = false;

        String expression = "^1[34578]\\d{9}$";
        CharSequence inputStr = phoneNumber;

        Pattern pattern = Pattern.compile(expression);

        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches() ) {
            isValid = true;
        }

        return isValid;

    }


}
