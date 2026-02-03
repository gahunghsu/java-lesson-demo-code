package com.example.lesson.sandbox.ch24;

import java.util.*;

public class S12_TreeSetDemo {
    /**
     * 1. 教學目標
     * 展示 TreeSet 的自動排序功能。即使我們亂序加入數字，取出來時依然是由小到大排列。
     *
     * 3. 講師備課指引
     * - 背後原理 : 解釋這是因為 Integer 實作了 Comparable 介面。如果是自定義類別放入 TreeSet，必須實作 Comparable 或傳入 Comparator，否則會報錯。
     */
    public static void main(String[] args) {
        // TreeSet 會自動排序 (Natural Ordering)
        TreeSet<Integer> set = new TreeSet<>();

        // 亂序加入
        set.add(8);
        set.add(3);
        set.add(11);
        set.add(1);
        set.add(6);

        // 驗證排序與導航方法
        System.out.println("最小值 (first): " + set.first()); // 1
        System.out.println("最大值 (last): " + set.last());   // 11

        System.out.println("--- TreeSet 自動排序結果 ---");
        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " "); // 1 3 6 8 11
        }
    }
}
