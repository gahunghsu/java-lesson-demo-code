package com.example.lesson.sandbox.ch12;

import org.springframework.util.StringUtils;

public class S09_DemoInspection {
    /**
     * 1. 教學目標
     * 展示 Java 11 新增的 isBlank() 與傳統 isEmpty() 的差異，以及如何避免 NullPointerException。
     *
     * 3. 講師講解重點 (Talking Points)
     * - 空白陷阱 : 使用者在表單輸入 " " (空白鍵) 時，isEmpty() 會說是 false (有資料)，這通常不是我們要的。這時 isBlank() 或 trim() 就很重要。
     * - Null 安全 : 強調在呼叫任何 String 方法前，檢查 != null 是 Java 工程師的職業道德。
     */
    public static void main(String[] args) {
    	String a = "Test"; 
    	a.toUpperCase(); 
    	System.out.println(a);
    	a = a.toUpperCase(); 
    	System.out.println(a);

    }

    // 模擬類似 Spring/Commons-Lang 的 StringUtils.hasText
    public static boolean hasText(String str) {
        return str != null && !str.trim().isEmpty();
    }
}
