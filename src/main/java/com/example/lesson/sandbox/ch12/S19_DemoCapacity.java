package com.example.lesson.sandbox.ch12;

public class S19_DemoCapacity {
    /**
     * 1. 教學目標
     * 揭露 StringBuilder 底層自動擴充陣列的公式 : (舊容量 * 2) + 2。
     *
     * 3. 講師講解重點 (Talking Points)
     * - 效能優化建議 : 如果你預知字串會很長 (例如 5000 字)，最好一開始就 new StringBuilder(5000)，避免中間發生多次「擴充 -> 複製陣列」的動作，這也是一種效能調校。
     */
    public static void main(String[] args) {
        // 建立空的 StringBuilder, 預設容量是 16
        StringBuilder sb = new StringBuilder();

        System.out.println("初始長度(length): " + sb.length());
        System.out.println("初始容量(capacity): " + sb.capacity()); // 16

        // 1. 加入 16 個字元 (剛好填滿)
        sb.append("0123456789ABCDEF");
        System.out.println("\n--- 填滿 16 字元後 ---");
        System.out.println("容量: " + sb.capacity()); // 還是 16

        // 2. 再加 1 個字元 (溢位 -> 觸發擴充)
        sb.append("G");
        System.out.println("\n--- 溢位後 (17 字元) ---");
        System.out.println("內容: " + sb);
        // 擴充公式: 原容量(16) * 2 + 2 = 34
        System.out.println("新容量: " + sb.capacity()); // 預期 34
    }
}
