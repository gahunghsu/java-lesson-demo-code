package com.example.lesson.sandbox.ch15;

public class S09_EqualsTruth {
    /**
     * 1. 教學目標
     * 展示 String 類別與 Object 預設行為在 equals() 方法上的差異。String 比對文字內容，而預設的 equals (如 StringBuilder 所用) 僅比對記憶體位址。
     *
     * 3. 講師備課指引
     * - 關鍵輸出 : 務必讓學生看到最後一行的 false。
     * - 觀念解釋 : 解釋這就是為什麼我們說「StringBuilder 使用的是 Object 類別的 equals」。在 StringBuilder 的世界裡，除非是「同一個物件」，否則 equals 永遠為 false。
     */
    public static void main(String[] args) {
        // 1. String 的比較 (內容相同，物件不同)
        String str1 = "明志科大";
        String str2 = new String("明志科大"); // 強制建立新物件

        // 2. StringBuilder 的比較 (內容相同，物件不同)
        StringBuilder strB1 = new StringBuilder(str1);
        StringBuilder strB2 = new StringBuilder(str2);

        // 演示 A: String 的 equals
        // 結果: true (因為 String 聰明地比對了內容)
        System.out.println("使用 String 類別的 equals: " + str1.equals(str2));

        // 演示 B: StringBuilder 的 equals (它繼承自 Object，沒改寫)
        // 結果: false (因為 Object 的 equals 笨笨的，只看是不是同一個記憶體位址，類似 ==)
        System.out.println("使用 Object 類別(StringBuilder)的 equals: " + strB1.equals(strB2));
    }
}
