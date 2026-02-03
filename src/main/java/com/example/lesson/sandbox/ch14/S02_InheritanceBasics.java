package com.example.lesson.sandbox.ch14;

public class S02_InheritanceBasics {
    /**
     * 1. 教學目標
     * 展示如何透過 extends 關鍵字，讓 Dog 類別直接擁有 Animal 類別定義好的 eat() 與 sleep() 方法，
     * 證明程式碼重用性。
     *
     * 3. 講師備課指引
     * - 引導視線 : 請學生看 Line 13 class Dog extends Animal，強調這是建立父子關係的唯一語法。
     * - 執行驗證 : 執行 main 方法，指出 dog 物件雖然沒有定義 eat()，但卻能成功執行，這就是繼承的威力。
     */
    public static void main(String[] args) {
        Dog dog = new Dog();
        // 驗證: 呼叫繼承來的方法
        dog.eat();      // 輸出: 正在吃食物
        dog.sleep();    // 輸出: 正在睡覺
        // 驗證: 呼叫自有的方法
        dog.barking();  // 輸出: 正在叫
    }

    // 父類別
    static class Animal {
        public void eat() {
            // Animal 方法 eat
            System.out.println("正在吃食物");
        }

        public void sleep() {
            // Animal 方法 sleep
            System.out.println("正在睡覺");
        }
    }

    // 子類別
    // 講師強調: 使用 extends 繼承父類別能力
    static class Dog extends Animal {
        public void barking() {
            // Dog 類別自有的方法 barking
            System.out.println("正在叫");
        }
    }
}
