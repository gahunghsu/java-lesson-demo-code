package com.example.lesson.sandbox.ch24;

import java.util.*;

public class S16_HashMapDemo {
    /**
     * 1. 教學目標
     * 展示 Map 的基本操作：put (新增/覆蓋), get (查詢), containsKey (檢查), remove (刪除)。這就像操作一本字典。
     *
     * 3. 講師備課指引
     * - 重點提醒 : Map 的 Key 是唯一的。如果再次執行 map.put(101, "新學校")，舊的值會被覆蓋。請講師可現場演示這一點。
     */
    public static void main(String[] args) {
        // Key: 學號 (Integer), Value: 學校名稱 (String)
        HashMap<Integer, String> map = new HashMap<>();

        // 1. 新增資料 (put)
        map.put(101, "明志科大");
        map.put(102, "台灣科大");
        map.put(103, "台北科大");

        System.out.println("HashMap 初始內容: " + map);
        System.out.println("元素個數: " + map.size());

        // 2. 查詢資料 (get / containsKey)
        System.out.println("學號 101 是: " + map.get(101));
        System.out.println("是否有學號 101? " + map.containsKey(101));

        // 3. 刪除資料 (remove)
        map.remove(103);
        System.out.println("刪除 103 後內容: " + map);

        // 4. 清空 (clear)
        map.clear();
        System.out.println("清空後是否為空? " + map.isEmpty());
    }
}
