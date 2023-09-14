package live.cloverescape.annotationd;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author seven
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.of(LocalDate.parse("2022-01-01").minus(1, ChronoUnit.DAYS), LocalTime.MIN));
        System.out.println(LocalDateTime.of(LocalDate.parse("2022-12-31").plus(1, ChronoUnit.DAYS), LocalTime.MIN));
        System.out.println(getMonthFirstAndLastDay());
        System.out.println(getWeekDate());
    }


    public static Map<String, String> getMonthFirstAndLastDay() {

        Map<String, String> firAndlasDay = new HashMap<>();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        firAndlasDay.put("firstDay", format.format(cale.getTime()));

        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        firAndlasDay.put("lastDay", format.format(cale.getTime()));

        return firAndlasDay;
    }

    public static Map<String, String> getWeekDate() {
        Map<String, String> map = new HashMap();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (dayWeek == 1) {
            dayWeek = 8;
        }

        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayWeek);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        Date mondayDate = cal.getTime();
        String weekBegin = sdf.format(mondayDate);


        cal.add(Calendar.DATE, 4 + cal.getFirstDayOfWeek());
        Date sundayDate = cal.getTime();
        String weekEnd = sdf.format(sundayDate);

        map.put("mondayDate", weekBegin);
        map.put("sundayDate", weekEnd);
        return map;
    }

}