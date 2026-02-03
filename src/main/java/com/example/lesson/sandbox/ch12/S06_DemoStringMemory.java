package com.example.lesson.sandbox.ch12;

public class S06_DemoStringMemory {
    /**
     * 1. 教學目標
     * 視覺化證明 String Pool (字面值) 與 Heap (new) 的記憶體位址不同。
     *
     * 3. 講師講解重點 (Talking Points)
     * - 記憶體圖解 : 講到 str1 == str3 為 false 時，請在白板畫圖 : Pool 裡面有一個 "明志...", Heap 裡面有一個全新的 "明志..."。
     * - 面試題 : 這是 Java 面試最常見的陷阱題，請學生務必記住 new 關鍵字就是「新門牌號碼」的意思。
     */
    public static void main(String[] args) {
        // 情況 1: 字面值建立 (String Literal) -> 放入 String Pool
        String str1 = "明志科技大學";
        String str2 = "明志科技大學";

        // 情況 2: 建構子建立 (Constructor) -> 強制在 Heap 建立新物件
        String str3 = new String("明志科技大學");

        System.out.println("str1 = " + str1);
        System.out.println("str3 = " + str3); // 內容看起來一樣

        System.out.println("\n=== 記憶體位址比較 (==) ===");
        // 因為 str1 和 str2 都指向 Pool 中的同一個常數，所以 true
        System.out.println("str1 == str2 ? " + (str1 == str2));

        // str3 是 new 出來的，有獨立地址，所以 false
        System.out.println("str1 == str3 ? " + (str1 == str3));
        
        str1 = "Hello";
        
        String str4 = "Hello";
        
        System.out.println("str2=" + str2);
        
        System.out.println("str1 == str2 ? " + (str1 == str2));
        
        System.out.println("str1 == str4 ? " + (str1 == str4));
    }
}
