package com.example.lesson.sandbox.ch25;

public class S02_AnonymousDiamond {
    /**
     * 1. 教學目標
     * 展示 Java 9 之後，匿名內部類別 (Anonymous Inner Class) 也可以使用「鑽石符號 <>」進行型別推斷，不再需要重複寫泛型型別。
     *
     * 3. 講師備課指引
     * - 版本比較 : 先展示 ch25_1.java (舊寫法)，再切換到 ch25_2.java。
     * - 關鍵差異 : 請圈選 new StringAdd<>() 的部分，強調編譯器現在足夠聰明，能從左邊的 StringAdd<String> 推斷出右邊也是 String。
     */
    public static void main(String[] args) {
        // 講師說明:
        // Java 7 寫法: new StringAdd<String>() { ... }
        // Java 9+ 寫法: new StringAdd<>() { ... } (鑽石符號自動推斷)

        StringAdd<String> obj = new StringAdd<>() {
            // 實作抽象方法
            String display(String x, String y) {
                return x + y;
            }
        };

        System.out.println(obj.display("Java", "王者歸來"));
    }

    abstract static class StringAdd<T> {
        abstract T display(T x, T y);
    }
}
