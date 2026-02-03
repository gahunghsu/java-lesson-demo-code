package com.example.lesson.sandbox.ch15;

public class S06_StringVsStringBuilderHash {
    /**
     * 1. 教學目標
     * 這是本章重點。對比 String (看內容) 與 StringBuilder (看位址/預設行為) 的巨大差異，解釋為何 StringBuilder 內容相同但 Hash 不同。
     *
     * 3. 講師備課指引
     * - 陷阱提示 : StringBuilder 沒有重寫 hashCode()，所以它直接繼承 Object 的實作 (根據記憶體位址)。
     * - 結果預測 : 告訴學生，如果你依賴 StringBuilder 的 HashCode 去做資料比對，你一定會失敗，因為每個物件的碼都不一樣。
     */
    public static void main(String[] args) {
        // === 第一組: String (重寫了 HashCode) ===
        String msg1 = "DeepStone";
        int hd1 = msg1.hashCode();
        System.out.println("String 類別 DeepStone 的 hashCode: " + hd1);

        // 將 String 轉為 StringBuilder
        StringBuilder msg2 = new StringBuilder(msg1);
        int hd2 = msg2.hashCode();
        // 這裡會印出一個基於記憶體位址的數字
        System.out.println("Object 類別(StringBuilder)DeepStone 的 hashCode: " + hd2);

        // === 第二組: 內容相同的比較 ===
        String msg3 = "明志科大";
        int hd3 = msg3.hashCode();
        System.out.println("String 類別明志科大的 hashCode: " + hd3);

        // 建立另一個內容相同的 StringBuilder
        StringBuilder msg4 = new StringBuilder(msg3);
        int hd4 = msg4.hashCode();

        // 講師強調: 請比較 msg2 與 msg4 (內容都是 DeepStone 和 明志科大 的對應)
        // 雖然它們內容不同("DeepStone" vs "明志科大")，但重點是它們使用的是 Object 原生的 hashCode
        // 即使你再 new 一個內容一樣的 StringBuilder，Hash 也會不同 (因為位址不同)
        System.out.println("Object 類別(StringBuilder)明志科大的 hashCode: " + hd4);

        // [AI 補充演示] 講師可額外加入這行證明 StringBuilder 內容相同 Hash 卻不同:
        // StringBuilder msg5 = new StringBuilder("明志科大");
        // System.out.println("另一個 StringBuilder(明志科大): " + msg5.hashCode());
        // 結果會與 msg4 不同
    }
}
