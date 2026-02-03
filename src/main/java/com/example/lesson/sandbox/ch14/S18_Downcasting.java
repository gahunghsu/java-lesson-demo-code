package com.example.lesson.sandbox.ch14;

import com.example.lesson.sandbox.ch14.S17_Polymorphism.Animal;
import com.example.lesson.sandbox.ch14.S17_Polymorphism.Bird;
import com.example.lesson.sandbox.ch14.S17_Polymorphism.Dog;

public class S18_Downcasting {
	/**
	 * 1. 教學目標 說明向上轉型後會失去子類別特有功能，若要使用需轉型，但需防範轉型失敗。
	 *
	 * 3. 講師備課指引 - 情境 : 告訴學生「不是所有動物都是狗」。如果 animal 實際上是 Cat，強制轉成 Dog 就會發生
	 * ClassCastException。 - 守門員 : 強調 instanceof 就像是警衛，確認身分後才放行。
	 */
	public static void main(String[] args) {
		Animal animal = new Bird(); // Upcasting
		animal.walk();
//        animal.barking(); // 編譯錯誤: Animal 看不到 barking

		// 危險示範 (若 animal 其實是 Cat 會當機)
		// Dog dog = (Dog) animal;

		// 正確示範: 先檢查，再轉型
		if (animal instanceof Dog) {
			Dog dog = (Dog) animal; // Downcasting
			System.out.println("轉型成功，呼叫狗的方法: ");
			dog.barking();
		}

		if (animal instanceof Dog dog) {
			System.out.println("轉型成功，呼叫狗的方法: ");
			dog.barking();
		}

		if (animal instanceof Bird bird) {
			System.out.println("轉型成功，呼叫鳥的方法: ");
			bird.fly();
		}

		Animal[] zoo = new Animal[3];
		zoo[0] = new Dog();
		zoo[1] = new Bird();
		zoo[2] = new Cat();

		// 2. 多形呼叫: 同一行程式碼，執行當下依據物件本體決定行為
		System.out.println("=== 動物園開門 ===");
		for (Animal a : zoo) {
			a.walk();
		}
	}

	static class Animal {
		public void walk() {
			System.out.println("Animal walking");
		}
	}

	static class Dog extends Animal {
		public void walk() {
			System.out.println("Dog walking");
		}

		public void barking() {
			System.out.println("Dog barking");
		} // 狗獨有
	}

	static class Cat extends Animal {
		public void walk() {
			System.out.println("Cat walking");
		}

		public void maiing() {
			System.out.println("Cat miao");
		} // 貓獨有
	}

	static class Bird extends Animal {
		public void walk() {
			System.out.println("Bird walking");
		}

		public void fly() {
			System.out.println("Bird fly");
		} // 鳥獨有
	}
}
