package com.example.lesson.sandbox.ch14;

public class Cat extends Mammal {
	
	public Cat() {
		// 講師強調: 父類別執行完，才輪到子類別
		this.food = "Fish";
		System.out.println("執行 Cat 建構方法... ");
	}
	
	public void barking() {
        // Cat 類別自有的方法 barking
        System.out.println("正在叫");
    }
}
