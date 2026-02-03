package com.example.lesson.sandbox.ch12;

public class S14_DemoInputClean {
    /**
     * 1. 教學目標
     * 展示 Method Chaining (方法鍊) 技巧，一行程式碼完成資料清理。
     *
     * 3. 講師講解重點 (Talking Points)
     * - 鏈式呼叫 (Chaining) : 解釋 str.trim().toLowerCase() 的執行順序是由左至右。先產生一個去空白的暫存字串，再對該暫存字串轉小寫。
     * - 實務場景 : 這在處理 Email 登入時是標準 SOP。
     */
    public static void main(String[] args) {
        // 模擬使用者輸入 (前後有不小心按到的空白，大小寫混雜)
        String rawInput = "  UserAdmin  ";

        System.out.println("原始輸入: [" + rawInput + "]");

        // 任務: 標準化為 "useradmin" 以便比對資料庫

        // Step 1: trim() 去除空白 -> "UserAdmin"
        // Step 2: toLowerCase() 轉小寫 -> "useradmin"
        String cleanInput = rawInput.trim().toLowerCase();

        System.out.println("清理結果: [" + cleanInput + "]");

        // 驗證
        if (cleanInput.equals("useradmin")) {
            System.out.println("登入帳號驗證通過 !");
        }
    }
}
