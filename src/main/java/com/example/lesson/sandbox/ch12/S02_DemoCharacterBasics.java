package com.example.lesson.sandbox.ch12;

public class S02_DemoCharacterBasics {
    /**
     * 1. 教學目標
     * 展示 char 基本型別如何透過 Character 封裝類別的 static 方法 來判斷屬性（是否為數字、字母、大小寫）。
     *
     * 3. 講師講解重點 (Talking Points)
     * - 關鍵字 static : 請引導學生觀察我們是直接呼叫 Character.isXxx(), 不需要 new Character() , 這就是靜態工具方法的用法。
     * - 實務應用 : 特別強調 isLetterOrDigit, 說明這在註冊表單檢查 User ID 時非常實用, 避免使用者輸入特殊符號。
     */
    public static void main(String[] args) {
        // 測試字元 'A'
        char ch1 = 'A';
        // 測試字元 '5'
        char ch2 = '5';
        
        String str = "5";

        System.out.println("=== 檢測字元 ch1 = 'A' ===");
        System.out.println("'A' 是大寫字母? " + Character.isUpperCase(ch1)); // true
        System.out.println("'A' 是小寫字母? " + Character.isLowerCase(ch1)); // false
        System.out.println("'A' 是字母字元? " + Character.isLetter(ch1)); // true
        System.out.println("'A' 是數字字元? " + Character.isDigit(ch1)); // false

        System.out.println("\n=== 檢測字元 ch2 = '5' ===");
        System.out.println("'5' 是數字字元? " + Character.isDigit(ch2)); // true
        // 常用於驗證帳號密碼 (字母或數字皆可)
        System.out.println("'5' 是字母或數字? " + Character.isLetterOrDigit(ch2)); // true
    }
}
