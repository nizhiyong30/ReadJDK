package cn.nzy.util;

import java.util.regex.Pattern;

/**
 * Created by nizy on 2018/7/10.
 */
public class RegexUtil {
    public static void main(String[] args) {
        String content = "2018-06-20 00:00:59.396|helian||d74efa375ffadad2a107d3b8d45cba4b||||{\"timestamp\":1529424059392,\"lon\":\"108.3207\",\"department\":\"105,112\",\"lat\":\"22.827618\"}";
        String pattern = ".*d74efa375ffadad2a107d3b8d45cba4b.*";
        String pattern1 = "d74efa375ffadad2a107d3b8d45cba4b";
        long startTime = System.currentTimeMillis();
        boolean flag = Pattern.matches(pattern,content);
        long endTime1 = System.currentTimeMillis();
        boolean flag1 = content.contains(pattern);
        long endTime2 = System.currentTimeMillis();
        System.out.println(endTime1-startTime);
        System.out.println(endTime2-startTime);

    }
}
