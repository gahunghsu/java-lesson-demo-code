package com.example.lesson.sandbox.ch14;

public class S07_MultiLevelInheritance {
    /**
     * 1. 教學目標
     * 演示多層次繼承 (孫子繼承爺爺)，證明子類別會累積繼承鏈上所有的屬性與方法。
     *
     * 3. 講師備課指引
     * - 結構圖解 : 在白板或螢幕畫出 Cat -> Mammal -> Animal 的層級。
     * - 驗證累積 : 執行 main，強調 cat 物件同時擁有三層樓的能力 (eat, favoriteFood, jumping)。
     */
    public static void main(String[] args) {
        Cat cat = new Cat("lucy", "fish");
        cat.eat();            // 繼承自爺爺 (Animal)
        cat.favoriteFood();   // 繼承自爸爸 (Mammal)
        cat.jumping();        // 自己的方法 (Cat)
    }

    // 爺爺
    static class Animal {
        protected String name;
        Animal(String name) { this.name = name; }
        public void eat() { System.out.println(name + " 正在吃食物"); }
    }

    // 爸爸
    static class Mammal extends Animal {
        protected String favorite_food;
        // 建構子: 負責初始化自己的屬性 + 呼叫父類別初始化
        Mammal(String name, String favorite_food) {
            super(name);
            this.favorite_food = favorite_food;
        }
        public void favoriteFood() {
            System.out.println(name + " 喜歡吃 " + favorite_food);
        }
    }

    // 孫子
    static class Cat extends Mammal {
        Cat(String name, String favorite_food) {
            super(name, favorite_food);
        }
        public void jumping() {
            // Cat 可以存取爺爺的 name
            System.out.println(name + " 正在跳");
        }
    }
}
