package com.example.lesson.sandbox.ch24;

import java.util.HashMap;
import java.util.Map.Entry;

public class S20_Q3Q4 {
	
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("TW", "Taiwan");
		map.put("JP", "Japan");
		map.put("US", "America");
		
		System.out.println("TW 對應的值: " + map.get("TW"));
		
		map.put("TW", "台灣");
		
		for(Entry<String, String> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + 
					", Value: " + entry.getValue());
		}
		
		HashMap<Integer, String> map2 = new HashMap<>();
		map2.put(1, "One");
		map2.put(2, "Two");
		map2.put(3, "Three");
	}
		
}
