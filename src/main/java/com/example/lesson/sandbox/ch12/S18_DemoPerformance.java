package com.example.lesson.sandbox.ch12;

public class S18_DemoPerformance {
    /**
     * 1. 教學目標
     * 用殘酷的效能數據，讓學生永遠記住「迴圈內不要用 String + String」。
     *
     * 3. 講師講解重點 (Talking Points)
     * - 震撼教育 : 執行結果通常會相差幾千倍 (例如 5000ms vs 2ms)。
     * - 原因 : String 的 + 是 $O(n^2)$ 的複雜度 (因為不斷複製舊內容)，StringBuilder 是 $O(n)$。
     */
    public static void main(String[] args) {
        int loopCount = 100_000; // 測試十萬次

        // --- 測試 1: String 串接 (+) ---
        long start1 = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < loopCount; i++) {
            s += "A"; // 每次都產生新物件
        }
        long end1 = System.currentTimeMillis();
        System.out.println("String (+) 耗時: " + (end1 - start1) + " ms");

        // --- 測試 2: StringBuilder ---
        long start2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < loopCount; i++) {
            sb.append("A"); // 在同一個陣列操作
        }
        long end2 = System.currentTimeMillis();
        System.out.println("StringBuilder 耗時: " + (end2 - start2) + " ms");

        // 預期結果: String 可能跑 3~10秒, StringBuilder 只要 5~10 毫秒
    }
}
