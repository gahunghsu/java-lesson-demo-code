package com.example.lesson.sandbox.ch24;

import java.util.*;

public class S08_ListIteratorDemo {
    /**
     * 1. 教學目標
     * 比較 Iterator (只能往後) 與 ListIterator (可前後移動) 的差異。展示 hasNext/next 與 hasPrevious/previous 的對稱用法。
     *
     * 3. 講師備課指引
     * - 游標觀念 : 向學生解釋 ListIterator 就像文書處理軟體的游標。一開始在字首，一直 next 到字尾後，才能開始使用 previous 往回走。如果一開始就 call previous，會因為前面沒東西而發生錯誤或不執行。
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("北京");
        list.add("香港");
        list.add("台北");

        // 建立 ListIterator (游標初始在最前面)
        ListIterator<String> litr = list.listIterator();

        System.out.println("--- 從前面到後面遍歷 (Forward) ---");
        while (litr.hasNext()) {
            System.out.println(litr.next());
        }
        // 此時游標已經在最後面了

        System.out.println("--- 從後面到前面遍歷 (Backward) ---");
        while (litr.hasPrevious()) {
            System.out.println(litr.previous());
        }
    }
}
