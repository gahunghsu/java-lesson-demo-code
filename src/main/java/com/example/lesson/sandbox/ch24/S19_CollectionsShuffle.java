package com.example.lesson.sandbox.ch24;

import java.util.*;

public class S19_CollectionsShuffle {
    /**
     * 1. 教學目標
     * 展示 Collections 工具類別提供的演算法。shuffle 常用於遊戲 (洗牌) 或抽獎程式。
     *
     * 3. 講師備課指引
     * - 應用場景 : 除了洗牌，Collections.sort() (排序), Collections.reverse() (反轉) 也是非常常用的工具，它們都是直接修改傳入的 List。
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // 建立 1~10 的有序清單
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        System.out.println("洗牌前 (Ordered): " + list);

        // 重複洗牌 5 次並觀察結果
        for (int i = 1; i <= 5; i++) {
            Collections.shuffle(list); // 隨機打亂順序
            System.out.println("第 " + i + " 次洗牌: " + list);
        }
    }
}
