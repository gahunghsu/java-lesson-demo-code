package com.example.lesson.sandbox.ch14;

public class S17_Polymorphism {
    /**
     * 1. 教學目標
     * 展示多形的終極應用：使用父類別陣列統一管理不同子類別物件，並透過迴圈呼叫同一方法，卻產生不同行為。
     *
     * 3. 講師備課指引
     * - 神奇之處 : 請學生盯著 a.move() 這行。明明程式碼都一樣，為什麼輸出會變成「狗在跑」、「鳥在飛」？這就是動態綁定 (Dynamic Binding)。
     */
    public static void main(String[] args) {
        // 1. 向上轉型 (Upcasting): 陣列宣告為 Animal 類型
        Animal[] zoo = new Animal[3];
        zoo[0] = new Dog();
        zoo[1] = new Bird();
        zoo[2] = new Dog();

        // 2. 多形呼叫: 同一行程式碼，執行當下依據物件本體決定行為
        System.out.println("=== 動物園開門 ===");
        for (Animal a : zoo) {
            a.move();
        }
    }

    // 定義父類別
    static class Animal {
        public void move() {
            System.out.println("動物移動中...");
        }
    }

    // 定義子類別 1
    static class Dog extends Animal {
        @Override
        public void move() {
            System.out.println("狗在跑");
        }
    }

    // 定義子類別 2
    static class Bird extends Animal {
        @Override
        public void move() {
            System.out.println("鳥在飛");
        }
    }
}
