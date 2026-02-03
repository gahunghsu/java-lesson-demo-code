package com.example.lesson.sandbox.ch20;

public class S09_FinallyBlock {
    /**
     * 1. 教學目標
     * 展示 finally 的強大特性：即使 try 區塊中有 return 敘述，finally 區塊的程式碼依然會在方法返回前被執行。
     *
     * 3. 講師備課指引
     * - 應用場景 : 強調這特性對於關閉資料庫連線或檔案串流 (Close Resource) 非常重要，確保資源一定會被釋放。
     */
    public static void main(String[] args) {
        System.out.println("主程式開始");
        System.out.println("回傳結果: " + myTest());
    }

    public static String myTest() {
        try {
            System.out.println("進入 try 區塊");
            // 這裡有 return，理論上方法要結束了
            return "明志科技大學";
        } finally {
            // 但 finally 說: 等一下，我先執行完你再走!
            System.out.println("這是 finally block (即使有 return 也會執行)");
        }
    }
}
