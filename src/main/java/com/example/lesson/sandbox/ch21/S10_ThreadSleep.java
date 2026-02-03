package com.example.lesson.sandbox.ch21;

public class S10_ThreadSleep {
    /**
     * 1. 教學目標
     * 展示 Thread.sleep() 的用法，並說明必須處理 InterruptedException。
     *
     * 3. 講師備課指引
     * - 視覺效果 : Console 會每隔半秒跳出訊息，這就是最簡單的動畫或倒數計時原理。
     * - 異常處理 : 強調 try-catch 是必須的，因為執行緒在睡眠時可能被 interrupt() 叫醒 (雖然此範例沒演示中斷)。
     */
    public static void main(String[] args) {
        HorseRacing t1 = new HorseRacing("Horse1");
        HorseRacing t2 = new HorseRacing("Horse2");
        // 兩匹馬會交替輸出，因為大家都 sleep 禮讓 CPU
        t1.start();
        t2.start();
    }

    static class HorseRacing extends Thread {
        HorseRacing(String name) {
            super(name);
        }

        public void run() {
            for (int i = 1; i <= 5; i++) {
                try {
                    // 暫停 500 毫秒 (0.5 秒)
                    // 講師強調: sleep 會讓出 CPU，但不會釋放鎖 (Lock)
                    sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                System.out.println(getName() + " 正在跑第 " + i + " 圈...");
            }
        }
    }
}
