package com.example.lesson.sandbox.ch13;

public class S04_StringReplaceAll {
    /**
     * 1. 教學目標
     * 示範 Regex 不只能用於驗證 (matches)，還能用於資料清洗與遮罩 (replaceAll)。
     *
     * 3. 講師講解重點 (Talking Points)
     * - API 差異 : matches 是看「全部」，replaceAll 是找「局部」並替換。
     * - 執行結果 : 字串中出現的兩組號碼都會被替換掉，證明 replaceAll 的全域特性。
     */
    public static void main(String[] args) {
        // 模擬一段包含個資的字串
        String str = "Please call my secretary using 0930-919-919 or 0952-001-001";

        // 定義手機號碼的模式 (使用了數量詞 {})
        String pattern = "\\d{4}(-\\d{3}){2}";//"\\d{4}-\\d{3}-\\d{3}"

        // 定義替換後的樣子 (遮罩處理)
        String newstr = "0930-***-***";

        // replaceAll: 找到「所有」符合 pattern 的地方並替換
        System.out.println("原始字串: " + str);
        System.out.println("遮罩結果: " + str.replaceAll(pattern, newstr));
    }
}
