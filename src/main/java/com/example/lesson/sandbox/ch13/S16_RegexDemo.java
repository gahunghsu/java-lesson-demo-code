package com.example.lesson.sandbox.ch13;

public class S16_RegexDemo {
	public static void main(String[] args) {

		// --- Q3 解析 ---
		// 定義 Regex：[A-Z] 代表 A 到 Z 的大寫字母
		String q3Regex = "[A-Z]";
		String idPrefix = "A";

		boolean isMatchQ3 = idPrefix.matches(q3Regex);
		System.out.println("Q3 結果 (輸入 'A'): " + isMatchQ3); // 輸出: true
		System.out.println("Q3 結果 (輸入 'a'): " + "a".matches(q3Regex)); // 輸出: false

		// --- Q4 解析 ---
		// p = "[^abc]" 代表「不包含 a, b, c 的任何單一字元」
		String p = "[^abc]";
		String target = "d";

		// matches() 會檢查「整個字串」是否符合模式
		boolean isMatchQ4 = target.matches(p);

		System.out.println("Q4 結果: " + isMatchQ4); // 輸出: true
	}
}
