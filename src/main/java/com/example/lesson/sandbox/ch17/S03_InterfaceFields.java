package com.example.lesson.sandbox.ch17;

public class S03_InterfaceFields {
    /**
     * 1. 教學目標
     * 現場演示介面成員的「隱含規則」，證明變數預設為 public static final，方法預設為 public abstract，嘗試違反規則會導致編譯錯誤。
     *
     * 3. 講師備課指引
     * - 錯誤展示 : 在 IDE 中直接修改 double PI 為 private double PI，讓學生看到紅色錯誤訊息 "Modifier 'private' not allowed here"。
     * - 靜態存取 : 執行 Main 方法，強調 Shape.PI 的寫法，證明它是 static 的。
     */
    public static void main(String[] args) {
        // 證明 PI 是 static (可直接透過介面名稱呼叫)
        System.out.println("PI is: " + Shape.PI);

        // 證明 PI 是 final (無法修改)
        // Shape.PI = 3.14159; // Uncomment this line to show error
    }

    interface Shape {
        // 隱含規則: 變數預設是 public static final
        // 講師動作: 嘗試把下面這行改成 private double PI = 3.14; (會報錯)
        // 講師動作: 嘗試移除初始化 = 3.14; (會報錯，因為 final 必須給值)
        double PI = 3.14;

        // 隱含規則: 方法預設是 public abstract
        // 講師動作: 嘗試加上 protected void area(); (會報錯，介面方法必須公開)
        void area();
    }
}
