package com.example.lesson.sandbox.ch24;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class S15_Q3Q4 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();		
		set.add("A"); set.add("B"); set.add("A");
		
		System.out.println("Set 大小: " + set.size());
		
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(5); treeSet.add(1); treeSet.add(3);
		
		for (Integer num : treeSet) {
			System.out.print(num + " ");
		}
		
		System.out.println();
		
		List<Integer> list = new ArrayList<>();
		list.add(10); list.add(20); list.add(30);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(100); list2.add(200); list2.add(300);
		
		LinkedHashSet<Integer> linkedSet = new LinkedHashSet<>();
		linkedSet.addAll(list); linkedSet.addAll(list2);
		for (Integer num : linkedSet) {
			System.out.print(num + " ");
		}
		
		System.out.println();
		
		linkedSet.removeAll(list2);
		for (Integer num : linkedSet) {
			System.out.print(num + " ");
		}
	}
}
