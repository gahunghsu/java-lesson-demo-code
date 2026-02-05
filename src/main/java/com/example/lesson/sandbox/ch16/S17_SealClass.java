package com.example.lesson.sandbox.ch16;

public class S17_SealClass {

	public static void main(String[] args) {
		Vehicle myCar = new Car();
	    Vehicle myBike = new Bike();
	    
	    myCar.drive();  // 輸出: Driving a car
	    myBike.drive(); // 輸出: Riding a bike
	}
	
	abstract static sealed class Vehicle permits Car, Bike {
	    void drive() {
	        System.out.println("Driving a vehicle");
	    }
	}
	
	static final class Car extends Vehicle {
	    @Override
	    void drive() {
	        System.out.println("Driving a car");
	    }
	}
	
	static final class Bike extends Vehicle {
	    @Override
	    void drive() {
	        System.out.println("Riding a bike");
	    }
	}
	
//	static class Truck extends Vehicle {
//	    @Override
//	    void drive() {
//	        System.out.println("Driving a truck");
//	    }
//	}
}
