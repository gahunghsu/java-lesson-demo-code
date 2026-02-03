package com.example.lesson.sandbox.ch19;

import static java.lang.Math.*;

public class S05_StaticImport {
    /**
     * 1. 教學目標
     * 展示 import static 的用法，讓數學函式 abs, sqrt 能夠像在寫數學公式一樣直接呼叫，省去重複寫 Math. 的麻煩。
     *
     * 3. 講師備課指引
     * - 優缺點分析 : 雖然寫起來很爽 (簡潔)，但要提醒學生如果濫用 (例如匯入太多不同類別的 static)，會導致程式碼難以閱讀，不知道 abs() 到底是誰的 abs。
     */
    public static void main(String[] args) {
        // 原本寫法: System.out.println(Math.abs(10));

        // 靜態匯入後: 直接呼叫方法
        System.out.println(abs(10)); // 絕對值運算
        System.out.println(sqrt(4)); // 求平方根

        // 講師補充: 甚至連 PI 也可以直接用
        System.out.println("PI: " + PI);
    }
}
