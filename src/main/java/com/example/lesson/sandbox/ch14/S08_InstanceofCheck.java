package com.example.lesson.sandbox.ch14;

public class S08_InstanceofCheck {
    /**
     * 1. 教學目標
     * 利用 instanceof 運算子證明「子類別物件 也是一種 (IS-A) 父類別」。
     *
     * 3. 講師備課指引
     * - 邏輯推理 : 詢問學生 Eagle is Animal 會是 true 還是 false?
     * - 結論 : 繼承關係具備「傳遞性」，孫子也是家族的一份子。
     */
    public static void main(String[] args) {
        Fish fish = new Fish();
        Bird bird = new Bird();
        Eagle eagle = new Eagle();

        System.out.println("Fish is Animal: " + (fish instanceof Animal));   // true
        System.out.println("Bird is Animal: " + (bird instanceof Animal));   // true
        System.out.println("Eagle is Bird: " + (eagle instanceof Bird));     // true
        
        // 講師重點: Eagle 繼承 Bird, Bird 繼承 Animal, 所以 Eagle 也是 Animal
        System.out.println("Eagle is Animal: " + (eagle instanceof Animal)); // true
    }

    static class Animal {}
    static class Fish extends Animal {}
    static class Bird extends Animal {}
    static class Eagle extends Bird {}
}
