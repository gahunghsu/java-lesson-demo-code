package com.example.lesson.sandbox.ch17;

public class S04_DefaultMethod {
    /**
     * 1. 教學目標
     * 展示 Java 8 引入的 default 方法如何讓介面在不破壞現有實作類別的情況下新增功能 (向後相容性)，以及子類別如何選擇繼承或重寫。
     *
     * 3. 講師備課指引
     * - 情境假設 : 告訴學生「想像全世界已經有 100 種鳥實作了 Bird 介面，現在你想加一個 action() 功能」。如果沒有 default，那 100 個檔案都要打開來改；有了 default，現有程式碼完全不用動。
     */
    public static void main(String[] args) {
        Eagle eagle = new Eagle();
        eagle.showMe();
        eagle.action(); // 呼叫繼承來的 default 方法
    }

    interface Bird {
        void showMe(); // 傳統抽象方法

        // Java 8 新特性: Default 方法 (有實作區塊)
        // 講師說明: 如果不寫 default，所有實作類別都會壞掉
        default void action() {
            System.out.println("預設行為: 我會飛");
        }
    }

    static class Eagle implements Bird {
        // 必須實作抽象方法
        public void showMe() {
            System.out.println("我是老鷹");
        }

        // 講師說明: Eagle 這裡並沒有重寫 action()，直接繼承介面的版本
        // 當然，也可以選擇 @Override 把推掉
    }
}
