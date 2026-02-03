package com.example.lesson.sandbox.ch13;

import java.util.regex.*;

public class S18_PatternMatcherFind {
    /**
     * 1. 教學目標
     * 進入 Regex 的深水區。不只是驗證 (matches)，而是要「探勘」與「萃取」 (Extraction)。展示 find() 的迭代特性。
     *
     * 3. 講師講解重點 (Talking Points)
     * - SOP 三部曲 : 強調 Pattern.compile -> matcher(input) -> while(m.find()) 的標準流程。
     * - find() 行為 : 解釋 find() 像是一個游標，每次呼叫都會往後移動，直到字串結束回傳 false。
     */
    public static void main(String[] args) {
        // 混合了文字與多組電話號碼的字串
        String msg = "Please call my secretary using 0930-919-919 or 0952-001-001";

        // 編譯 Regex 物件 (Compile)
        String patternStr = "\\d{4}(-\\d{3}){2}";
        Pattern p = Pattern.compile(patternStr);

        // 產生 Matcher (匹配器)
        Matcher m = p.matcher(msg);

        boolean found = false;

        // 重點: 使用 while 迴圈配合 find() 進行掃描
        while (m.find()) {
            System.out.println("找到號碼: " + m.group()); // 取得當前匹配內容
            System.out.println(" - 起始位置: " + m.start());
            System.out.println(" - 結束位置: " + m.end());
            found = true;
        }
        
//        System.out.println(msg.indexOf("0"));

        if (!found) {
            System.out.println("搜尋失敗");
        }
        
//        String pattern1 = "^A\\d+Z$";
//        String pattern2 = "A.*\\d+.*Z";
//        String[] testStrings = {
//			"A1123Z",
//			"Axyz456Z",
//			"Axyz456bcdZ",
//			"B123Z",
//			"A123Y",
//			"A789Zextra"
//		};
//        
//        for (String testStr : testStrings) {
//			boolean matchesPattern1 = testStr.matches(pattern1);
//			boolean matchesPattern2 = testStr.matches(pattern2);
//			System.out.printf("測試字串: %-12s | Pattern1: %-5b | Pattern2: %-5b%n",
//							  testStr, matchesPattern1, matchesPattern2);
//		}
        
    }
}
