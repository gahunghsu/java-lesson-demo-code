package com.example.lesson.sandbox.ch25;

import java.util.*;

public class S10_CollectionFactory {
    /**
     * 1. 教學目標
     * 展示 Java 9 引入的 List.of 所建立的集合是「不可變的 (Immutable)」，嘗試修改會導致執行期錯誤。
     *
     * 3. 講師備課指引
     * - 錯誤提示 : 務必執行程式讓學生看到 UnsupportedOperationException。
     * - 應用場景 : 解釋這非常適合用於「設定檔」或「固定選項清單」，因為不用擔心被意外修改。
     */
    public static void main(String[] args) {
        // 使用工廠方法建立 List (內容不可變)
        List<String> list = List.of("北京", "香港", "台北");

        try {
            // 嘗試新增元素 -> 這行會報錯!
            list.add("kk");
        } catch (UnsupportedOperationException e) {
            System.out.println("錯誤: List.of 產生的集合不可修改! ");
            e.printStackTrace();
        }

        // 遍歷 List
        list.forEach(System.out::println);
    }
}
