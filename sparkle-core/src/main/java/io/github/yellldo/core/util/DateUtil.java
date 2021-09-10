package io.github.yellldo.core.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * ClassName : DateUtil<br>
 * Description : 时间工具类<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/22
 */
public class DateUtil {

    public static final String FULL_DATE_PATTERN = "yyyyMMdd";

    public static final String FULL_DATE_SPLIT_PATTERN = "yyyy-MM-dd";

    public static final String FULL_TIME_PATTERN = "yyyyMMddHHmmss";

    public static final String FULL_TIME_SPLIT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String CST_TIME_PATTERN = "EEE MMM dd HH:mm:ss zzz yyyy";

    public static String formatFullTime(LocalDateTime localDateTime) {
        return formatFullTime(localDateTime, FULL_TIME_PATTERN);
    }

    public static String formatFullTime(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(dateTimeFormatter);
    }

    public static String getDateFormat(Date date, String dateFormatType) {
        if(ObjectUtil.isNull(date)){
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatType, Locale.CHINA);
        return simpleDateFormat.format(date);
    }

    public static String formatCSTTime(String date, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CST_TIME_PATTERN, Locale.US);
        Date usDate = simpleDateFormat.parse(date);
        return DateUtil.getDateFormat(usDate, format);
    }

    public static String formatInstant(Instant instant, String format) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(format));
    }

    public static long dateToSecond(String dateStr) {
        if (StrUtil.isEmpty(dateStr)) {
            return 0L;
        }
        return cn.hutool.core.date.DateUtil.parse(dateStr, DateUtil.FULL_TIME_PATTERN).getTime() / 1000L;
    }

    /**
     *  时间秒数转时间字符串
     * @param time
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String secondToDateTimeString(long time) {
        if (Long.compare(time, 0L) <= 0) {
            return "";
        }
        Date newDate = new Date();
        newDate.setTime(time * 1000L);
        return DateUtil.getDateFormat(newDate, DateUtil.FULL_TIME_SPLIT_PATTERN);
    }
    /**
     *  时间秒数转时间字符串
     * @param time
     * @return yyyy-MM-dd
     */
    public static String secondToDateString(long time) {
//        if (Long.compare(time, 0L) <= 0) {
//            return "";
//        }

        Date newDate = new Date();
        newDate.setTime(time * 1000L);
        return DateUtil.getDateFormat(newDate, DateUtil.FULL_DATE_SPLIT_PATTERN);
    }

    public static java.util.Date getString2Date(String sDate) {
        SimpleDateFormat sdf = new SimpleDateFormat(FULL_TIME_SPLIT_PATTERN);
        java.util.Date obj = null;

        try {
            obj = sdf.parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
            System.err.println("change date type error");
        }

        return obj;
    }

    public static String dateToStr(Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

}
