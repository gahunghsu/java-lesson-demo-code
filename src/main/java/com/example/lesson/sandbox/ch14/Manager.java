package com.example.lesson.sandbox.ch14;

public class Manager extends Employee {
	private String dept; // 增加 dept 屬性

	public Manager(String name, double salary, String dept) {
		super(name, salary); // 呼叫父類別建構子
		this.dept = dept;
	}

	// 覆寫 getDetails() 加入部門資訊
	@Override
	public String getDetails() {
		return super.getDetails() + ", 部門: " + dept;
	}

	// 提供一個方法獲取部門 (用於需求 4)
	public String getDept() {
		return dept;
	}
}
