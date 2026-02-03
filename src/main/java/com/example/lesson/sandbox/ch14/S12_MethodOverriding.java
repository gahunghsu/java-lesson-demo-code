package com.example.lesson.sandbox.ch14;

public class S12_MethodOverriding {
    /**
     * 1. 教學目標
     * 展示子類別如何透過覆寫改變父類別的行為，並強調 @Override 註解的重要性。
     *
     * 3. 講師備課指引
     * - 嘗試錯誤 : 可以試著故意把 Cat 的方法名改成 move() (少 ing)，若有 @Override 編譯器會馬上報錯，證明註解的保護作用。
     */
    public static void main(String[] args) {
        Animal a = new Animal();
        Cat c = new Cat();

        a.moving(); // 印出: 動物可以活動
        c.moving(); // 印出: 貓可以走路和跳 (執行了覆寫後的版本)
    }

    static class Animal {
        public void moving() {
            System.out.println("動物可以活動");
        }
    }

    static class Cat extends Animal {
        // 講師強調: 加上 @Override 讓編譯器幫忙檢查
        @Override
        public void moving() {
            // 重新定義行為
            System.out.println("貓可以走路和跳");
        }
    }
}
