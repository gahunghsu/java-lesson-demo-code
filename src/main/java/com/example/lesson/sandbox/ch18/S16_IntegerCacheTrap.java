package com.example.lesson.sandbox.ch18;

public class S16_IntegerCacheTrap {
    /**
     * 1. 教學目標
     * 揭示 Java 面試中最經典的陷阱題：為什麼 100 == 100 是 true，但 1000 == 1000 卻是 false？解釋 Integer Cache 機制。
     *
     * 3. 講師備課指引
     * - 關鍵數字 : 請學生背下來 -128 到 127 這個範圍。
     * - 最佳實踐 : 只要是物件 (Wrapper Class)，比較數值一律用 .equals()，只有基本型態 (int) 才用 ==，這樣永遠不會踩雷。
     */
    public static void main(String[] args) {
        // === 情境 1: 範圍內 (-128 ~ 127) ===
        // 自動封箱會使用 Integer.valueOf()，此範圍內有快取 (Cache)
        Integer a = 100;
        Integer b = 100;

        System.out.println("a == b (100): " + (a == b));
        // 結果: true (指向同一個快取物件)

        // === 情境 2: 範圍外 (>= 128) ===
        // 超出快取範圍，每次都會 new 新物件
        Integer c = 1000;
        Integer d = 1000;

        System.out.println("c == d (1000): " + (c == d));
        // 結果: false (不同的記憶體位址)

        // === 正確比較方式 ===
        // 永遠使用 equals() 比對物件內容
        System.out.println("c.equals(d): " + c.equals(d));
        // 結果: true

        // === 補充: 使用 new 關鍵字 ===
        // new 永遠不會使用快取
        Integer e = new Integer(100);
        Integer f = new Integer(100);
        System.out.println("new(100) == new(100): " + (e == f));
        // 結果: false
    }
}
