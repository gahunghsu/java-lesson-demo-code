package com.example.lesson.sandbox.ch24;

import java.util.ArrayList;
import java.util.Iterator;  
import java.util.LinkedList;
import java.util.ListIterator;

public class S10_Q3Q4 {
	public static void main(String[] args) {
		ArrayList<String> strList = new ArrayList<>();
		
		strList.add("A");
		strList.add("B");
		strList.add("C");
		
		System.out.println("Where is B? " + strList.indexOf("B"));
		
		LinkedList<String> linkedList = new LinkedList<>();
		
		linkedList.add("A"); linkedList.add("B");
		linkedList.add("C"); linkedList.add("D");
		linkedList.add("E"); linkedList.add("F");
		linkedList.add("G"); linkedList.add("H");
		
		// Remove first and last elements
		linkedList.removeFirst();
		linkedList.removeLast();
		
		// Iterate through the linked list
		ListIterator<String> listIterator = linkedList.listIterator();
		while (listIterator.hasNext()) {
			String item = listIterator.next();
			if (item.equals("D")) {
				listIterator.remove(); // Remove element D
				continue;
			}else if(item.equals("F")) {
				listIterator.set("Z"); // Replace F with Z
				continue;
			}
			System.out.println("Item: " + item);
		}
		
		System.out.println("Is linkedList contains D: " + linkedList.contains("D"));
		
		System.out.println("Where is Z: " + linkedList.indexOf("Z"));
	}

}
