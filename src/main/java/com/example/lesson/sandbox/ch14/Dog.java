package com.example.lesson.sandbox.ch14;

public class Dog extends Mammal {
	public Dog() {
		// 講師強調: 父類別執行完，才輪到子類別
		this.food = "Meat";
		System.out.println("執行 Dog 建構方法... ");
	}
	
	public void barking() {
        // Dog 類別自有的方法 barking
        System.out.println("正在叫");
    }
}
