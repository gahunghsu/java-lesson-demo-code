package com.example.lesson.sandbox.ch17;

public class S02_InterfaceIntro {
    /**
     * 1. 教學目標
     * 展示介面 (Interface) 如何讓不同繼承體系 (鳥與飛機) 的類別，透過 implements 關鍵字擁有共同的行為能力 (Like-A 關係)。
     *
     * 3. 講師備課指引
     * - 引導視線 : 請學生注意 Line 25 與 Line 32 的 implements 關鍵字。
     * - 觀念解釋 : 強調 Bird 和 Airplane 是完全不同的東西，但因為都實作了 Fly，所以在 Main 方法中都可以被宣告為 Fly 型態，這就是多型 (Polymorphism) 的威力。
     */
    public static void main(String[] args) {
        // 1. 使用介面作為變數型態 (Upcasting)
        Fly bird = new Bird();
        bird.flying();

        // 2. 即使 Airplane 不是動物，也可以被視為 Fly
        Fly airplane = new Airplane();
        airplane.flying();
    }

    // 鳥類別實作 Fly 介面
    static class Bird implements Fly {
        public void flying() {
            System.out.println("鳥在飛行 (拍打翅膀)");
        }
    }

    // 飛機類別實作 Fly 介面
    static class Airplane implements Fly {
        public void flying() {
            System.out.println("飛機在飛行 (引擎推動)");
        }
    }
}
