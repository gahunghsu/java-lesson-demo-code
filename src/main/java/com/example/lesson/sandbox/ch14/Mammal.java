package com.example.lesson.sandbox.ch14;

public class Mammal extends Animal {
	protected String food;
	Mammal() {
		// 講師強調: 父類別建構子先被執行
		System.out.println("執行 Mammal 建構方法... ");
	}

}
