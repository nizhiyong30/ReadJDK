package cn.nzy.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by nizy on 2019/3/8.
 */

public class JDK8DateUtil {
    public static void main(String[] args) {
        LocalDate localDate1 = LocalDate.parse("20150228", DateTimeFormatter.BASIC_ISO_DATE);
        localDate1 = localDate1.plusDays(0);
        System.out.println(localDate1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMMdd");
        System.out.println(formatter.format(localDate1));
//        LocalDate localDate2 = LocalDate.parse("20180225", DateTimeFormatter.ofPattern("YYYYMMDD"));
//        System.out.println(LocalDate.now().isBefore(LocalDate.now()));
    }
}
