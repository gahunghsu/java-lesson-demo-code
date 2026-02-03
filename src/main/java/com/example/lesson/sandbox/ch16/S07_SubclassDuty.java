package com.example.lesson.sandbox.ch16;

public class S07_SubclassDuty {
    /**
     * 1. 教學目標
     * 展示繼承抽象類別後，若不實作抽象方法，子類別會編譯失敗。同時展示 Rectangle 與 Circle 如何各自實作不同的邏輯。
     *
     * 3. 講師備課指引
     * - 嘗試刪除 : 試著把 Rectangle 內的 area() 方法註解掉，觀察 IDE 報錯 (Class must be abstract or implement abstract method)。
     * - 多形預告 : 指出雖然公式不同，但方法名稱都叫 area()，這是多形的基礎。
     */
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2, 3);
        Circle circle = new Circle(2);

        System.out.println("矩形面積: " + rectangle.area());
        System.out.println("圓面積: " + circle.area());
    }

    abstract static class Shape {
        // 定義契約: 所有形狀都要能計算面積
        public abstract double area();
    }

    static class Rectangle extends Shape {
        protected double height, width;

        Rectangle(double height, double width) {
            this.height = height;
            this.width = width;
        }

        // 義務實作: 矩形面積公式
        public double area() {
            return height * width;
        }
    }

    static class Circle extends Shape {
        protected double r;

        Circle(double r) {
            this.r = r;
        }

        // 義務實作: 圓形面積公式
        public double area() {
            return Math.PI * r * r;
        }
    }
}
