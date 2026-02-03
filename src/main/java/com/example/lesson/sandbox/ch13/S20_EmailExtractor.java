package com.example.lesson.sandbox.ch13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class S20_EmailExtractor {
	public static void main(String[] args) {
        String content = "聯絡我們：service@example.com 或 admin@tech.tw";
        
        // 1. 定義 Email Regex 模式
        // 注意：Java 17+ 處理 Regex 轉義字元需用雙反斜線 \\
//        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern p = Pattern.compile("\\w+@\\w+\\.[a-zA-Z]{2,}"); 
        Matcher m = p.matcher(content);

        
        // 2. 編譯模式並建立 Matcher
//        Pattern p = Pattern.compile(regex);
//        Matcher m = p.matcher(content);
        
        // 3. 使用 while (m.find()) 持續尋找下一個匹配項
        System.out.println("偵測到的 Email 清單：");
        while (m.find()) {
            // group() 會回傳上一次 find() 找到的內容
            System.out.println(m.group());
        }
    }
}
