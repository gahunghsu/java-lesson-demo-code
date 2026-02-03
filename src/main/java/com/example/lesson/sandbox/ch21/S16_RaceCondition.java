package com.example.lesson.sandbox.ch21;

public class S16_RaceCondition {
    /**
     * 1. 教學目標
     * 比較「無同步」與「有同步」的差異。為了符合簡報「賣票/庫存」的情境，雖然原檔 ch21_13 使用 printDemo，但邏輯完全通用 (多個執行緒搶奪同一資源)。
     *
     * 3. 講師備課指引
     * - 關鍵修改 : 加上 synchronized 關鍵字。
     * - 若無 synchronized (如 ch21_13.java): 兩個執行緒的輸出會亂序穿插。
     * - 有 synchronized: 執行緒會乖乖排隊，Job1 印完才換 Job2。
     */
    public static void main(String[] args) {
        // 重點: 兩個執行緒共用「同一個」 Demo 物件 (資源)
        Demo obj = new Demo();

        JobThread1 t1 = new JobThread1(obj);
        JobThread2 t2 = new JobThread2(obj);

        t1.start();
        t2.start();
    }

    static class Demo {
        // 關鍵修改: 加上 synchronized 關鍵字
        // 若無 synchronized (如 ch21_13.java)，兩個執行緒的輸出會亂序穿插
        public synchronized void printDemo(int n) {
            for (int i = 1; i <= 5; i++) {
                System.out.println("輸出: " + (i * n));
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    static class JobThread1 extends Thread {
        Demo pd;
        JobThread1(Demo pd) { this.pd = pd; }
        public void run() { pd.printDemo(10); }
    }

    static class JobThread2 extends Thread {
        Demo pd;
        JobThread2(Demo pd) { this.pd = pd; }
        public void run() { pd.printDemo(100); }
    }
}
