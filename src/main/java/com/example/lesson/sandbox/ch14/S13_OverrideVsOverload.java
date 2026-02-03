package com.example.lesson.sandbox.ch14;

public class S13_OverrideVsOverload {
	/**
	 * 1. 教學目標 在同一個子類別中，同時展示「覆寫父類別方法」與「定義新的多載方法」，釐清兩者差異。
	 *
	 * 3. 講師備課指引 - 關鍵差異 : 請學生觀察 c.moving() 與 c.moving("...")。 - Override :
	 * 是「取代」父類別的行為。 - Overload : 是「增加」了新的使用方式 (參數不同)。
	 */
	public static void main(String[] args) {
		Cat c = new Cat();
		c.moving(); // 呼叫繼承/覆寫的方法 (若 Cat 沒覆寫則用 Animal 的)
		c.moving("貓可以走路和跳和抓"); // 呼叫多載的方法
		c.moving(50); // 呼叫另一個多載的方法
	}

	static class Animal {
		public void moving() {
			System.out.println("動物可以活動");
		}
	}

	static class Cat extends Animal {
		// 1. Overriding (覆寫): 參數、名稱皆相同
		// 雖然此範例沒寫 @Override，但行為上是覆寫 (註: 建議補上 @Override)
		// 注意: 原檔 ch14_26.java 似乎沒有寫出覆寫方法，而是直接多載。
		// 為了演示，我們通常會加上覆寫版本，或者說明父類別的方法存在。

		@Override
		public void moving() {
			System.out.println("貓可以走路和跳");
		}

		// 2. Overloading (多載): 名稱相同，但參數不同 (String msg)
		public void moving(String msg) {
			System.out.println(msg);
		}
		
		public void moving(int high) {
			String msg = "貓可以跳高 " + high + " 公分";
			System.out.println(msg);
		}
	}
}
