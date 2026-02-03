package com.example.lesson.sandbox.ch12;

public class S03_DemoCharacterAdvanced {
    /**
     * 1. 教學目標
     * 展示不可見的「控制字元」檢測，以及 Character 如何處理進位制轉換（如 Hex 轉 Decimal）。
     *
     * 3. 講師講解重點 (Talking Points)
     * - 控制字元 : 解釋 isISOControl 用於過濾「非列印字元」, 防止資料庫存入亂碼或排版符號。
     * - Radix (基底) : 解釋 digit(char, radix) 的第二個參數。若設為 16，則 A-F 有效 ; 若設為 10，則 A-F 會回傳 -1。
     */
    public static void main(String[] args) {
        // --- 部分 1: 控制字元檢測 ---
        char chControl = '\t'; // Tab 鍵
        System.out.println("=== 控制字元檢測 ===");
        // isISOControl 可以偵測 \n, \t 等不可見字元
        System.out.println("'\t' 是控制字元? " + Character.isISOControl(chControl));
        System.out.println("'@' 是控制字元? " + Character.isISOControl('@'));

        // --- 部分 2: 進位轉換 (Hex to Decimal) ---
        System.out.println("\n=== 16進位數值轉換 (Radix 16) ===");
        // 將字元 'A' 視為 16 進位，轉換為 10 進位數值
        // 預期結果: A=10, F=15
        System.out.println("'1' 在16進位的值: " + Character.digit('1', 16));
        System.out.println("'A' 在16進位的值: " + Character.digit('A', 16));
        System.out.println("'F' 在16進位的值: " + Character.digit('F', 16));
        // 超出範圍測試
        System.out.println("'G' 在16進位的值: " + Character.digit('G', 16)); // 回傳 -1 代表無效
    }
}
