package com.example.lesson.sandbox.ch25;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 定義學生類別
class Student {
	private String name;
	private int chinese;
	private int english;
	private int math;

	public Student(String name, int chinese, int english, int math) {
		this.name = name;
		this.chinese = chinese;
		this.english = english;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public int getChinese() {
		return chinese;
	}

	public int getEnglish() {
		return english;
	}

	public int getMath() {
		return math;
	}
}

public class S17_StudentStreamDemo {
	public static void main(String[] args) {
		// 準備資料
		List<Student> students = Arrays.asList(
				new Student("小明", 80, 75, 55), 
				new Student("小華", 90, 85, 95),
				new Student("小美", 70, 40, 50), 
				new Student("大壯", 95, 60, 45));

		// 1. 計算平均分 Map (使用 Function 邏輯)
		// 這裡對應你圖中的 Function (T -> R)，將 Student 物件轉為平均分數
//        Map<String, Double> avgMap = students.stream()
//            .collect(Collectors.toMap(
//                Student::getName,
//                s -> (s.getChinese() + s.getEnglish() + s.getMath()) / 3.0
//            ));

		Map<String, Double> avgMap = students.stream()
				.collect(Collectors.toMap(Student::getName,
						s -> IntStream.of(s.getChinese(), s.getEnglish(), s.getMath()) // 將三科轉為流
								.average() // 計算平均
								.orElse(0.0) // 處理空值的保險
				));
		System.out.println("1. 各生平均分數: " + avgMap);

		// 2. 數學不及格名單 (依國文排序)
		// filter 對應 Predicate (T -> boolean)，判斷是否不及格
		List<String> failedMath = students.stream().filter(s -> s.getMath() < 60)
				.sorted(Comparator.comparingInt(Student::getChinese).reversed())
				.map(Student::getName)
				.collect(Collectors.toList());
		System.out.println("2. 數學不及格名單 (依國文高到低): " + failedMath);

		// 3. 英文總平均
		// mapToInt 將物件轉為數值流，average() 回傳 OptionalDouble
		double engAvg = students.stream()
				.mapToInt(Student::getEnglish)
				.average()
				.orElse(0.0); // 如果沒有學生，預設平均為 0.0
		
		int sum = students.stream()
		.mapToInt(Student::getEnglish)
		.sum();
		
		System.out.printf("3. 班級英文總平均: %.2f\n", engAvg);
		System.out.printf("3. 班級英文總平均: %.2f\n", sum / (double) students.size());
	}
}
