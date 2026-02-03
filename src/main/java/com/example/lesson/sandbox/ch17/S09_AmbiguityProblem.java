package com.example.lesson.sandbox.ch17;

public class S09_AmbiguityProblem {
    /**
     * 1. 教學目標
     * 演示當一個類別實作多個介面，且這些介面擁有同名變數時，如何解決編譯器的 "Ambiguity" (模糊不清) 錯誤。
     *
     * 3. 講師備課指引
     * - 編譯器視角 : 解釋編譯器在看到 age 時，左看是 Dog，右看是 Cat，兩邊都有，所以它不知道你要哪一個，必須由工程師手動指定 (Explicitly Specify)。
     */
    public static void main(String[] args) {
        Pet obj = new Pet();
        obj.running();
    }

    interface Dog {
        int age = 5; // public static final
        void running();
    }

    interface Cat {
        int age = 6; // 同名變數
        void running();
    }

    static class Pet implements Dog, Cat {
        public void running() {
            // 錯誤示範: 直接呼叫 age 會讓編譯器混亂
            // System.out.println("我的寵物是 " + age + " 歲"); // Error: Reference to 'age' is ambiguous

            // 正確示範: 明確指定介面名稱
            System.out.println("Dog 的年齡: " + Dog.age);
            System.out.println("Cat 的年齡: " + Cat.age);
        }
    }
}
