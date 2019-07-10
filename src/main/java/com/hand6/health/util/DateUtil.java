package com.hand6.health.util;/**
 * Created by Administrator on 2019/7/9.
 */

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xxxx
 * @description
 * @date 2019/7/9
 */
public class DateUtil {

    // 获得当前周- 周一的日期
    public static Date getMondayOfThisWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;}
            c.add(Calendar.DATE, -day_of_week + 1);
            return c.getTime();
        }

    /**
     * 得到本周周日
     * @param date
     */
    public static Date getSundayOfThisWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0){
            day_of_week = 7;}
        c.add(Calendar.DATE, -day_of_week + 7);
        return c.getTime();
    }


    public static void main(String[] args) throws Exception {
       System.out.println(DateUtil.getMondayOfThisWeek(new Date()));
       System.out.println(DateUtil.getSundayOfThisWeek(new Date()));
    }

}
