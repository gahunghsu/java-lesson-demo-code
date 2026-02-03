package com.example.lesson.sandbox.ch20;

public class S18_CustomException {
    /**
     * 1. 教學目標
     * 展示如何繼承 Exception 類別來創造自定義的異常，讓錯誤訊息更具語意化。
     *
     * 3. 講師備課指引
     * - 應用場景 : 告訴學生，在大型專案中，我們常會定義 UserNotFoundException, InventoryEmptyException 等異常，這樣看 log 時就能一目瞭然，而不是只看到通用的 RuntimeException。
     */
    public static void main(String[] args) {
        try {
            // 2. 拋出異常
            System.out.println("準備拋出異常...");
            throw new MyException("這是測試訊息");
        } catch (MyException e) {
            // 3. 捕捉異常
            System.out.println("捕捉到自定義異常! ");
            System.out.println(e); // 會呼叫 toString()
        }
    }

    // 1. 定義異常類別
    static class MyException extends Exception {
        String str;

        MyException(String msg) {
            super(msg); // 呼叫父類別建構子
            this.str = msg;
        }

        // 覆寫 toString 以提供自定義訊息格式
        public String toString() {
            return "我的例外 MyException 發生了: " + str;
        }
    }
}
