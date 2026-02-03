package com.example.lesson.sandbox.ch13;

public class S06_Quantifiers {
    /**
     * 1. 教學目標
     * 介紹 {n} 數量詞，解決 \d\d\d... 寫法太冗長的問題。
     *
     * 3. 講師講解重點 (Talking Points)
     * - 可讀性提升 : 比較 \d\d\d\d 與 \d{4}，後者清楚表達了「意圖」。
     * - 記憶點 : 大括號 {} 是用來「計數」的。
     */
    public static void main(String[] args) {
        String str1 = "I love Java";
        String str2 = "0952-909-090";

        // 進化版 Regex: 使用 {n} 指定重複次數
        // \d{4} 代表 \d 重複 4 次
        String pattern = "\\d{4}-\\d{3}-\\d{3}";

        System.out.println("Pattern: " + pattern);
        System.out.println("str1 matches: " + str1.matches(pattern));
        System.out.println("str2 matches: " + str2.matches(pattern));
    }
}
