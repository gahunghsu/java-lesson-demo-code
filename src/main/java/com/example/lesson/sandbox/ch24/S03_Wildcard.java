package com.example.lesson.sandbox.ch24;

import java.util.*;

public class S03_Wildcard {
    /**
     * 1. 教學目標
     * 展示泛型上界 (? extends T) 的應用。證明方法參數一旦設為 ? extends Shapes，就能同時接受 ArrayList<Square> 與 ArrayList<Circle>，達成多型操作。
     *
     * 3. 講師備課指引
     * - 錯誤嘗試 : 講師可試著把 Line 33 的 ? extends 拿掉，改成 ArrayList<Shapes>。然後編譯看，會發現 demoShapes(alist1) 報錯。因為 ArrayList<Square> 不是 ArrayList<Shapes> 的子類別 (泛型不具備繼承性)，必須用 extends 才能解決。
     */
    public static void main(String[] args) {
        // 1. 建立正方形清單
        ArrayList<Square> alist1 = new ArrayList<>();
        alist1.add(new Square());
        alist1.add(new Square());

        // 2. 建立圓形清單
        ArrayList<Circle> alist2 = new ArrayList<>();
        alist2.add(new Circle());

        // 3. 呼叫同一個方法處理不同型別的清單
        demoShapes(alist1);
        demoShapes(alist2);
    }

    // 關鍵方法: 接受 Shapes 或其任何子類別的 ArrayList
    // ? extends Shapes 是關鍵語法
    public static void demoShapes(ArrayList<? extends Shapes> lists) {
        for (Shapes list : lists) {
            list.demo(); // 多型呼叫
        }
//        lists.add(new Circle()); // ❌ 編譯錯誤 (Compile Error)
//        lists.add(new Object()); // ❌ 編譯錯誤
//        lists.add(null); // ✅ 唯一允許加入的是 null
        
    }

    // 抽象父類別
    abstract static class Shapes {
        abstract void demo();
    }

    // 子類別 1
    static class Square extends Shapes {
        void demo() {
            System.out.println("我是正方形");
        }
    }

    // 子類別 2
    static class Circle extends Shapes {
        void demo() {
            System.out.println("我是圓形");
        }
    }
}
