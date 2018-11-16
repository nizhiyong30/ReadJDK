package cn.nzy.util;

import java.io.*;
import java.util.List;

/**
 * Created by nizy on 2018/7/10.
 */
public class HandleThread extends Thread {
    private String threadName;
    private List<String> data;
    private File macFile;
    private String outPath;
    private long startTime;
    private long endTime;

    public HandleThread(String threadName, List<String> data, File macFile, String outPath) {
        this.threadName = threadName;
        this.data = data;
        this.macFile = macFile;
        this.outPath = outPath;
        startTime = System.currentTimeMillis();
    }

    public void loadLogs2Shop(File macFile, String outPath, List<String> data) {
        File outFile = new File((outPath + "/" + macFile.getName()));
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            if (!outFile.exists()) {
                System.out.println("not exists!");
                outFile.createNewFile();
            }
            String macLine = "";
            br = new BufferedReader(new InputStreamReader(new FileInputStream(macFile)));
            bw = new BufferedWriter(new FileWriter(outFile));
            while ((macLine = br.readLine()) != null) {
                for (String logLine : data) {
                    if (logLine.contains(macLine)) {
                        bw.write(logLine);
                        bw.newLine();
                    }
                }

            }
            br.close();
            bw.close();

        } catch (Exception e) {

        }
    }

    @Override
    public void run() {
        loadLogs2Shop(macFile, outPath, data);
        endTime = System.currentTimeMillis();
        System.out.println(threadName + "已经完成。运行时间为:"+(startTime-endTime));
    }
}
