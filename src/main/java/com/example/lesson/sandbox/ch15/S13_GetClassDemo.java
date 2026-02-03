package com.example.lesson.sandbox.ch15;

public class S13_GetClassDemo {
    /**
     * 1. 教學目標
     * 展示 getClass() 如何在執行時期回傳物件的真實型別 (Runtime Type)，這對於多形與除錯非常重要。
     *
     * 3. 講師備課指引
     * - 輸出觀察 : 指出輸出結果開頭的 class 字樣。
     * - 補充說明 : 雖然 MyClass 裡面什麼都沒寫，但透過 getClass() 證明了它在 JVM 中有註冊身分。這是一個 final 方法，子類別無法修改 (不能偽造身分)。
     */
    public static void main(String[] args) {
        // 1. 陣列與字串的 Class
        char[] ch = {'明','志','科','技','大','學'};
        String str = new String(ch);

        // 2. 自定義類別的 Class
        MyClass obj = new MyClass();

        // 呼叫 getClass() 取得類別資訊
        // 這裡會顯示完整的套件名稱 + 類別名稱 (Full Qualified Name)
        System.out.println("str 類別: " + str.getClass()); // class java.lang.String
        System.out.println("obj 類別: " + obj.getClass()); // class ...S13_GetClassDemo$MyClass
    }

    // 空類別
    static class MyClass {}
}
