package com.yazuo.kbpos.campaign.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author caiMian
 * @create on 2018-08-21 13:15.
 */

public class CalendarHolidayUtil {

    /**
     * 农历的年份
     */
    private int year;
    private int month;
    private int day;
    /**
     * 农历的月份
     */
    private String lunarMonth;
    /**
     * 闰的是哪个月
     */
    public int leapMonth = 0;

    final static int CONSTANT_1 = 0x8000;
    final static int CONSTANT_2 = 0x8;
    final static int CONSTANT_3 = 0x10000;
    final static int CONSTANT_4 = 1900;
    final static int CONSTANT_5 = 30;
    final static int CONSTANT_6 = 10;
    final static int CONSTANT_1000 = 10000;
    final  String CONSTANT_7 = "母亲节5月";
    final  String CONSTANT_8 = "父亲节6月";
    final  String CONSTANT_9 = "感恩节11月";
    final  String CONSTANT_10 = "一" ;
    final  String CONSTANT_11 = "初一" ;
    final int MONTH_5 = 5;
    final int MONTH_6 = 6;
    final int MONTH_11 = 11;
    final int MONTH_13 = 13;

    final static String []CHINESCNUMBER = { "一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二" };
    static SimpleDateFormat chineseDateFormat = new SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA);
    final static long[] LUNARINFO = new long[] {
            0x04bd8, 0x04ae0, 0x0a570, 0x054d5, 0x0d260, 0x0d950, 0x16554, 0x056a0, 0x09ad0,
            0x055d2, 0x04ae0, 0x0a5b6, 0x0a4d0, 0x0d250, 0x1d255, 0x0b540, 0x0d6a0, 0x0ada2,
            0x095b0, 0x14977, 0x04970, 0x0a4b0, 0x0b4b5, 0x06a50, 0x06d40, 0x1ab54, 0x02b60,
            0x09570, 0x052f2, 0x04970, 0x06566, 0x0d4a0, 0x0ea50, 0x06e95, 0x05ad0, 0x02b60,
            0x186e3, 0x092e0, 0x1c8d7, 0x0c950, 0x0d4a0, 0x1d8a6, 0x0b550, 0x056a0, 0x1a5b4,
            0x025d0, 0x092d0, 0x0d2b2, 0x0a950, 0x0b557, 0x06ca0, 0x0b550, 0x15355, 0x04da0,
            0x0a5d0, 0x14573, 0x052d0, 0x0a9a8, 0x0e950, 0x06aa0, 0x0aea6, 0x0ab50, 0x04b60,
            0x0aae4, 0x0a570, 0x05260, 0x0f263, 0x0d950, 0x05b57, 0x056a0, 0x096d0, 0x04dd5,
            0x04ad0, 0x0a4d0, 0x0d4d4, 0x0d250, 0x0d558, 0x0b540, 0x0b5a0, 0x195a6, 0x095b0,
            0x049b0, 0x0a974, 0x0a4b0, 0x0b27a, 0x06a50, 0x06d40, 0x0af46, 0x0ab60, 0x09570,
            0x04af5, 0x04970, 0x064b0, 0x074a3, 0x0ea50, 0x06b58, 0x055c0, 0x0ab60, 0x096d5,
            0x092e0, 0x0c960, 0x0d954, 0x0d4a0, 0x0da50, 0x07552, 0x056a0, 0x0abb7, 0x025d0,
            0x092d0, 0x0cab5, 0x0a950, 0x0b4a0, 0x0baa4, 0x0ad50, 0x055d9, 0x04ba0, 0x0a5b0,
            0x15176, 0x052b0, 0x0a930, 0x07954, 0x06aa0, 0x0ad50, 0x05b52, 0x04b60, 0x0a6e6,
            0x0a4e0, 0x0d260, 0x0ea65, 0x0d530, 0x05aa0, 0x076a3, 0x096d0, 0x04bd7, 0x04ad0,
            0x0a4d0, 0x1d0b6, 0x0d250, 0x0d520, 0x0dd45, 0x0b5a0, 0x056d0, 0x055b2, 0x049b0,
            0x0a577, 0x0a4b0, 0x0aa50, 0x1b255, 0x06d20, 0x0ada0 };

    /**
     * 农历部分假日
     */
    final static String[] LUNAR_HOLIDAY = new String[] { "0101 春节", "0115 元宵节", "0220 清明节", "0505 端午节", "0707 七夕节", "0815 中秋节", "0909 重阳节", "1208 腊八节", "1223 小年" };

    /**
     * 公历部分节假日
     */
    final static String[] SOLAR_HOLIDAY  = new String[] {
            "0101 元旦", "0214 情人节", "0308 三八妇女节", "0312 植树节", "0314 白色情人节", "0315 消费者权益日", "0401 愚人", "0501 劳动节",
            "0504 青年节", "0601 儿童节", "0910 教师节", "1001 国庆节", "1101 万圣节", "1111 光棍节", "1225 圣诞节" };



    /**
     * 根据输入是时间段查出所有节日
     * @param beginTime yyyyMMdd
     * @param ednTime yyyyMMdd
     * @throws ParseException
     */
    public void getAllHoliday(String beginTime,String ednTime) throws ParseException {
        Calendar c = Calendar.getInstance();

        DateFormat dateFormat1 = new SimpleDateFormat("yyyyMMdd");

        //开始时间必须小于结束时间
        Date beginDate = dateFormat1.parse(beginTime);
        Date endDate = dateFormat1.parse(ednTime);
        Date date = beginDate;
        Map<String,Integer> map = new HashMap<>(3);
        while (date.compareTo(endDate)<=0) {
            // 获取年月日
            c.setTime(date);
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH)+1;
            int day = c.get(Calendar.DATE);
            // 计算特殊的节日。一年计算一次
            if(map.get(year + CONSTANT_7)==null) {
                map = this.getWeekendInMonth(year);
            }
            List list =this.getLunarDate(year,month,day,map);
            if(list!=null&&list.size()>0) {
                System.out.println("阳历日期" + dateFormat1.format(date) + "这天的节日" + list);
            }
            c.setTime(date);
            // 日期加1天
            c.add(Calendar.DATE, 1);
            date = c.getTime();

        }
    }

    /**
     * 特殊处理三种节日
     * 母亲节（每年5月的第二个星期天）
     * 父亲节（每年6月第三个星期天）
     * 感恩节（每年11月第四个星期四）
     * @return
     */
    public  Map<String,Integer> getWeekendInMonth(int year) {
        Map<String,Integer> map = new HashMap<>(3);
        Calendar calendar = Calendar.getInstance();
        // 不设置的话默认为当年
        calendar.set(Calendar.YEAR, year);
        for(int month = 1;month<=Calendar.UNDECIMBER;month++) {
            // 设置月份
            calendar.set(Calendar.MONTH, month - 1);
            // 设置为当月第一天
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            // 当月最大天数
            int daySize = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            int j = 1;
            int k =1;
            int m=1;
            for (int i = 0; i < daySize; i++) {
                int week = calendar.get(Calendar.DAY_OF_WEEK);
                if(month==5) {
                    // 1代表周日，7代表周六 判断这是一个星期的第几天从而判断是否是周末
                    if (week == Calendar.SUNDAY) {
                        if (j == 2) {
                            map.put(year + CONSTANT_7, calendar.get(Calendar.DAY_OF_MONTH));
                        }
                        j++;
                    }
                }
                if(month==6) {
                    // 1代表周日
                    if (week == Calendar.SUNDAY) {
                        if (k == 3) {
                            map.put(year + CONSTANT_8, calendar.get(Calendar.DAY_OF_MONTH));
                        }
                        k++;
                    }
                }
                if(month==11) {
                    // 5代表周四
                    if (week == Calendar.THURSDAY) {
                        if (m == 4) {
                            map.put(year + CONSTANT_9, calendar.get(Calendar.DAY_OF_MONTH));
                        }
                        m++;
                    }
                }
                //在第一天的基础上加1
                calendar.add(Calendar.DATE, 1);
            }

        }
        return map;
    }

    /**
     * 传回农历 y年的总天数
     * @param y
     * @return
     */
    final private static int yearDays(int y) {
        int i, sum = 348;
        for (i = CONSTANT_1; i > CONSTANT_2; i >>= 1) {
            if ((LUNARINFO[y - 1900] & i) != 0) {
                sum += 1;
            }
        }
        return (sum + leapDays(y));
    }

    /**
     * 传回农历 y年闰月的天数
     * @param y
     * @return
     */
    final private static int leapDays(int y) {
        if (leapMonth(y) != 0) {
            if ((LUNARINFO[y - CONSTANT_4] & CONSTANT_3) != 0){
                return 30;}
            else{
                return 29;}
        } else{
            return 0;}
    }

    /**
     * 传回农历 y年闰哪个月 1-12 , 没闰传回 0
     * @param y
     * @return
     */
    final private static int leapMonth(int y) {
        int result = (int) (LUNARINFO[y - 1900] & 0xf);
        return result;
    }

    /**
     * 传回农历 y年m月的总天数
     * @param y
     * @param m
     * @return
     */
    final private static int monthDays(int y, int m) {
        if ((LUNARINFO[y - CONSTANT_4] & (CONSTANT_3 >> m)) == 0){
            return 29;}
        else{
            return 30;}
    }


    public static String getChinaDayString(int day) {
        String []chineseTen = { "初", "十", "廿", "卅" };
        int n = day % 10 == 0 ? 9 : day % 10 - 1;
        if (day > CONSTANT_5){
            return "";}
        if (day == CONSTANT_6){
            return "初十";}
        else{
            return chineseTen[day / 10] + CHINESCNUMBER[n];}
    }

    /**
     * 传出y年m月d日对应的农历. yearCyl3:农历年与1864的相差数 ? monCyl4:从1900年1月31日以来,闰月数
     * dayCyl5:与1900年1月31日相差的天数,再加40 ?
     * @return
     */
    public List<String> getLunarDate(int year_log, int month_log, int day_log,Map<String,Integer> map) {
        // @SuppressWarnings("unused")
        int yearCyl, monCyl, dayCyl;
        // int leapMonth = 0;
        List<String> list = new ArrayList<>();
        if(month_log==MONTH_5&& day_log==map.get(year + CONSTANT_7)) {
            list.add("母亲节");
        }
        if(month_log==MONTH_6&& day_log==map.get(year + CONSTANT_8)) {
            list.add("父亲节");
        }
        if(month_log==MONTH_11&& day_log==map.get(year + CONSTANT_9)) {
            list.add("感恩节");
        }

        String nowadays;
        Date baseDate = null;
        Date nowaday = null;
        try {
            baseDate = chineseDateFormat.parse("1900年1月31日");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        nowadays = year_log + "年" + month_log + "月" + day_log + "日";
        try {
            nowaday = chineseDateFormat.parse(nowadays);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 求出和1900年1月31日相差的天数
        int offset = (int) ((nowaday.getTime() - baseDate.getTime()) / 86400000L);
        dayCyl = offset + 40;
        monCyl = 14;

        // 用offset减去每农历年的天数
        // 计算当天是农历第几天
        // i最终结果是农历的年份
        // offset是当年的第几天
        int iYear, daysOfYear = 0;
        for (iYear = CONSTANT_4; iYear < CONSTANT_1000 && offset > 0; iYear++) {
            daysOfYear = yearDays(iYear);
            offset -= daysOfYear;
            monCyl += 12;
        }
        if (offset < 0) {
            offset += daysOfYear;
            iYear--;
            monCyl -= 12;
        }
        // 农历年份
        year = iYear;
        // 设置公历对应的农历年份
        setYear(year);

        yearCyl = iYear - 1864;
        // 闰哪个月,1-12
        leapMonth = leapMonth(iYear);
        boolean leap = false;

        // 用当年的天数offset,逐个减去每月（农历）的天数，求出当天是本月的第几天
        int iMonth, daysOfMonth = 0;
        for (iMonth = 1; iMonth < MONTH_13 && offset > 0; iMonth++) {
            // 闰月
            if (leapMonth > 0 && iMonth == (leapMonth + 1) && !leap) {
                --iMonth;
                leap = true;
                daysOfMonth = leapDays(year);
            } else{
                daysOfMonth = monthDays(year, iMonth);}

            offset -= daysOfMonth;
            // 解除闰月
            if (leap && iMonth == (leapMonth + 1)){
                leap = false;}
            if (!leap){
                monCyl++;}
        }
        // offset为0时，并且刚才计算的月份是闰月，要校正
        if (offset == 0 && leapMonth > 0 && iMonth == leapMonth + 1) {
            if (leap) {
                leap = false;
            } else {
                leap = true;
                --iMonth;
                --monCyl;
            }
        }
        // offset小于0时，也要校正
        if (offset < 0) {
            offset += daysOfMonth;
            --iMonth;
            --monCyl;
        }
        month = iMonth;
        // 设置对应的阴历月份
        setLunarMonth(CHINESCNUMBER[month - 1] + "月");
        day = offset + 1;

        // 如果日期为节假日则阴历日期则返回节假日
        // setLeapMonth(leapMonth);
        for (int i = 0; i < SOLAR_HOLIDAY.length; i++) {
            // 返回公历节假日名称
            // 节假日的日期
            String sd = SOLAR_HOLIDAY[i].split(" ")[0];
            // 节假日的名称
            String sdv = SOLAR_HOLIDAY[i].split(" ")[1];
            String smonth_v = month_log + "";
            String sday_v = day_log + "";
            String smd = "";
            if (month_log < 10) {
                smonth_v = "0" + month_log;
            }
            if (day_log < 10) {
                sday_v = "0" + day_log;
            }
            smd = smonth_v + sday_v;

            if (sd.trim().equals(smd.trim())) {
                list.add(sdv);
                break;
            }

        }

        for (int i = 0; i < LUNAR_HOLIDAY.length; i++) {
            // 返回农历节假日名称
            // 节假日的日期
            String ld = LUNAR_HOLIDAY[i].split(" ")[0];
            // 节假日的名称
            String ldv = LUNAR_HOLIDAY[i].split(" ")[1];
            String lmonth_v = month + "";
            String lday_v = day + "";
            String lmd = "";
            if (month < 10) {
                lmonth_v = "0" + month;
            }
            if (day < 10) {
                lday_v = "0" + day;
            }
            lmd = lmonth_v + lday_v;
            lmd = lmonth_v + lday_v;
            // 除夕夜需要特殊处理
            if ("12".equals(lmonth_v)) {
                boolean flag = (daysOfMonth == 29 && day == 29) || (daysOfMonth == 30 && day == 30);
                if (flag) {
                    list.add("除夕");
                    break;
                }
            }
            if (ld.trim().equals(lmd.trim())) {
                list.add(ldv);
                break;
            }
        }


        return list;
    }


    @Override
    public String toString() {
        if (CHINESCNUMBER[month - 1] == CONSTANT_10 && getChinaDayString(day) == CONSTANT_11){
            return "农历" + year + "年";}
        else if (getChinaDayString(day) == CONSTANT_11){
            return CHINESCNUMBER[month - 1] + "月";}
        else{
            return getChinaDayString(day);}
    }

	/*
	 * public static void main(String[] args) { System.out.println(new
	 * LunarCalendar().getLunarDate(2012, 1, 23)); }
	 */

    public int getLeapMonth() {
        return leapMonth;
    }

    public void setLeapMonth(int leapMonth) {
        this.leapMonth = leapMonth;
    }

    /**
     * 得到当前日期对应的阴历月份
     *
     * @return
     */
    public String getLunarMonth() {
        return lunarMonth;
    }

    public void setLunarMonth(String lunarMonth) {
        this.lunarMonth = lunarMonth;
    }

    /**
     * 得到当前年对应的农历年份
     *
     * @return
     */
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}