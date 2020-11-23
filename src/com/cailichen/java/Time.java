package com.cailichen.java;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author cailichen
 * @create 2020-11-19-22:36
 */
public class Time {
    public static void main(String[] args) {
        //获取系统当前日期与时间
        LocalDateTime now = LocalDateTime.now();
        //获取系统当前日期
        LocalDate nowDate = LocalDate.now();
        //获取系统当前时间
        LocalTime nowTime = LocalTime.now();

        //自定义一个日期时间2020年12月12日13时59分59秒
        LocalDateTime any = LocalDateTime.of(2020,12,12,13,59,59);
        //获取某个日期时间的年份
        int y = any.getYear();

        //对指定日期进行运算操作
        LocalDate newDate = nowDate.plusDays(2);//加两天
        LocalDate newDate2 = nowDate.plus(1, ChronoUnit.WEEKS);
        //加一周，ChronoUnit为标准的日期枚举类

        //将系统当前日期时间(now)与自定义时间(any)进行比较,any是否比now早，早为true
        boolean isBefore = any.isBefore(now);
        //计算系统当前日期时间与自定义时间的时间差，晚为1，早为-1，不早不晚为0
        int t = any.compareTo(now);

        //设置时区，并获取该时区的时间（以上海为例）
        ZoneId shanghaiZongId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime shanghaiZonedDateTime = ZonedDateTime.now(shanghaiZongId);
        ZonedDateTime shanghaiZonedDateTime2 = now.atZone(shanghaiZongId);

        ///日期格式的转换
        //定义一个格式为BASIC_ISO_DATE的，内容为2018年12月12日的时间，并将其格式转换成ISO_DATE
        LocalDate date = LocalDate.parse("20181212", DateTimeFormatter.BASIC_ISO_DATE);
        String dateText = date.format(DateTimeFormatter.ISO_DATE);
        //将当前日期时间改为“年-月-日 时：分：秒”的格式（24小时制）
        String nowText = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        //将当前日期时间改为“年-月-日 时：分：秒”的格式（12小时制）
        String nowText2 = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));

        ///计算该程序编译的时间差
        //获取当前时间（精确到纳秒级）
        Instant nowMS = Instant.now();


        /**计算刚开始编译的系统时间(now)与现在编译的系统时间(nowMS)的时间差
         * long used = ChronoUnit.MILLIS.between(now,Instant.now());
         *
         * Exception in thread "main" java.time.DateTimeException: Unable to obtain LocalDateTime from TemporalAccessor: 2020-11-19T15:49:20.363Z of type java.time.Instant
         * 	at java.time.LocalDateTime.from(LocalDateTime.java:461)
         * 	at java.time.LocalDateTime.until(LocalDateTime.java:1683)
         * 	at java.time.temporal.ChronoUnit.between(ChronoUnit.java:272)
         * 	at com.cailichen.java.Time.main(Time.java:53)
         * Caused by: java.time.DateTimeException: Unable to obtain LocalDate from TemporalAccessor: 2020-11-19T15:49:20.363Z of type java.time.Instant
         * 	at java.time.LocalDate.from(LocalDate.java:368)
         * 	at java.time.LocalDateTime.from(LocalDateTime.java:456)
         * 	... 3 more
         * Disconnected from the target VM, address: '127.0.0.1:3577', transport: 'socket'
         */

        ///计算两个日期时间的间隔
        //计算间隔的天数
        long day = any.until(now,ChronoUnit.DAYS);
        //计算当前系统日期与2020年12月1号相差的日期
        Period p = Period.between(nowDate,LocalDate.of(2020,12,1));
        LocalDate newDate3 = nowDate.plus(p);
        //计算统当前日期时间(now)与自定义时间(any)间隔的秒数
        Duration s = Duration.between(any,now);
        //将秒数差转换成时间差
        long m = s.toMinutes();
    }
}
