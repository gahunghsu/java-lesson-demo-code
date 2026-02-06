package com.example.lesson.sandbox.ch25;

public class S06_Q2Q4 {
	
	interface MathOp {
		int add(int a, int b);
	}

//	MathOp op = new MathOp() {
//		public int add(int a, int b) {
//			return a + b;
//		}
//	};

//	// Lambda 簡化寫法，當方法主體只有一行且直接回傳結果時，可以省略大括號和 return 關鍵字。
//	MathOp op = (a, b) -> a + b; 

//	// 錯誤寫法，當方法主體使用大括號時，必須
	// 1. 使用 return 關鍵字來回傳結果
	// 2. a+b要有;結尾
	// 3. {}外要有;結尾
	MathOp op = (a, b) -> { return a + b; };
	

}
