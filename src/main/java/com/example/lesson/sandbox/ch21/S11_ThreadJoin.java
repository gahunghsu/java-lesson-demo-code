package com.example.lesson.sandbox.ch21;

public class S11_ThreadJoin {
    /**
     * 1. 教學目標
     * 展示 join() 如何讓執行緒之間產生「順序依賴性」。
     *
     * 3. 講師備課指引
     * - 執行順序 : Job1 一定會從 1 跑到 5 結束後，Job2 和 Job3 才會開始跑 (且 Job2 與 3 會交錯)。
     * - 應用場景 : 檔案下載完成 (join) -> 才能開始解壓縮。
     */
    public static void main(String[] args) {
        Xjoin job1 = new Xjoin("Job1");
        Xjoin job2 = new Xjoin("Job2");
        Xjoin job3 = new Xjoin("Job3");

        job1.start();
        try {
            // 講師強調: Main 執行緒執行到這行會卡住 (Blocked)
            // 直到 job1 跑完 (Terminated)，Main 才會繼續往下走
            job1.join();
            System.out.println("--- Job1 結束，換其他人 ---");
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        job2.start();
        job3.start();
    }

    static class Xjoin extends Thread {
        Xjoin(String name) {
            super(name);
        }

        public void run() {
            for (int i = 1; i <= 5; i++) {
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                System.out.println(getName() + " is running : " + i);
            }
        }
    }
}
