package com.example.lesson.sandbox.ch15;

public class S02_ObjectMethods {
    /**
     * 1. 教學目標
     * 證明即使類別定義時沒有寫 extends Object，Java 編譯器也會隱式繼承。透過呼叫 Animal 類別中未定義的 hashCode() 方法來證明這一點。
     *
     * 3. 講師備課指引
     * - 引導視線 : 請學生看 Line 18 的 class Animal，確認裡面空空如也，沒有任何方法。
     * - 提問 : 問學生「第 25 行呼叫 animal.hashCode() 為什麼不會報錯?」。
     * - 結論 : Java 所有的類別，只要沒有指定父類別，預設就是 extends Object。
     */
    public static void main(String[] args) {
        Animal animal = new Animal();

        // 關鍵點: Animal 類別中明明沒有 hashCode() 方法，為什麼可以呼叫?
        // 答案: 因為它繼承自 Object，這是祖先給的能力。
        int hd = animal.hashCode(); // Animal 類別物件的哈希碼

        System.out.println("animal 的 hashCode:" + hd);
    }

    // 講師請看: 這裡只有定義屬性，沒有寫 extends，也沒有定義任何方法
    static class Animal {
        String name = "Dog";
        int age = 5;
    }
}
