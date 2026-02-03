package com.example.lesson.sandbox.ch19;

import java.util.*;

public class S03_ImportDeclaration {
    /**
     * 1. 教學目標
     * 展示如何透過 import 關鍵字，讓我們在程式中可以直接使用簡名 (Simple Name) 來呼叫
     * Scanner 與 Random，而無需寫出冗長的完整名稱。
     *
     * 3. 講師備課指引
     * - 觀念澄清 : 告訴學生，雖然寫 import java.util.*; 很爽，但編譯器並不會真的把底下幾百個類別都塞進來，它只會去找 Scanner 和 Random 而已，不用擔心效能問題。
     */
    public static void main(String[] args) {
        // 使用 Random 類別 (來自 java.util)
        // 若無 import，須寫成 java.util.Random ran = new java.util.Random();
        Random ran = new Random();
        int pwd = ran.nextInt(10); // 產生 0-9 間的目標數字
        int num;

        // 使用 Scanner 類別 (來自 java.util)
        Scanner scanner = new Scanner(System.in);

        for (;;) { // 無限迴圈猜數字
            System.out.print("請猜 0-9 的數字:");
            num = scanner.nextInt();

            if (num == pwd) {
                System.out.println("恭喜猜對了!!");
                break;
            }
            if (num > pwd)
                System.out.println("猜錯了請猜小一點!!");
            else
                System.out.println("猜錯了請猜大一點!!");
        }
    }
}
