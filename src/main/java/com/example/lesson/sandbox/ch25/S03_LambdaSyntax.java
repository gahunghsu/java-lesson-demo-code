package com.example.lesson.sandbox.ch25;

public class S03_LambdaSyntax {
    /**
     * 1. 教學目標
     * 展示如何將傳統的匿名內部類別 (Anonymous Inner Class) 簡化為 Lambda 表達式。
     *
     * 3. 講師備課指引
     * - 語法解析 : 指出 () 代表 draw() 方法的參數列表 (無參數)，-> 是箭頭，{} 是方法主體。
     * - 功能介紹 : 順便提一下 @FunctionalInterface 註解，說明 Lambda 只能用於「只有一個抽象方法」的介面。
     */
    public static void main(String[] args) {
        int r = 5;

        // Before: 匿名內部類別寫法 (參考 ch25_3)
        // Shapes obj = new Shapes() { public void draw() { ... } };

        // After: Lambda 表達式寫法
        // 語法: () -> { 程式區塊 }
        Shapes obj = () -> {
            System.out.println("繪半徑是 " + r + " 的圓");
        };

        obj.draw();
    }

    @FunctionalInterface
    interface Shapes {
        void draw();
    }
}
