package com.example.lesson.sandbox.ch14;

public class S18_Downcasting {
    /**
     * 1. 教學目標
     * 說明向上轉型後會失去子類別特有功能，若要使用需轉型，但需防範轉型失敗。
     *
     * 3. 講師備課指引
     * - 情境 : 告訴學生「不是所有動物都是狗」。如果 animal 實際上是 Cat，強制轉成 Dog 就會發生 ClassCastException。
     * - 守門員 : 強調 instanceof 就像是警衛，確認身分後才放行。
     */
    public static void main(String[] args) {
        Animal animal = new Dog(); // Upcasting
        animal.walk();
        // animal.barking(); // 編譯錯誤: Animal 看不到 barking

        // 危險示範 (若 animal 其實是 Cat 會當機)
        // Dog dog = (Dog) animal;

        // 正確示範: 先檢查，再轉型
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal; // Downcasting
            System.out.println("轉型成功，呼叫狗的方法: ");
            dog.barking();
        }
    }

    static class Animal {
        public void walk() { System.out.println("Animal walking"); }
    }

    static class Dog extends Animal {
        public void walk() { System.out.println("Dog walking"); }
        public void barking() { System.out.println("Dog barking"); } // 狗獨有
    }
}
