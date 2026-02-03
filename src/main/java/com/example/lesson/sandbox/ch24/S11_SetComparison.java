package com.example.lesson.sandbox.ch24;

import java.util.*;

public class S11_SetComparison {
    /**
     * 1. 教學目標
     * 透過兩個幾乎一樣的程式碼 (只差在類別不同)，直觀展示 HashSet 不保證順序，而 LinkedHashSet 保證插入順序的特性。
     *
     * 3. 講師備課指引
     * - 結果驗證 : HashSet 的輸出順序每次執行可能都不同 (取決於 Hash 演算法)，但 LinkedHashSet 絕對是 "北京 香港 台北 東京 曼谷"。這對於需要「歷史紀錄」的功能很重要。
     */
    public static void main(String[] args) {
        // === 實驗 1: HashSet (無序) ===
        System.out.println("--- HashSet (順序不可預測) ---");
        Set<String> hashSet = new HashSet<>();
        hashSet.add("北京");
        hashSet.add("香港");
        hashSet.add("台北");
        hashSet.add("東京");
        hashSet.add("曼谷");

        // 觀察輸出順序是否與加入順序一致? (通常不一致)
        for (String s : hashSet) System.out.print(s + " ");
        System.out.println();

        // === 實驗 2: LinkedHashSet (有序) ===
        System.out.println("\n--- LinkedHashSet (保留插入順序) ---");
        Set<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("北京");
        linkedSet.add("香港");
        linkedSet.add("台北");
        linkedSet.add("東京");
        linkedSet.add("曼谷");

        // 觀察輸出順序 (保證一致)
        for (String s : linkedSet) System.out.print(s + " ");
        System.out.println();
    }
}
