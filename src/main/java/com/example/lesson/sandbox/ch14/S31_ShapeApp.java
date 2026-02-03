package com.example.lesson.sandbox.ch14;

public class S31_ShapeApp {
	public static void main(String[] args) {
		// 4. 使用 Shape[] 存放不同圖形
		Shape[] shapes = { new Circle(5), new Rectangle(10, 2), new Circle(2) };

		double totalArea = 0;
		for (Shape s : shapes) {
			totalArea += s.getArea(); // 多型：自動呼叫正確的實作
			System.out.printf("總面積為: %.2f%n", totalArea);
		}

//		System.out.printf("總面積為: %.2f", totalArea);
	}
}

//1. 定義父類別
class Shape {
	double getArea() {		
		// 預設實作 (可選)
		return 0;
	}
}

//2. 實作 Circle
class Circle extends Shape {
	private double r;

	public Circle(double r) {
		this.r = r;
	}

	@Override
	double getArea() {
		return Math.PI * r * r;
	}
}

//2. 實作 Rectangle
class Rectangle extends Shape {
	private double width, height;

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	double getArea() {
		return width * height;
	}
}
