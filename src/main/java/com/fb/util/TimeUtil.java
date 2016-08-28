package com.fb.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 时间/日期工具类
 *
 * @author
 * @version 1.0, Mar 18, 2009
 */
public class TimeUtil {

    private static final Logger logger = LoggerFactory.getLogger(TimeUtil.class);

    private static final String EMPTY = "";

    /** yyyy-MM-dd HH:mm:ss */
    public static final String TARGET_1 = "yyyy-MM-dd HH:mm:ss";

    /** yyyy-MM-dd HH:mm */
    public static final String TARGET_2 = "yyyy-MM-dd HH:mm";

    /** yyyy-MM-dd */
    public static final String TARGET_3 = "yyyy-MM-dd";

    /** yyyy年MM月dd日 */
    public static final String TARGET_4 = "yyyy年MM月dd日";

    /** yyyyMMddHHmmss */
    public static final String SOURCE_1 = "yyyyMMddHHmmss";

    /** yyyyMMdd */
    public static final String SOURCE_2 = "yyyyMMdd";

    /**
     * 格式化时间,从一种格式转变为另一种格式 <p> 如果源时间对象为String类型，那么认为源格式为 yyyyMMddHHmmss <p> 目标格式为 yyyy-MM-dd HH:mm:ss
     *
     * @param source 源时间对象，可以为String或是Date类型
     * @return 格式化后的时间字符串，有任何错误返回空字符串
     */
    public static String format(Object source) {
        return format(source, null, null, null);
    }

    /**
     * 格式化时间,从一种格式转变为另一种格式 <p> 如果源时间对象为String类型，那么认为源格式为 yyyyMMddHHmmss
     *
     * @param source 源时间对象，可以为String或是Date类型
     * @param tfmt 返回的目标格式
     * @return 格式化后的时间字符串，有任何错误返回空字符串
     */
    public static String format(Object source, String tfmt) {
        return format(source, null, tfmt, null);
    }

    /**
     * 格式化时间,从一种格式转变为另一种格式，源时间对象为空的话返回空字符串
     *
     * @param source 源时间对象，可以为String或是Date类型
     * @param sfmt 源格式，如果source为Date类型，则此参数无用
     * @param tfmt 返回的目标格式
     * @return 格式化后的时间字符串，有任何错误返回空字符串
     */
    public static String format(Object source, String sfmt, String tfmt) {
        return format(source, sfmt, tfmt, null);
    }

    /**
     * 格式化时间,从一种格式转变为另一种格式
     *
     * @param source 源时间对象，可以为String或是Date类型
     * @param sfmt 源格式，如果source为Date类型，则此参数无用
     * @param tfmt 返回的目标格式
     * @param nullval 如果源为null的话返回的默认值
     * @return 格式化后的时间字符串，有任何错误返回空字符串
     */
    public static String format(Object source, String sfmt, String tfmt, String nullval) {
        tfmt = (tfmt == null) ? TARGET_1 : tfmt;
        sfmt = (sfmt == null) ? SOURCE_1 : sfmt;

        SimpleDateFormat sdf = new SimpleDateFormat(tfmt);
        try {
            if (source == null) {
                return (nullval == null) ? EMPTY : nullval;
            } else if (source instanceof String) {
                SimpleDateFormat parseformat = new SimpleDateFormat(sfmt);
                return sdf.format(parseformat.parse((String) source));
            } else {
                return sdf.format(source);
            }
        } catch (ParseException e) {
            if (logger.isDebugEnabled()) {
                logger.debug("Source Parse Exception: source=" + source + ", sfmt=" + sfmt + ", tfmt=" + tfmt, e);
            }
        } catch (IllegalArgumentException e) {
            if (logger.isDebugEnabled()) {
                logger.debug("Illegal Source Exception: source=" + source + ", sfmt=" + sfmt + ", tfmt=" + tfmt, e);
            }
        } catch (Exception e) {
            if (logger.isDebugEnabled()) {
                logger.debug("Exception: source=" + source + ", sfmt=" + sfmt + ", tfmt=" + tfmt, e);
            }
        }
        return EMPTY;
    }

    /**
     * 返回当前时间
     *
     * @return yyyyMMddHHmmss格式的当前时间字符串
     */
    public static String now() {
        return now(SOURCE_1);
    }

    /**
     * 返回当前日期
     * @return yyyyMMdd格式的当前时间字符串
     */
    public static String nowDate(){
        return now(SOURCE_2);
    }

    /**
     * 返回当前时间
     *
     * @param fmt 格式化字符
     * @return fmt指定样式的当前时间字符串
     */
    public static String now(String fmt) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        return sdf.format(cal.getTime());
    }

    /**
     * 获得指定时间之后或者之前N小时的14位时间字符串
     * @param strTime
     * @param hours
     * @return
     */
    public static String addHours(String strTime,int hours){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            Date d = sdf.parse(strTime);
            return TimeUtil.format(DateUtils.addHours(d, hours),SOURCE_1);
        }
        catch (ParseException e) {
            return "";
        }
    }

    public static String addMinutes(String strTime,int amount){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            Date d = sdf.parse(strTime);
            return TimeUtil.format(DateUtils.addMinutes(d, amount),SOURCE_1);
        }
        catch (ParseException e) {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(TimeUtil.addMinutes("20121212090000", 30));
        System.out.println(compareTime(TimeUtil.addMinutes("20121212090000", 30),"20121212090000"));
    }

    public static int compareTime(String date1,String date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            Date d1 = sdf.parse(date1);
            Date d2 = sdf.parse(date2);
            return d1.compareTo(d2);
        }
        catch (ParseException e) {
            return -2;
        }
    }

    /**
     * 获得指定时间之后或者之前N天的14位时间字符串
     * @param strTime 处理的比较时间，14位时间字符串
     * @param days N天，可以是负数
     * @return 14位时间字符串
     */
    public static String addDays(String strTime,int days){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            Date d = sdf.parse(strTime);
            return TimeUtil.format(DateUtils.addDays(d,days),SOURCE_1);
        }
        catch (ParseException e) {
            return "";
        }
    }
    public static String addDays(int days){
        Calendar cal = Calendar.getInstance();
        return TimeUtil.addDays(cal.getTime(),days);
    }
    public static String addDays(Date d,int days){
        return TimeUtil.format(DateUtils.addDays(d,days),SOURCE_1);
    }

    /**
     * 获得指定时间之后的N月的14位时间字符串
     * @param strTime
     * @param m
     * @return 14位时间字符串，异常返回空字符串
     */
    public static String addMonths(String strTime,int m){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            Date d = sdf.parse(strTime);
            return TimeUtil.format(DateUtils.addMonths(d,m),SOURCE_1);
        }
        catch (ParseException e) {
            return "";
        }
    }

    public static String addMonths(int m){
        Calendar cal = Calendar.getInstance();
        return TimeUtil.addMonths(cal.getTime(),m);
    }

    public static String addMonths(Date d,int m){
        return TimeUtil.format(DateUtils.addMonths(d, m),SOURCE_1);
    }

    /**
     * 获得指定年之后N年的14位时间字符串
     * @param strTime 14时间字符串
     * @param years N年，可以是负数
     * @return 14位时间字符串
     */
    public static String addYears(String strTime,int years){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            Date d = sdf.parse(strTime);
            return TimeUtil.format(DateUtils.addYears(d,years),SOURCE_1);
        }
        catch (ParseException e) {
            return strTime;
        }
    }
    public static String addYears(int years){
        Calendar cal = Calendar.getInstance();
        return TimeUtil.addYears(cal.getTime(),years);
    }
    public static String addYears(Date d,int years){
        return TimeUtil.format(DateUtils.addDays(d,years),SOURCE_1);
    }

    /**
     * 获得当前是星期几的数字
     *  WEEK_ZH_MAP.put("1", "星期日");
     WEEK_ZH_MAP.put("2", "星期一");
     WEEK_ZH_MAP.put("3", "星期二");
     WEEK_ZH_MAP.put("4", "星期三");
     WEEK_ZH_MAP.put("5", "星期四");
     WEEK_ZH_MAP.put("6", "星期五");
     WEEK_ZH_MAP.put("7", "星期六");
     * @return 表示星期的数字
     */
    public static int getWeek(){
        Calendar cal = Calendar.getInstance(); // 创建一个日历对象。
        cal.setTime(new Date());
        return cal.get(Calendar.DAY_OF_WEEK);
    }

}
