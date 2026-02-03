package com.example.lesson.sandbox.ch24;

import java.util.LinkedList;

public class S07_LinkedListStack {
    /**
     * 1. 教學目標
     * 展示 LinkedList 的 addLast 與 removeLast 方法，如何完美對應堆疊 (Stack) 的後進先出 (LIFO) 行為。
     *
     * 3. 講師備課指引
     * - 執行結果 : 務必讓學生看到 50 先出來，然後是 40... 最後是 10。這證明了 Last In First Out。
     */
    public static void main(String[] args) {
        // 使用 LinkedList 當作 Stack
        LinkedList<Integer> stack = new LinkedList<>();

        // 1. Push 操作 (模擬堆疊)
        for (int i = 10; i <= 50; i += 10) {
            stack.addLast(i); // 加在尾端
        }
        System.out.println("stack: " + stack); // [10, 20, 30, 40, 50]

        // 2. Pop 操作 (模擬取出堆疊)
        int loop = stack.size();
        for (int i = 1; i <= loop; i++) {
            // removeLast() 移除並回傳尾端元素 (LIFO)
            System.out.printf("pop 第%d 筆元素%d: \n", i, stack.removeLast());
            System.out.println("目前 stack: " + stack);
        }
    }
}
