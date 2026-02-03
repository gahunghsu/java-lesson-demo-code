package com.example.lesson.sandbox.ch12;

public class S23_Palindrome {
	public static void main(String[] args) {
		String text1 = "abccba";
	    String text2 = "hello";

	    System.out.println(text1 + " 是迴文嗎？ " + isPalindrome(text1));
	    System.out.println(text2 + " 是迴文嗎？ " + isPalindrome(text2));
	}
	
	public static boolean isPalindrome(String text) {
	    // 1. 準備一面「魔鏡」 (StringBuilder)
	    // 把原本的文字放進去鏡子前面
	    StringBuilder sb = new StringBuilder(text);

	    // 2. 【施法反轉】讓鏡子裡的影像倒過來
	    // 利用 reverse() 快速得到「反著讀」的結果
	    String reversedText = sb.reverse().toString();

	    // 3. 【比對真相】看看「原本的字」跟「反過來的字」是不是長得一模一樣？
	    // 如果一樣，這就是一個神奇的迴文咒語！
	    return text.equals(reversedText);
	}
}
