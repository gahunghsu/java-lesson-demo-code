package com.example.lesson.sandbox.ch13;

import java.util.regex.*;

public class S26_EmailExtractor {
    /**
     * 1. 教學目標
     * 綜合實作挑戰 Part 1 的解答。模擬真實世界的爬蟲或資料清洗任務 (Email Extraction)。
     *
     * 3. 講師講解重點 (Talking Points)
     * - 分析 Regex : 逐步拆解 [\w.-]+ 的含義。
     * - 雜訊過濾 : 請學生觀察為何 fake@.com 沒有被抓出來 (因為我們限制了 @ 後面必須有字元且有點)。
     * - 價值 : 這就是大數據資料前處理 (Pre-processing) 的核心技術。
     */
    public static void main(String[] args) {
        // 模擬從網頁或文件中讀取的髒亂資料
        String text = "Contact us: user@example.com, admin@test.org., admin-user@test.org, or admin-admin-user@test.org."
                + "Invalid emails: fake@.com, @site.com shouldn't match.";

        // 簡易版 Email Regex:
        // [\w.-]+ : 使用者名稱 (允許字母、數字、點、減號)
        // @       : 必須有 @
        // [\w.-]+ : 網域名稱
        // \.      : 必須有 .
        // [a-z]{2,} : 頂級網域至少 2 碼 (如 .tw, .com)
        String regex = "[\\w.-]+@[\\w.-]+\\.[a-z]{2,}";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);

        System.out.println("--- 開始 Email 探勘 ---");
        int count = 0;
        while (m.find()) {
            count++;
            System.out.println("找到第 " + count + " 筆: " + m.group());
        }

        // 預期輸出: user@example.com, admin@test.org
        // fake@.com (缺網域) 和 @site.com (缺帳號) 不應被抓出來
    }
}
