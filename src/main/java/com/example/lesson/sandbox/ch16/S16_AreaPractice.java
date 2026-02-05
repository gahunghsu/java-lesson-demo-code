package com.example.lesson.sandbox.ch16;

public class S16_AreaPractice {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape circle = new Circle(5);
		Shape rectangle = new Rectangle(4, 6);
		Shape cylinder = new Cylinder(3, 7);
		
		System.out.println("Circle Area: " + circle.area());
		circle.draw();
		
		System.out.println("Rectangle Area: " + rectangle.area());
		rectangle.draw();
		
		System.out.println("Cylinder Area: " + cylinder.area());
		cylinder.draw();

	}
	
	abstract static class Shape {
	    abstract double area();
	    abstract void draw();
	}
	
	static class Circle extends Shape {
	    double radius;
	    
	    Circle(double radius) {
	        this.radius = radius;
	    }
	    
	    double area() {
	        return Math.PI * radius * radius;
	    }
	    
	    void draw() {
	        System.out.println("Drawing a circle with radius: " + radius);
	    }
	}
	
	static class Rectangle extends Shape {
	    double width;
	    double height;
	    
	    Rectangle(double width, double height) {
	        this.width = width;
	        this.height = height;
	    }
	    
	    double area() {
	        return width * height;
	    }
	    
	    void draw() {
	        System.out.println("Drawing a rectangle with width: " + width + " and height: " + height);
	    }
	}
	
	static class Cylinder extends Shape {
	    double radius;
	    double height;
	    
	    Cylinder(double radius, double height) {
	        this.radius = radius;
	        this.height = height;
	    }
	    
	    double area() {
	        return 2 * Math.PI * radius * (radius + height);
	    }
	    
	    void draw() {
	        System.out.println("Drawing a cylinder with radius: " + radius + " and height: " + height);
	    }
	}

}
