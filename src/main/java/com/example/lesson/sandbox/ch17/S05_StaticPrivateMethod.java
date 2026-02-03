package com.example.lesson.sandbox.ch17;

public class S05_StaticPrivateMethod {
    /**
     * 1. 教學目標
     * 展示介面越來越像類別的一面：使用 static 定義工具方法，使用 private 抽取重複邏輯 (Java 9+)，使程式碼更乾淨。
     *
     * 3. 講師備課指引
     * - 邏輯重用 : 強調 private 方法的價值在於「不讓實作類別看到雜亂的輔助程式碼，只暴露乾淨的 default 或 static 方法給外部使用」。
     */
    public static void main(String[] args) {
        Learning obj = new Learning();
        obj.method2();      // 測試 default -> private 呼叫鏈
        LearnJava.method3(); // 測試 static -> private static 呼叫鏈
    }

    interface LearnJava {
        // 1. 抽象方法
        void method1();

        // 2. Default 方法 (對外公開的 API)
        default void method2() {
            System.out.println("進入 default 方法...");
            commonLogic(); // 呼叫 private 方法重用邏輯
        }

        // 3. Static 方法 (工具方法，不需實例化)
        static void method3() {
            System.out.println("進入 static 方法...");
            commonStaticLogic(); // 呼叫 private static 方法
        }

        // 4. Private 方法 (Java 9+): 僅供介面內部使用，隱藏實作細節
        private void commonLogic() {
            System.out.println("執行重複的邏輯 (Private)");
        }

        // 5. Private Static 方法
        private static void commonStaticLogic() {
            System.out.println("執行重複的靜態邏輯 (Private Static)");
        }
    }

    static class Learning implements LearnJava {
        public void method1() {
            System.out.println("實作抽象方法");
        }
    }
}
