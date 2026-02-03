package com.example.lesson.sandbox.ch14;

public class S03_ConstructorOrder {
    /**
     * 1. 教學目標
     * 證明當建立子類別物件時，Java 會強制優先執行父類別的建構方法 (Constructor Chaining)。
     *
     * 3. 講師備課指引
     * - 關鍵輸出 : 執行程式，請學生大聲唸出 Console 的順序。先印出 Animal... 才是 Dog...。
     * - 觀念解釋 : 解釋這是因為 Dog 建構子第一行隱藏了 super()，代表「先有爸爸，才有兒子」。
     */
    public static void main(String[] args) {
        // 建立子類別物件，觸發連鎖反應
        Dog dog = new Dog();
    }

    static class Animal {
        Animal() {
            // 講師強調: 父類別建構子先被執行
            System.out.println("執行 Animal 建構方法... ");
        }

        public void eat() {}
        public void sleep() {}
    }

    static class Dog extends Animal {
        Dog() {
            // 講師強調: 父類別執行完，才輪到子類別
            System.out.println("執行 Dog 建構方法... ");
        }

        public void barking() {}
    }
}
