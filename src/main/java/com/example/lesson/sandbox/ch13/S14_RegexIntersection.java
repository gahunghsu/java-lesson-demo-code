package com.example.lesson.sandbox.ch13;

public class S14_RegexIntersection {
    /**
     * 1. 教學目標
     * 演示自訂字元集合 [] 以及進階的「交集運算 &&」，這是 Java Regex 的特殊功能。
     *
     * 3. 講師講解重點 (Talking Points)
     * - 語法結構 : 特別指出 && 的寫法，這是許多其他語言的 Regex 不支援的功能，但在 Java 很強大。
     * - 應用場景 : 排除特定幾個「保留字」或「禁忌字」時非常好用。
     */
    public static void main(String[] args) {
        // 題目: 必須是 A-Z，但不能是 A 或 B (即 C-Z)
        // [A-Z]    : 所有大寫
        // [^AB]    : 除了 A 和 B 以外的所有字元
        // &&       : 兩者交集 (Intersection)
        String pattern = "[A-Z&&[^AB]]";

        System.out.println("測試 C (應為 true): " + "C".matches(pattern));
        System.out.println("測試 Z (應為 true): " + "Z".matches(pattern));

        System.out.println("測試 A (應為 false): " + "A".matches(pattern)); // 在排除名單
        System.out.println("測試 B (應為 false): " + "B".matches(pattern)); // 在排除名單
        System.out.println("測試 1 (應為 false): " + "1".matches(pattern)); // 不是大寫字母
    }
}
