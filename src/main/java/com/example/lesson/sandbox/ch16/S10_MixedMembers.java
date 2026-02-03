package com.example.lesson.sandbox.ch16;

public class S10_MixedMembers {
    /**
     * 1. 教學目標
     * 證明抽象類別中可以包含已經寫好的方法 (Concrete Methods)，讓子類別繼承共用邏輯。
     *
     * 3. 講師備課指引
     * - 設計哲學 : 解釋為什麼 refuel 不用 abstract? 因為所有車加油動作大同小異，沒必要強迫每台車重寫一次，這就是「繼承的好處」。
     */
    public static void main(String[] args) {
        Bmw bmw = new Bmw();
        // 呼叫繼承來的普通方法
        bmw.refuel();
        // 呼叫自己實作的抽象方法
        bmw.run();
    }

    abstract static class Car {
        // 抽象方法: 每種車跑起來不一樣，給子類別自己寫
        abstract void run();

        // 一般方法: 加油動作都一樣，父類別統一寫好 (Code Reuse)
        void refuel() {
            System.out.println("汽車加油");
        }
    }

    static class Bmw extends Car {
        // 只需要實作 run()
        public void run() {
            System.out.println("安全駕駛中...");
        }
    }
}
