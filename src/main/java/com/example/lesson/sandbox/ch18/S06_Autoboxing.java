package com.example.lesson.sandbox.ch18;

public class S06_Autoboxing {
    /**
     * 1. 教學目標
     * 證明當我們將 int 賦值給 Integer 時，編譯器在背後偷偷建立了物件。
     *
     * 3. 講師備課指引
     * - 觀察重點 : x 本來是 int，但 xObj 可以呼叫 getClass()，證明它已經變成了一個「物件」。
     */
    public static void main(String[] args) {
        // autoboxing 自動封箱方法
        int x = 5;

        // 講師強調: 這裡沒有寫 new Integer(x), 但編譯器幫我們做
        // 實際編譯器呼叫了 Integer.valueOf(x)
        Integer xObj = x;

        // 驗證: 雖然寫法像基本型態賦值，但它真的是一個物件
        System.out.println("xObj 所屬類別:" + xObj.getClass());
        // 輸出: class java.lang.Integer
    }
}
