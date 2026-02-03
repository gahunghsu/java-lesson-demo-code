package com.example.lesson.sandbox.ch16;

public class S11_ConstructorChain {
    /**
     * 1. 教學目標
     * 證明抽象類別雖然不能 new，但依然有建構子，且在子類別實體化時會被優先執行 (Constructor Chaining)。
     *
     * 3. 講師備課指引
     * - 輸出順序 : 執行程式，請學生確認是先印出「有車子了」。
     * - 邏輯解析 : 因為要先有「車」的概念與初始化，才能產生具體的「BMW」。
     */
    public static void main(String[] args) {
        System.out.println("--- 開始建立物件 ---");
        Bmw bmw = new Bmw(); // 觀察這裡的輸出順序
        System.out.println("--- 物件建立完成 ---");

        bmw.refuel();
        bmw.run();
    }

    abstract static class Car {
        abstract void run();

        // 講師強調: 抽象類別的建構子
        Car() {
            System.out.println("有車子了 (執行父類別建構子)");
        }

        void refuel() {
            System.out.println("汽車加油");
        }
    }

    static class Bmw extends Car {
        // Bmw 建構子隱藏了 super() 呼叫
        public void run() {
            System.out.println("安全駕駛中...");
        }
    }
}
