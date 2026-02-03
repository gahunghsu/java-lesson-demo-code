package com.example.lesson.sandbox.ch16;

public class S06_AbstractMethod {
    /**
     * 1. 教學目標
     * 展示抽象方法沒有大括號 {}，直接以分號結尾，代表「只定義規格，不實作細節」。
     *
     * 3. 講師備課指引
     * - 語法特徵 : 強調 abstract void draw(); 這一行。這就是所謂的「繼承契約」，父類別規定子類別「一定要會畫圖」，但怎麼畫隨便你。
     */
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.draw();
    }

    abstract static class Shape {
        // 講師強調:
        // 1. 有 abstract 關鍵字
        // 2. 結尾是分號 (;)，沒有大括號 {}
        public abstract void draw();
    }

    static class Circle extends Shape {
        // 子類別必須實作這個方法
        public void draw() {
            System.out.println("繪製圓圖");
        }
    }
}
