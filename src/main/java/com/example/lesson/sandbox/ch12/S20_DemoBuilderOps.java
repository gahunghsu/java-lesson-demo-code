package com.example.lesson.sandbox.ch12;

public class S20_DemoBuilderOps {
    /**
     * 1. 教學目標
     * 展示 StringBuilder 獨有的 reverse (反轉) 與 insert (插入) 功能，這是 String 做不到的。
     *
     * 3. 講師講解重點 (Talking Points)
     * - LeetCode 神器 : reverse() 在解決「迴文判斷」或「數字反轉」演算法題目時非常好用。
     * - 操作特性 : 這些方法都會直接修改原本的物件 (Mutable)，不需要像 String 那樣重新賦值。
     */
    public static void main(String[] args) {
        // 原始字串
        StringBuilder sb = new StringBuilder("ABCDE");
        System.out.println("原始: " + sb);

        // 1. 反轉 (Reverse) - 常用於迴文題目
        sb.reverse();
        System.out.println("反轉後: " + sb); // EDCBA

        // 2. 插入 (Insert)
        // 目前是 EDCBA, 我們想在 Index 2 (D後面) 插入 "XYZ"
        sb.insert(2, "XYZ");
        System.out.println("插入後: " + sb); // EDXYZCBA

        // 3. 刪除 (Delete)
        // 刪除剛才插入的 XYZ (Index 2 到 5)
        sb.delete(2, 5); // 包頭不包尾
        System.out.println("刪除後: " + sb); // EDCBA
    }
}
