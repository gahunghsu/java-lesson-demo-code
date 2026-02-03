package com.example.lesson.sandbox.ch25;

import java.util.*;
import java.util.stream.Collectors;

public class S12_StreamToMapTrap {
    /**
     * 1. 教學目標
     * 展示 Collectors.toMap 在遇到重複 Key 時的預設行為 (拋出例外)，並演示如何使用 Merge Function 解決此問題。
     *
     * 3. 講師備課指引
     * - 陷阱警告 : 這是實務上極易發生的 Bug。資料庫撈出來的資料若有重複 ID，轉 Map 時就會讓整個系統掛掉。
     * - Merge Function : 解釋 (v1, v2) -> v2 的意思就是「當發生衝突時，我選擇後面進來的那一個 (v2)」。
     */
    public static void main(String[] args) {
        // 模擬資料: 注意 ID "U001" 重複了
        List<User> users = Arrays.asList(
                new User("U001", "Alice"),
                new User("U002", "Bob"),
                new User("U001", "Alice_New") // 重複的 Key
        );

        System.out.println("--- 實驗 1: 未處理重複 Key (會當機) ---");
        try {
            Map<String, String> map = users.stream()
                    .collect(Collectors.toMap(User::getId, User::getName));
        } catch (IllegalStateException e) {
            System.out.println("捕捉到例外: " + e); // Duplicate key
        }

        System.out.println("\n--- 實驗 2: 使用 Merge Function 解決衝突 ---");
        Map<String, String> safeMap = users.stream()
                .collect(Collectors.toMap(
                        User::getId,
                        User::getName,
                        (oldValue, newValue) -> newValue // 策略: 若重複，保留新值
                ));

        safeMap.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    static class User {
        String id;
        String name;
        public User(String id, String name) { this.id = id; this.name = name; } 
        public String getId() { return id; }
        public String getName() { return name; }
    }
}
