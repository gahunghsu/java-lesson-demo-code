package com.example.lesson.sandbox.ch21;

public class S04_ExtendsThread {
    /**
     * 1. 教學目標
     * 展示如何繼承 Thread 類別，並覆寫 run() 方法來定義執行緒要執行的任務。
     *
     * 3. 講師備課指引
     * - 關鍵區分 :
     *   o 實驗 1: 直接呼叫 run() -> 這是普通物件方法呼叫 (單執行緒)。
     *   o 實驗 2: 呼叫 start() -> 這才會通知 JVM 啟動新的執行緒 (多執行緒)。
     */
    public static void main(String[] args) {
        MultiThread t = new MultiThread();

        System.out.println("=== 實驗 1: 直接呼叫 run() ===");
        t.run(); //這只是普通物件方法呼叫

        System.out.println("\n=== 實驗 2: 呼叫 start() ===");
        t.start(); // 這才會通知 JVM 啟動新的執行緒

        System.out.println("Main 方法結束 (由 " + Thread.currentThread().getName() + " 印出)");
    }

    static class MultiThread extends Thread {
        // 重新定義 run 方法，這是執行緒要執行的任務
        public void run() {
            // 印出當前執行緒的名稱，以證明是誰在執行
            System.out.println("run() 方法正在運行，執行者: " + Thread.currentThread().getName());
        }
    }
}
