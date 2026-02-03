package com.example.lesson.sandbox.ch20;

public class S02_ExceptionTypes {
    /**
     * 1. 教學目標
     * 展示語法錯誤 (Syntax)、語意錯誤 (Semantic) 與執行期錯誤 (Runtime) 的差異，特別聚焦於「程式碼看起來沒問題，但跑起來會當機」的 Runtime Error。
     *
     * 3. 講師備課指引
     * - 操作重點 : 執行程式，讓學生看到 Console 紅色的異常堆疊訊息，並指出 程式結束 那一行沒有被印出來，證明程式在異常發生點就「崩潰」了。
     */
    public static void main(String[] args) {
        // 1. 正常執行
        System.out.println("6/2 = " + myDiv(6, 2));

        // 2. 執行期錯誤 (Runtime Error)
        // 語法完全正確，編譯會過
        // 但執行到這一行時，JVM 會拋出 ArithmeticException: / by zero
        System.out.println("8/0 = " + myDiv(8, 0));

        System.out.println("程式結束"); // 這行永遠不會執行到
    }

    public static int myDiv(int x, int y) {
        return x / y;
    }
}
