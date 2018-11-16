package cn.nzy.util;

import java.util.Calendar;

/**
 * Created by nizy on 2018/7/16.
 */
public class CalendarUtil {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 2);
        System.out.println(cal.getTime());
    }
}
