package com.dave.java8;

/**
 * Created by David on 28/03/2017.
 */
public class RunnnableTest {


    public static void main(String[] args) {
        runAsThread(() -> {
            for(int i=0;i<10;i++) {
                System.out.println(i);
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        runAsThread(() -> {
            for(int i=0;i<10;i++) {
                System.out.println((char)(i+80));
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    private static void runAsThread(Runnable runnable) {
        new Thread(runnable).start();

    }
}
