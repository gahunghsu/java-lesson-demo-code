package com.example.lesson.sandbox.ch17;

public class S10_DiamondProblem {
    /**
     * 1. 教學目標
     * 展示多重繼承中最棘手的「方法衝突」問題。重點演示「類別優先 (Class Wins)」原則，以及如何使用 Interface.super.method() 解決 default 方法衝突。
     *
     * 3. 講師備課指引
     * - 原則口訣 :
     *   1. 類別贏介面: 只要父類別有，就聽爸爸的 (Horse)。
     *   2. 介面吵架要勸架: 如果只有介面互相談判，你自己重寫一個，然後用 Xxx.super.method() 指定要用誰的。
     */
    public static void main(String[] args) {
        System.out.println("--- 類別優先原則 ---");
        new Pet().running(); // 輸出: Horse is running

        System.out.println("\n--- 介面衝突解決 ---");
        new MutantPet().running(); // 輸出: 自己跑 -> Dog 跑 -> Cat 跑
    }

    // === 情境 1: 類別優先原則 (Class Wins) ===
    interface Dog {
        default void running() { System.out.println("Dog is running"); }
    }

    static class Horse {
        public void running() { System.out.println("Horse is running"); }
    }

    // Pet 繼承 Horse 又實作 Dog，兩邊都有 running
    static class Pet extends Horse implements Dog {
        // 這裡不需要實作 running，因為 Horse 的實作自動勝出 (Class Wins)
    }

    // === 情境 2: 兩個介面衝突 (Diamond Problem) ===
    interface Cat {
        default void running() { System.out.println("Cat is running"); }
    }

    // MutantPet 同時實作 Dog 和 Cat，兩邊都有 default running -> 衝突!
    static class MutantPet implements Dog, Cat {
        @Override
        public void running() {
            System.out.println("變種寵物自己跑");
            // 解決方案: 明確指定要呼叫哪一個父介面的實作
            Dog.super.running();
            Cat.super.running();
        }
    }
}
