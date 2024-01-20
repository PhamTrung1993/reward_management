package com.exercise.reward_management.utils;

import com.google.common.base.CharMatcher;
import lombok.extern.log4j.Log4j2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j2
public class Validate {
    public static boolean isValidPhoneNumber(String phoneNumber) {
        try {
            String regex = "^(\\+?84|0)(3[2-9]|5[689]|7[0-9]|8[1-9]|9[0-9])[0-9]{7}$";

            Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(phoneNumber);

            return matcher.matches();
        } catch (Exception e) {
            log.error("VALIDATE PhoneNumber: " + e.getMessage(), phoneNumber);
            return false;
        }
    }

    public static String trim(String needToTrimString) {
        if (needToTrimString == null) {
            return "";
        }
        return CharMatcher.whitespace().trimFrom(needToTrimString);
    }
}
