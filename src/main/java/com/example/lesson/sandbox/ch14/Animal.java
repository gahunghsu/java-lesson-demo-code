package com.example.lesson.sandbox.ch14;

public class Animal {
	
	Animal() {
        // 講師強調: 父類別建構子先被執行
        System.out.println("執行 Animal 建構方法... ");
    }

	public void eat() {
        // Animal 方法 eat
        System.out.println("正在吃食物");
    }

    public void sleep() {
        // Animal 方法 sleep
        System.out.println("正在睡覺");
    }
}
