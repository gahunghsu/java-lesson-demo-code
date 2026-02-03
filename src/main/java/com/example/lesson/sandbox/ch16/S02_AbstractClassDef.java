package com.example.lesson.sandbox.ch16;

public class S02_AbstractClassDef {
    /**
     * 1. 教學目標
     * 展示如何將一個類別定義為「抽象類別」，並說明這代表它是一個未完成的模具，專門用來被繼承。
     *
     * 3. 講師備課指引
     * - 關鍵語法 : 請圈選 Line 20 的 abstract 關鍵字。
     * - 觀念引導 : 告訴學生 Shape 只是這兩個圖形的「富爸爸」或「概念」，現實生活中你無法拿出一個東西只叫「形狀」而不具備具體外觀。
     */
    public static void main(String[] args) {
        // Shape shape = new Shape(); // 預告: 這行稍後會報錯
        Rectangle rect = new Rectangle();
        rect.draw(); // 輸出: 繪製矩形

        Circle circle = new Circle();
        circle.draw(); // 輸出: 繪製圓
    }

    // 講師強調: 加上 abstract 關鍵字，代表這是一個抽象類別 (未完成的模具)
    abstract static class Shape {
        public void draw() {
            // 這裡暫時留空或寫預設實作，稍後會將其改為抽象方法
        }
    }

    static class Rectangle extends Shape {
        public void draw() {
            System.out.println("繪製矩形");
        }
    }

    static class Circle extends Shape {
        public void draw() {
            System.out.println("繪製圓");
        }
    }
}
