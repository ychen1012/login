package com.imtoocai.diary.util;

import org.springframework.stereotype.Service;


public class CodeUtil {
    public static String getCode() {

        int intFlag = (int) (Math.random() * 1000000);

        String flag = String.valueOf(intFlag);
        if (flag.length() == 6 && flag.substring(0, 1).equals("9")) {
            return flag;
        } else {
            intFlag = intFlag + 100000;
            return String.valueOf(intFlag);
        }
    }

}

