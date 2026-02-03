package com.example.lesson.sandbox.ch25;

import java.util.*;

public class S09_MethodReferences {
    /**
     * 1. 教學目標
     * 展示當 Lambda 主體僅僅是「呼叫另一個已存在的方法」且參數完全對應時，可以使用 :: 雙冒號語法來進一步簡化。
     *
     * 3. 講師備課指引
     * - 轉換邏輯 : 告訴學生，只要看到 x -> method(x) 這種形式，通常可以轉成 Class::method。
     * - 可讀性 : 強調這種寫法讓程式碼讀起來更像是在說話：「對這個 List 的每個元素，執行 Println」。
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("北京");
        list.add("香港");
        list.add("台北");

        // 原始 Lambda 寫法:
        // list.forEach(s -> System.out.println(s));

        System.out.println("--- 使用 Method Reference ---");
        // 方法參照 (Method Reference) 寫法:
        // 因為 Lambda 接收一個參數 s，並直接傳給 System.out.println(s)
        // 所以可以簡寫為 System.out::println
        list.forEach(System.out::println);
    }
}
