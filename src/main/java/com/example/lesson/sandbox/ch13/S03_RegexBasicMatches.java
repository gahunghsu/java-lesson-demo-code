package com.example.lesson.sandbox.ch13;

public class S03_RegexBasicMatches {
    /**
     * 1. 教學目標
     * 展示 Regex 的核心價值——「一行程式碼取代幾十行邏輯」。
     *
     * 3. 講師講解重點 (Talking Points)
     * - 語法重點 : 強調 \d。解釋為什麼不是 \d (因為 Java String parser 先吃掉一層反斜線)。
     * - 比較 : 請學生回想上一張投影片的 taiwanPhone 方法，現在變成了一行 str.matches(pattern)。
     */
    public static void main(String[] args) {
        String str1 = "I love Java";
        String str2 = "0952-909-090";
        String str3 = "1111-1111111";

        // Regex 定義: 四個數字 - 三個數字 - 三個數字
        // 注意: Java 字串中 \d 必須寫成 \\d (雙重跳脫)
        String pattern = "\\d\\d\\d\\d-\\d\\d\\d-\\d\\d\\d";

        // 直接呼叫 String.matches()
        System.out.println("str1 是否符合格式: " + str1.matches(pattern)); // false
        System.out.println("str2 是否符合格式: " + str2.matches(pattern)); // true
        System.out.println("str3 是否符合格式: " + str3.matches(pattern)); // true (雖然不是手機號，但符合數字結構)
    }
}
