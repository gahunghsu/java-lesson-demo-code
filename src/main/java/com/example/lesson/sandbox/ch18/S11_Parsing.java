package com.example.lesson.sandbox.ch18;

public class S11_Parsing {
    /**
     * 1. 教學目標
     * 展示 Integer.valueOf 與 parseInt 的強大之處，不僅能解析十進位，還能透過 radix 參數解析各種進制。
     *
     * 3. 講師備課指引
     * - 語法糖 : 告訴學生這就是「語法糖 (Syntactic Sugar)」。寫起來很甜 (簡潔)，但背後邏輯 (建立物件) 沒有少。
     * - 反向操作 : 可順便提一下拆箱 (Unboxing)，例如 int y = xObj;。
     */
    public static void main(String[] args) {
        // 1. 基本十進位
        Integer x = Integer.valueOf(10);
        Integer y = Integer.valueOf("101"); // 預設為 10 進位 (一百零一)

        // 2. 二進位解析 (Radix = 2)
        // "10111" -> 16 + 0 + 4 + 2 + 1 = 23
        Integer b2 = Integer.valueOf("10111", 2);

        // 3. 八進位解析 (Radix = 8)
        // "15" -> 1*8 + 5 = 13
        Integer b8 = Integer.valueOf("15", 8);

        // 4. 十六進位解析 (Radix = 16)
        // "18a" -> 1*256 + 8*16 + 10 = 394
        Integer b16 = Integer.valueOf("18a", 16);

        System.out.println("十進位 10: " + x);
        System.out.println("字串 101: " + y);
        System.out.println("二進位 10111: " + b2);
        System.out.println("八進位 15: " + b8);
        System.out.println("十六進位 18a: " + b16);

        System.out.println(x.getClass()); // 確認回傳的是 Integer 物件
    }
}
