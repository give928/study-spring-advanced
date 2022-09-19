package com.give928.spring.advanced.util;

public class ThreadUtil {
    private ThreadUtil() {
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
