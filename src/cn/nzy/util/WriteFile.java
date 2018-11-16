package cn.nzy.util;

import java.io.*;
import java.util.*;

/**
 * Created by nizy on 2018/7/10.
 */
public class WriteFile {
    private final static List<String> logList = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println(logList.size());
        readLogs("/Users/nizhiyong/work/helianlogs/maclogs.txt");
        System.out.println(logList.size());
        File files = new File("/Users/nizhiyong/work/encodemac");
        int count = 0;
        WriteFile test = new WriteFile();
        for (File file : files.listFiles()) {
            if (file.getName().contains(".txt")) {
                System.out.println(file.getName());
                (new HandleThread("thread" + (count++), logList,file, "/Users/nizhiyong/work/maclogs")).start();
            }
        }
    }

    public static void writerLogs() {
        String inFileName = "/Users/nizhiyong/work/helianlogs/AllLogs";
        String outFileName = "/Users/nizhiyong/work/helianlogs/maclogs.txt";
        List<File> fileList = new ArrayList<File>();
        File inFile = new File(inFileName);
        File outFile = new File(outFileName);
        BufferedReader br = null;
        BufferedWriter bw = null;
        int count = 0;
        for (File file : inFile.listFiles()) {
            fileList.add(file);
        }
        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        try {
            if (!outFile.exists()) {
                outFile.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(outFile));
            for (File file : fileList) {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                String line = "";
                while ((line = br.readLine()) != null) {
                    if (line != "") {
                        bw.write(line);
                        bw.newLine();
                        count++;
                    }
                }
                br.close();
            }
            bw.close();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readLogs(String filename) {
        File outFile = new File(filename);
        BufferedReader br = null;
        try {
            String line = "";
            br = new BufferedReader(new InputStreamReader(new FileInputStream(outFile)));
            while ((line = br.readLine()) != null) {
                logList.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
