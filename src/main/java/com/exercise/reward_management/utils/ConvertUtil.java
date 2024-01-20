package com.exercise.reward_management.utils;

public class ConvertUtil {

    public static Long MOBILE_09X = 10L;
    public static Long MOBILE_9X = 9L;
    public static Long MOBILE_849X = 11L;
    public static String REGEX = "[^0-9]";

    public static String formatMobileNumber(String phone, Long type) {
        phone = phone.replaceAll("@[^0-9]@","");
        if (type == MOBILE_09X) {
            if ("0".equals(phone.substring(0,1))){
                //nothing
            } else if ("84".equals(phone.substring(0,2))) {
                phone = "0" + phone.substring(2);
            } else {
                phone = "0" + phone;
            }
        } else if(type == MOBILE_849X) {
            if ("0".equals(phone.substring(0,1))){
                phone = "84" + phone.substring(1);
            } else if ("84".equals(phone.substring(0,2))) {
                //nothing
            } else {
                phone = "84" + phone;
            }
        } else if(type == MOBILE_9X){
            if ("0".equals(phone.substring(0,1))){
                phone = phone.substring(1);
            } else if ("84".equals(phone.substring(0,2))) {
                phone.substring(2);
            } else {
                //nothing
            }
        }
        return phone;
    }
}
