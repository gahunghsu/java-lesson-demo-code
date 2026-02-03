package com.example.lesson.sandbox.ch14;

public class S23_AnonymousInnerClass {
    /**
     * 1. 教學目標
     * 展示匿名內部類別 (Anonymous Inner Class) 的寫法，用於一次性的方法覆寫，無須額外建立 .java 檔。
     *
     * 3. 講師備課指引
     * - 應用場景 : 告訴學生這種寫法在視窗程式設計 (GUI) 的事件監聽，或是執行緒 (Thread) 中非常常見，適合「用完即丟」的場景。
     */
    public static void main(String[] args) {
        // 匿名內部類別: 定義與建立同時進行
        // new 父類別() { ... 實作內容 ... }.方法();

        new Animal() {
            // 覆寫 moving 方法
            public void moving() {
                System.out.println("貓可以走路和跳 (匿名類別實作)");
            }
        }.moving(); // 直接呼叫方法
        
        new Dog() {
            // 覆寫 barking 方法
            public void barking() {
                System.out.println("汪汪 汪汪 汪汪");
            }
        }.barking(); // 直接呼叫方法
    }

    static class Animal {
        public void moving() {
            System.out.println("動物可以活動");
        }
    }
    
    static class Dog {
        public void barking() {
            System.out.println("旺旺");
        }
    }
}
