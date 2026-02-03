package com.example.lesson.sandbox.ch15;

public class S11_ToStringDemo {
    /**
     * 1. 教學目標
     * 展示當我們直接印出物件時，預設的 toString() 會輸出什麼「天書」，並展示如何透過 Override (覆寫) 來修正這個問題。
     *
     * 3. 講師備課指引
     * - Before/After : 建議先執行註解中的 ch15_6 概念 (如果不覆寫)，讓學生看到 ClassName@HexCode 的格式。
     * - 講解 : 切換到 toString() 的目的是為了讓人類看懂。現在印出來變成 "Dog 今年 5 歲"，可讀性大幅提升。
     */
    public static void main(String[] args) {
        Animal animal = new Animal();
        // 當 println 接到物件時，會自動呼叫 animal.toString()
        System.out.println("列出物件: " + animal);
    }

    static class Animal {
        String name = "Dog";
        int age = 5;

        // 講師強調: 這個 @Override 與 toString 方法是關鍵
        // 我們將原本回傳記憶體位址的行為，改成回傳有意義的資料
        @Override
        public String toString() {
            return this.name + " 今年 " + this.age + " 歲";
        }
    }
}
