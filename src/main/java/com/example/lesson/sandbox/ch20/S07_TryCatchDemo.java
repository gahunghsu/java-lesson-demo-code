package com.example.lesson.sandbox.ch20;

public class S07_TryCatchDemo {
    /**
     * 1. 教學目標
     * 展示如何使用 try-catch 區塊來「接住」異常，讓程式即使發生錯誤也能優雅地繼續執行，而不是直接當機。
     *
     * 3. 講師備課指引
     * - 關鍵差異 : 對比 S02 的例子 (崩潰) 與 S07 的例子 (存活)。強調 try-catch 是保護程式流程的關鍵。
     */
    public static void main(String[] args) {
        System.out.println("6/2 = " + myDiv(6, 2));
        System.out.println("8/0 = " + myDiv(8, 0));
        System.out.println("9/4 = " + myDiv(9, 4));
    }

    public static String myDiv(int x, int y) {
        try {
            // 嘗試執行可能出錯的程式碼
            return Integer.toString(x / y);
        } catch (ArithmeticException e) {
            // 捕捉到除數為 0 的異常
            System.out.println("捕捉到異常: " + e);
            return "錯誤: 除數不能為 0"; // 優雅地回傳錯誤訊息，而非讓程式崩潰
        }
    }
}
