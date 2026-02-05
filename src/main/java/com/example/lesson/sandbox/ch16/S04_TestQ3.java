package com.example.lesson.sandbox.ch16;

public class S04_TestQ3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a = new Dog();
		System.out.println(a instanceof Dog); // true
		System.out.println(a instanceof Animal); // true
	}
}

abstract class Animal{}

class Dog extends Animal{}
