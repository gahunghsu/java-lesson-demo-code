package com.example.lesson.sandbox.ch24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class S26_ScoreManager {
	public static void main(String[] args) {
        // 1. 初始化 HashMap 並新增資料
        Map<String, Integer> students = new HashMap<>();
        students.put("A", 50);
        students.put("B", 85);
        students.put("C", 90);
        students.put("D", 70);
        students.put("E", 60);

        // 2. 使用 Iterator 安全刪除不及格 (小於 60 分) 的資料
        // 注意：在遍歷 Map 時若直接使用 students.remove() 會拋出 ConcurrentModificationException
        Iterator<Map.Entry<String, Integer>> it = students.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getValue() < 60) {
                it.remove();
            }
        }

        // 3. 將剩下的分數轉為 List 並進行排序
        List<Integer> scores = new ArrayList<>(students.values());
        Collections.sort(scores);

        // 4. 輸出結果
        if (!scores.isEmpty()) {
            System.out.println("及格名單分數: " + scores);
            System.out.println("最高分: " + scores.get(scores.size() - 1));
        } else {
            System.out.println("沒有人及格。");
        }
    }
}
