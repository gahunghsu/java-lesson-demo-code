package com.example.lesson.sandbox.ch14;

public class S06_AccessModifiers {
	/**
	 * 1. 教學目標 展示 private 導致子類別無法繼承屬性的問題，並引出 protected 作為解決方案。
	 *
	 * 3. 講師備課指引 - 錯誤演示 : 先口頭說明或快速打出若 name 是 private，子類別直接存取會紅字報錯 (The field
	 * Animal.name is not visible)。 - 解決方案 : 切換到 protected 關鍵字讓變數變成「家族財產」，子類別即可直接使用。
	 */
	public static void main(String[] args) {
		Dog dog = new Dog("Haly");
		dog.barking(); // 成功印出: Haly 正在叫
	}

	static class Animal {
		// 關鍵修正: 將 private 改為 protected
		// private String name; // Private: 子類別看不到
		public String name;
		Animal(String name) {
			this.name = name;
		}
	}

	static class Dog extends Animal {
		Dog(String name) {
			super(name);
		}

		public void barking() {
			// 因為是 protected，子類別可以直接存取 this.name
			System.out.println(name + " 正在叫");
		}
	}
}
