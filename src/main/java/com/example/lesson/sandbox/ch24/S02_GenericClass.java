package com.example.lesson.sandbox.ch24;

public class S02_GenericClass {
    /**
     * 1. 教學目標
     * 展示如何定義一個可以接受任何型別的泛型類別 MyData<T>，並證明在 main 方法中，我們可以靈活地放入 Integer, Double, String 而不需要重複寫三個不同的類別。
     *
     * 3. 講師備課指引
     * - 重點觀察 : 請學生看 Line 22, 27, 32。我們用了同一個 MyData 類別，卻能處理三種完全不同的資料型態，這就是泛型的威力 (Code Reuse)。
     */
    public static void main(String[] args) {
        // 1. 使用 Integer 實例化
        MyData<Integer> m = new MyData<>();
        m.setobj(10); // 自動封箱 (Autoboxing)
        System.out.println("整數: " + m.getobj());

        // 2. 使用 Double 實例化
        MyData<Double> d = new MyData<>();
        d.setobj(10.0);
        System.out.println("浮點數: " + d.getobj());

        // 3. 使用 String 實例化
        MyData<String> str = new MyData<>();
        str.setobj("王者歸來");
        System.out.println("字串: " + str.getobj());
    }

    // 泛型類別定義: T 代表 Type，是一個佔位符
    static class MyData<T> {
        private T obj;

        // 設定泛型資料
        void setobj(T obj) {
            this.obj = obj;
        }

        // 回傳泛型資料 (回傳型別也是 T)
        public T getobj() {
            return this.obj;
        }
    }
}
