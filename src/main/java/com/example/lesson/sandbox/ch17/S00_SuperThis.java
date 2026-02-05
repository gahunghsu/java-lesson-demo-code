package com.example.lesson.sandbox.ch17;

public class S00_SuperThis {

	public static void main(String[] args) {
		Son son = new Son();
		son.test();
	}
}

class Father {
    String name = "老爸";
    
    Father() {
		System.out.println("父類別建構子被執行");
	}
    
    Father(String name) {
		this.name = name;
	}

    void hobby() {
        System.out.println("老爸喜歡：釣魚");
    }
}

class Son extends Father {
    String name = "兒子"; // 這裡與父類別變數名稱衝突
    
    Son() {
    	super();
    	System.out.println("子類別建構子被執行");
    }
    
    Son(String name) {
		super(name);
	}

    @Override
    void hobby() {
        System.out.println("兒子喜歡：打電動");
    }

    public void test() {
        // 1. 區分變數
        System.out.println("我是：" + this.name);   // 輸出：兒子
        System.out.println("我是：" + name);   // 輸出：兒子
        System.out.println("我爸是：" + super.name); // 輸出：老爸

        // 2. 區分方法
        this.hobby();  // 執行 Son 的 hobby
        super.hobby(); // 執行 Father 的 hobby
    }
}
