package com.example.lesson.sandbox.ch13;

public class S11_ComplexStructure {
    /**
     * 1. 教學目標
     * 展示邏輯或 | 的用法，這在處理「髒資料」或「多重格式」時非常有空。
     *
     * 3. 講師講解重點 (Talking Points)
     * - 管道符號 : 解釋 | 代表 OR。
     * - 跳脫字元 : 解釋 \( (是為了匹配真正的左括號，而不是 Group 的開始。
     */
    public static void main(String[] args) {
        String str1 = "02-23339999";    // 格式 A
        String str2 = "(02)-23339999";  // 格式 B
        String str3 = "(111)-1111111";  // 格式 B

        // 複合 Regex:
        // Part 1: \(\d{2}\)-\d{8} --> 對應 (02)-xxxxxxxx
        // |     : 或
        // Part 2: \d{2}-\d{8}     --> 對應 02-xxxxxxxx
        String pattern = "\\(\\d{2}\\)-\\d{8}|\\d{2}-\\d{8}";

        System.out.println("02-23339999 : " + str1.matches(pattern)); // true
        System.out.println("(02)-23339999 : " + str2.matches(pattern)); // true
        System.out.println("(111)-1111111 : " + str3.matches(pattern)); // true
    }
}
