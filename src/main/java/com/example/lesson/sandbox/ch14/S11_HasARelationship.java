package com.example.lesson.sandbox.ch14;

public class S11_HasARelationship {
    /**
     * 1. 教學目標
     * 展示聚合關係 (Aggregation)，即類別中的成員變數是另一個類別的物件。
     *
     * 3. 講師備課指引
     * - 對比繼承 : Employee 不是 HomeTown (IS-A 不成立)，但 Employee 有 (HAS-A) HomeTown。
     * - 操作重點 : 展示 main 方法中，物件是如何被「組裝」進另一個物件的。
     */
    public static void main(String[] args) {
        // 1. 先建立獨立的 HomeTown 物件
        HomeTown hometown = new HomeTown("徐州", "江蘇", "中國");

        // 2. 再將其傳入 Employee
        Employee em = new Employee(10, "周佳", hometown);

        em.printInfo();
    }

    static class HomeTown {
        protected String city, state, country;
        HomeTown(String city, String state, String country) {
            this.city = city;
            this.state = state;
            this.country = country;
        }
    }

    static class Employee {
        int id;
        String name;
        HomeTown hometown; // HAS-A: 員工「擁有」一個家鄉

        Employee(int id, String name, HomeTown hometown) {
            this.id = id;
            this.name = name;
            this.hometown = hometown;
        }

        public void printInfo() {
            System.out.println("員工姓名:" + name);
            // 透過 hometown 物件存取其屬性
            System.out.println("城市:" + hometown.city);
        }
    }
}
