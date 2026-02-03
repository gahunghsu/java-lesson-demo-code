package com.example.lesson.sandbox.ch14;

//1. Employee 類別 (Parent)
public class Employee {
	protected String name;
	protected double salary;

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getDetails() {
		return "姓名: " + name + ", 薪資: " + salary;
	}
}

