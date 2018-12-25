package AOPdemo;

import java.util.Date;

/**
 * 日志类
 */
public class Logger {
    public static void start() {
        System.out.println(new Date() + " hello start...");
    }

    public static void end() {
        System.out.println(new Date() + " hello end.");
    }
}
