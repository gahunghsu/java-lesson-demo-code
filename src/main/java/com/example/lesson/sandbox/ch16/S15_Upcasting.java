package com.example.lesson.sandbox.ch16;

public class S15_Upcasting {
    /**
     * 1. 教學目標
     * 展示如何使用抽象父類別作為變數型態，來操作子類別物件，達成多形應用。
     *
     * 3. 講師備課指引
     * - 重要觀念 : 強調 Line 16 的寫法 Car bmw = new Bmw();。這在未來更換子類別 (例如換成 new Benz()) 時，後面的程式碼幾乎不用改，增加了程式的靈活度。
     */
    public static void main(String[] args) {
        // 關鍵語法: Upcasting (父類別參考 指向 子類別物件)
        // Car 是抽象的，不能 new Car()，但可以當變數型態
        Car bmw = new Bmw();

        bmw.refuel();
        bmw.run(); // 實際執行的是 Bmw 的 run
    }

    abstract static class Car {
        abstract void run();
        void refuel() {
            System.out.println("汽車加油");
        }
    }

    static class Bmw extends Car {
        public void run() {
            System.out.println("Bmw 安全駕駛中...");
        }
    }
}
