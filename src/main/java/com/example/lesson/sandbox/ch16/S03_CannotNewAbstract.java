package com.example.lesson.sandbox.ch16;

public class S03_CannotNewAbstract {
    /**
     * 1. 教學目標
     * 現場演示 new AbstractClass() 導致的編譯錯誤，強化「抽象類別不能實體化」的觀念。
     *
     * 3. 講師備課指引
     * - 錯誤演示 : 在 IDE 中直接輸入 new Shape()，讓學生看到紅色波浪底線。
     * - 原因解釋 : 解釋因為 Shape 是「未完成的藍圖」，你不能直接住進藍圖裡，必須先蓋成房子 (Circle)。
     */
    public static void main(String[] args) {
        // === 講師演示重點 ===
        // 請取消下面這行的註解，展示 IDE 的紅字錯誤
//         Shape shape = new Shape();
        // 錯誤訊息: Shape is abstract; cannot be instantiated

        // 正確用法: 必須 new 子類別
        Circle circle = new Circle();
        circle.draw();
    }

    abstract static class Shape {
        public void draw() {
            System.out.println("繪製圓");
        }
    }

    static class Circle extends Shape {
        // 子類別必須實作這個方法
    }
}
