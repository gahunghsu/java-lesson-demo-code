package com.example.lesson.sandbox.ch12;

public class S08_DemoImmutability {
    /**
     * 1. 教學目標
     * 證明 String 的「修改」其實是「偷換變數指向」，原物件並未改變。
     *
     * 3. 講師講解重點 (Talking Points)
     * - 觀察 Hash : 請學生看 Console 輸出的兩個數字完全不同。
     * - 不可變的代價 : 如果寫迴圈做 str + i 一萬次，就會產生一萬個垃圾物件。這也是稍後介紹 StringBuilder 的伏筆。
     */
    public static void main(String[] args) {
        String str = "Hello";

        // 印出原始記憶體識別碼 (Identity HashCode 代表記憶體地址的特徵)
        System.out.println("原始內容: " + str);
        System.out.println("原始地址(Hash): " + System.identityHashCode(str));

        System.out.println("\n--- 執行 str = str + \" World\" ---");

        // 試圖修改字串
        str = str + " World";

        System.out.println("修改後內容: " + str);
        System.out.println("修改後地址(Hash): " + System.identityHashCode(str));

        // 結論 : Hash 不同，代表 str 已經指向了一個全新的物件
        // 舊的 "Hello" 仍留在記憶體中 (直到被 GC 回收)
    }
}
