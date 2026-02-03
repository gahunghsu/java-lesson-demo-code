package com.example.lesson.sandbox.ch21;

public class S02_MainThread {
    /**
     * 1. 教學目標
     * 雖然可以打開 Windows 工作管理員，但透過程式碼取得目前執行緒 (Current Thread) 的資訊，能讓學生更直觀理解「main 方法本身就是一個執行緒」。
     *
     * 3. 講師備課指引
     * - 執行觀察 : 預設名稱通常為 main。
     * - 觀念強化 : 告訴學生，即使我們沒有 new Thread()，Java 程式一執行，JVM 就會自動建立一個 Main Thread 來執行 main() 方法。
     */
    public static void main(String[] args) {
        // 取得目前正在執行這行程式碼的執行緒 (這裡是 main 執行緒)
        Thread thread = Thread.currentThread();

        System.out.println("目前執行緒名稱: " + thread.getName());
        System.out.println("目前執行緒 ID: " + thread.getId());

        // 演示: 更改執行緒名稱
        thread.setName("MyThread");
        System.out.println("更改後的執行緒名稱: " + thread.getName());
    }
}
