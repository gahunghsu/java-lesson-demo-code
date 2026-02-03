package com.example.lesson.sandbox.ch13;

public class S27_ValidatePassword {
	public static void main(String[] args) {
		String password1 = "Password123";
	    String password2 = "pass";
	    String password3 = "PASSWORD";
	    String password4 = "Pass123";

	    System.out.println(password1 + " 合法嗎？ " + validatePassword(password1)); // true
	    System.out.println(password2 + " 合法嗎？ " + validatePassword(password2)); // false
	    System.out.println(password3 + " 合法嗎？ " + validatePassword(password3)); // false
	    System.out.println(password4 + " 合法嗎？ " + validatePassword(password4)); // true
	}
	public static boolean validatePassword(String pwd) {
	    // 1. 基本長度檢查
	    if (pwd == null || pwd.length() < 8) return false;

	    // 2. 分項驗證：使用 matches() 配合 .* (代表前後可包含任意字元)
	    boolean hasUpper = pwd.matches(".*[A-Z].*");
	    boolean hasLower = pwd.matches(".*[a-z].*");
	    boolean hasDigit = pwd.matches(".*\\d.*");

	    return hasUpper && hasLower && hasDigit;
	}
}
