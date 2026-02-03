package com.example.lesson.sandbox.ch12;

public class S15_DemoSplitJoin {
    /**
     * 1. 教學目標
     * 將逗號分隔字串 (CSV) 轉為陣列，處理後再重組回字串。
     *
     * 3. 講師講解重點 (Talking Points)
     * - Regex 注意 : 提醒若分隔符號是 . (點)，split 裡面要寫 \.，因為 . 在正規表示法代表「任意字元」。但逗號 , 可以直接用。
     * - String.join : 這是 Java 8 非常好用的功能，以前要自己寫迴圈串接還要去判斷最後一個逗號要不要刪除。
     */
    public static void main(String[] args) {
        // CSV 資料: 姓名,國文,英文
        String csvData = "John,80,90";
        System.out.println("原始 CSV: " + csvData);

        // 1. Split: 切割成陣列
        String[] parts = csvData.split(",");

        System.out.println("--- 解析後 ---");
        System.out.println("姓名: " + parts[0]);
        System.out.println("國文: " + parts[1]);
        System.out.println("英文: " + parts[2]);

        // 2. 修改資料 (國文加分)
        parts[1] = "85";

        // 3. Join: 重新組合 (Java 8+)
        // String.join(分隔符, 陣列/元素)
        String newData = String.join("-", parts); // 改用連字號連接

        System.out.println("--- 重組後 ---");
        System.out.println(newData);
    }
}
