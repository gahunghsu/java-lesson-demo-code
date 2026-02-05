package com.example.lesson.sandbox.ch17;

public class S14_Carrier {
	
	public static void main(String[] args) {
		Seaplane seaplane = new Seaplane();
		seaplane.swim();
		seaplane.fly();
		
		Submarine submarine = new Submarine();
		submarine.swim();
		submarine.dive();
	}

	interface Swimmer {
	    void swim();
	}
	
	interface Flyer {
	    void fly();
	}
	
	interface Dive{
	    void dive();
	}
	
	static class Seaplane implements Swimmer, Flyer {
	    @Override
	    public void swim() {
	        System.out.println("Seaplane is swimming.");
	    }
	
	    @Override
	    public void fly() {
	        System.out.println("Seaplane is flying.");
	    }
	}
	
	static class Boat implements Swimmer {
	    @Override
	    public void swim() {
	        System.out.println("Boat is swimming.");
	    }
	}
	
	static class Submarine extends Boat implements Dive {
		@Override
	    public void swim() {
	        System.out.println("Submarine is swimming.");
	    }
		
		@Override
	    public void dive() {
	        System.out.println("Submarine is diving.");
	    }
	}
	
	
}
