package com.example.lesson.sandbox.ch12;

public class S07_DemoStringEquals {
    /**
     * 1. 教學目標
     * 強調字串內容比較 必須 使用 equals()，嚴禁使用 ==。
     *
     * 3. 講師講解重點 (Talking Points)
     * - Bug 來源 : 告訴學生，若在登入系統用 if (inputPassword == dbPassword)，即便宜碼輸入正確也可能無法登入，這就是 == 造成的 Bug。
     * - 最佳實踐 : 字串比較一律用 equals。
     */
    public static void main(String[] args) {
        String str1 = "Java";
        String str2 = new String("Java");

        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);

        System.out.println("\n=== 錯誤比較方式 (==) ===");
        // 比較的是記憶體位址
        System.out.println("str1 == str2: " + (str1 == str2)); // false (危險!)

        System.out.println("\n=== 正確比較方式 (equals) ===");
        // 比較的是字元內容
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // true (正確)
        
        String str3 = "AppLe";
        String str4 = "apple";
        
        System.out.println("\n=== 大小寫比較方式 (equalsIgnoreCase) ===");
        
        System.out.println("str3.equals(str4): " + str3.equals(str4)); // false
        System.out.println("str3.equalsIgnoreCase(str4): " + str3.equalsIgnoreCase(str4)); // true
    }
}
