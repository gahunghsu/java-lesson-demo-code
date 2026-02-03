package com.example.lesson.sandbox.ch12;

public class S12_DemoSearchLoop {
    /**
     * 1. 教學目標
     * 利用 indexOf(str, fromIndex) 實作迴圈，找出文章中所有出現關鍵字的位置。
     *
     * 3. 講師講解重點 (Talking Points)
     * - While 迴圈邏輯 : 解釋 index = indexOf(..., index + 1) 是如何推動搜尋游標往後移動的。如果不 +1，程式會進入無窮迴圈一直在原地找到同一個字。
     */
    public static void main(String[] args) {
        String content = "Java is fun. I love Java because Java is powerful.";
        String keyword = "Java";

        System.out.println("文章內容: " + content);
        System.out.println("尋找關鍵字: " + keyword);
        System.out.println("--- 搜尋結果 ---");

        int count = 0;
        int index = content.indexOf(keyword); // 第一次搜尋

        while (index != -1) {
            System.out.println("找到第 " + (++count) + " 個，位置在 Index: " + index);

            // 關鍵: 從「目前位置 + 1」往後繼續找
            index = content.indexOf(keyword, index + 1);
        }

        System.out.println("總共找到 " + count + " 次。");
    }
}
