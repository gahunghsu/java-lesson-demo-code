package com.example.lesson.sandbox.ch18;

import java.util.ArrayList;

public class S02_PrimitiveVsWrapper {
    /**
     * 1. 教學目標
     * 展示基本資料型態 (Primitive Type) 無法直接用於泛型集合 (Generics Collection) 的限制，進而引出包裝類別的必要性。
     *
     * 3. 講師備課指引
     * - 報錯原因 : 解釋 Java 的泛型 (Generics) 在編譯時期會進行型別抹除 (Type Erasure)，轉為 Object，而 int 不是 Object，所以無法放入。
     * - 解決方案 : Integer 是類別，也是 Object 的子類別，完全符合集合的要求。
     */
    public static void main(String[] args) {
        // === 錯誤示範 ===
        // 講師操作: 取消註解下列這行，展示編譯錯誤
        // ArrayList<int> list = new ArrayList<>();
        // 錯誤訊息: Type argument cannot be of primitive type

        // === 正確示範 ===
        // 必須使用包裝類別 Integer
        ArrayList<Integer> list = new ArrayList<>();

        // 自動封箱 (Autoboxing): 可以直接 add 基本型態 100
        list.add(100);
        list.add(200);

        System.out.println("集合內容: " + list);
    }
}
