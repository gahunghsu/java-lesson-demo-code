package com.example.lesson.sandbox.ch15;

public class S05_HashCodeConflict {
    /**
     * 1. 教學目標
     * 展示 hashCode() 的計算結果，並說明 String 類別如何根據「內容」計算 Hash，導致不同物件實體卻有相同的 Hash。
     *
     * 3. 講師備課指引
     * - 執行觀察 : 執行程式，讓學生看到 msg3 和 msg4 的 Hash Code 是一模一樣的數字。
     * - 觀念強化 : 解釋 String 重寫了 hashCode() 規則，它不看記憶體位址，只看肚子裡的墨水 (內容)。
     */
    public static void main(String[] args) {
        // 1. 字串常數池 (String Pool) 的狀況
        String msg1 = "DeepStone";
        int hd1 = msg1.hashCode();
        System.out.println("DeepStone 的 hashCode: " + hd1);

        String msg2 = msg1; // 參照相同
        int hd2 = msg2.hashCode();
        System.out.println("DeepStone 的 hashCode: " + hd2);

        // 2. 不同的字串內容
        String msg3 = "明志科大";
        int hd3 = msg3.hashCode();
        System.out.println("明志科大 的 hashCode: " + hd3);

        // 3. 使用 new 關鍵字建立新物件 (記憶體位址不同)
        String msg4 = new String("明志科大");
        int hd4 = msg4.hashCode();

        // 講師強調: 請觀察 msg3 與 msg4
        // 雖然是不同物件(new)，但因為「內容相同」，String 的 hashCode 演算法算出來的結果是一樣的!
        System.out.println("明志科大 的 hashCode: " + hd4);
    }
}
