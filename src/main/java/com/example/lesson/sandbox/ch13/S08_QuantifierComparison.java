package com.example.lesson.sandbox.ch13;

public class S08_QuantifierComparison {
    /**
     * 1. 教學目標
     * 釐清 * (0 到多) 與 + (1 到多) 的關鍵差異，這是考試與實務最常搞混的點。
     *
     * 3. 講師講解重點 (Talking Points)
     * - 關鍵差異 : 請全班看 Johnson 的測試結果。* 通過，但 + 失敗。
     * - 口訣複習 : * 是「沒關係，越多越好」，+ 是「一定要有」。
     */
    public static void main(String[] args) {
        // 測試 1: 星號 * (可有可無)
        String patternStar = "John(na)*son";
        System.out.println("--- 測試 * (0 到多) ---");
        System.out.println("Johnson (na 出現 0 次): " + "Johnson".matches(patternStar)); // true
        System.out.println("Johnnason (na 出現 1 次): " + "Johnnason".matches(patternStar)); // true
        System.out.println("Johnnanason (na 出現 2 次): " + "Johnnanason".matches(patternStar)); // true

        // 測試 2: 加號 + (至少一個)
        String patternPlus = "John(na)+son";
        System.out.println("\n--- 測試 + (1 到多) ---");
        System.out.println("Johnson (na 出現 0 次): " + "Johnson".matches(patternPlus)); // false (差異點!)
        System.out.println("Johnnason (na 出現 1 次): " + "Johnnason".matches(patternPlus)); // true
    }
}
