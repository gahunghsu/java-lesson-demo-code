package com.example.lesson.sandbox.ch14;

interface I {
    void run();
}

class C implements I {
    public void run() {
        System.out.println("C is running");
    }
}

class D extends C {
    // D 可以選擇不覆寫，直接用 C 的
    // 或者覆寫它：
    @Override
    public void run() {
        System.out.println("D is running");
    }
}

public class S29_TestQ3 {
	public static void main(String[] args) {
        // 雖然 D 本身沒寫 run，但它繼承了 C 的能力
        // 或是它自己覆寫了能力
        new D().run(); 
    }
}
