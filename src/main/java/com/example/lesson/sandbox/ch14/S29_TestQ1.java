package com.example.lesson.sandbox.ch14;

public class S29_TestQ1 {
	public static void main(String[] args) {
        A a = new B(); // 宣告類型是 A，實際物件是 B
        
        // a.i 會抓 A 的 (變數不具多型)
        // a.f() 會執行 B 的 (方法具多型)
        System.out.println(a.i + " " + a.f()); 
    }
}
class A {
    int i = 10;
    String f() {
        return "A";
    }
}

class B extends A {
    int i = 20; // 隱藏 (Hiding) 了父類別的 i
    @Override
    String f() { // 覆寫 (Overriding) 了父類別的 f()
        return "B";
    }
}
