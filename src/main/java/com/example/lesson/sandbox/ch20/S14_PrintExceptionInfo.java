package com.example.lesson.sandbox.ch20;

public class S14_PrintExceptionInfo {
    /**
     * 1. 教學目標
     * 比較 e.toString(), e.getMessage(), e.printStackTrace() 三種方法的輸出內容，讓學生知道在不同情境下該用哪一個。
     *
     * 3. 講師備課指引
     * - 使用建議 :
     *   o getMessage(): 適合顯示給使用者看的簡單提示。
     *   o printStackTrace(): 開發者除錯用，能看到第幾行出錯。
     */
    public static void main(String[] args) {
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("=== 1. toString() ===");
            System.out.println(e.toString()); // 類別名 + 訊息

            System.out.println("\n=== 2. getMessage() ===");
            System.out.println(e.getMessage()); // 只有訊息 (最簡潔)

            System.out.println("\n=== 3. printStackTrace() ===");
            e.printStackTrace(); // 完整堆疊追蹤 (除錯用)
        }
    }
}
