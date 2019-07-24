package com.hand6.health.util;/**
 * Created by Administrator on 2019/7/9.
 */

import com.hand6.health.common.ConstantUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xxxx
 * @description
 * @date 2019/7/9
 */
public class DateUtil {
    public static final long MILLIS_PER_SECOND = 1000L;
    public static final long MILLIS_PER_MINUTE = 60000L;
    public static final long MILLIS_PER_HOUR = 3600000L;
    public static final long MILLIS_PER_DAY = 86400000L;
    public static final int[] MONTH_LENGTH = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static final String yyyyMMddSimple = "yyyyMMdd";
    public static final String yyyyMMdd = "yyyy-MM-dd";
    public static final String yyyyMM = "yyyy-MM";
    public static final String yyyyMMddSTANDARD = "yyyy年MM月dd日";
    public static final String yyyyMMddHH24 = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyyMMddSlash = "yyyy/MM/dd";
    public static final String yyyyMMddHH24Slash = "yyyy/MM/dd HH:mm:ss";
    public static final String CST = "EEE MMM dd HH:mm:ss zzz yyyy";
    private static final SimpleDateFormat formatYMD = new SimpleDateFormat("yyyy/MM/dd");
    private static final SimpleDateFormat formatYMD24 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final SimpleDateFormat formatYMDSimple = new SimpleDateFormat("yyyyMMdd");
    private static final SimpleDateFormat formatYMDStd = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat formatYMD24Std = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat formatYMD24Slash = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final SimpleDateFormat formatYMDSlash = new SimpleDateFormat("yyyy/MM/dd");

    private static Map<String, SimpleDateFormat> formats;

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

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }

    /**
     * 获取未来 第 past 天的日期
     * @param past
     * @return
     */
    public static String getFetureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }

    public static String date2Str(Date date, String pattern) {
        String dateStr = null;
        if(date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            dateStr = sdf.format(date);
        }
        return dateStr;
    }

    /**
     * 将时间转化为秒；时间记录方式为00.9.00/9.00
     * @param time
     * @return
     */
    public static BigDecimal StringToSecond(String time){
        String[] indicatorsTime = time.split("\\.");
        BigDecimal timeToS=new BigDecimal(0);
        if (indicatorsTime.length>2){
            timeToS = BigDecimal.valueOf(Integer.parseInt(indicatorsTime[0])*60*60+Integer.parseInt(indicatorsTime[1])*60+Integer.parseInt(indicatorsTime[2]));
        } else {
            timeToS = BigDecimal.valueOf(Integer.parseInt(indicatorsTime[0])*60+Integer.parseInt(indicatorsTime[1]));
        }
        return timeToS;
    }
    /**
     * 将秒转化为字符串的形式
     * @param time
     * @return
     */
    public static String Second2String(BigDecimal time){
        StringBuilder timeToS = new StringBuilder();
        BigDecimal c[]=time.divideAndRemainder(ConstantUtil.TIME_CONVERSION);
        if (c[0].compareTo(ConstantUtil.TIME_CONVERSION)!=-1){
            BigDecimal d[]=c[0].divideAndRemainder(ConstantUtil.TIME_CONVERSION);
            timeToS = timeToS.append(d[0]).append('.').append(d[1]).append('.').append(c[1]);
        } else {
            timeToS = timeToS.append(c[0]).append('.').append(c[1]);
        }
        return String.valueOf(timeToS);
    }

    public static void main(String[] args) throws Exception {
       System.out.println(DateUtil.Second2String(new BigDecimal(338)));
        System.out.println(DateUtil.StringToSecond("20.58").add(DateUtil.StringToSecond("13.58")));
    }

}
