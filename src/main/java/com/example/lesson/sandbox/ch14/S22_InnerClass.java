package com.example.lesson.sandbox.ch14;

public class S22_InnerClass {
    /**
     * 1. 教學目標
     * 展示如何定義與實例化一般的內部類別 (Member Inner Class)，特別是特殊的 .new 語法。
     *
     * 3. 講師備課指引
     * - 語法怪獸 : 學生通常會對 sc.new Motto() 感到陌生。解釋因為 Motto 是依附在 School 實體上的，沒有學校就沒有校訓，所以必須透過 sc 來 new。
     */
    public static void main(String[] args) {
        // 1. 先建立外部物件
        School sc = new School();

        // 2. 透過外部物件實例來建立內部物件
        // 語法重點: Outer.Inner variable = outerObject.new Inner();
        School.Motto inner = sc.new Motto();

        inner.printInfo();
    }

    static class School {
        // 內部類別
        class Motto {
            public void printInfo() {
                System.out.println("勤勞樸實");
            }
        }
    }
}
