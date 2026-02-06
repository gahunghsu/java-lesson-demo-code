package com.example.lesson.sandbox.ch25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class S11_StreamAPI {
	public static void main(String[] args) {
		// 1. 資料來源
		List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 3, 4, 6);

//		List.of(1,2).add(3); // 這行會丟出 UnsupportedOperationException，因為 List.of 回傳的 List 是不可變的
//		List<Integer> unmodifiableList = List.of(1, 2);
//		unmodifiableList.add(3);
//		numbers.add(7); // 這行會丟出 UnsupportedOperationException，因為 Arrays.asList 回傳的 List 是固定大小的

		// 2. Stream 流水線操作
		List<Integer> result = numbers.stream() // 建立 Stream
				.filter(n -> n % 2 == 0) // 中間操作：篩選偶數 (2, 8, 4, 6)
				.map(n -> n * n) // 中間操作：算出平方 (4, 64, 16, 36)
				.sorted() // 中間操作：排序 (4, 16, 36, 64)
				.collect(Collectors.toList()); // 終端操作：收集結果

		// 3. 輸出結果
		System.out.println(result); // 輸出: [4, 16, 36, 64]

		// 4. Reduce 範例：計算總和
		int sum = result.stream().reduce(0, (a, b) -> a + b); // 0 是初始值，(a, b) -> a + b 是累加邏輯
		
		System.out.println("總和 By reduce: " + sum); // 輸出: 120

		OptionalDouble sumBySum = numbers.stream() // 建立 Stream
				.filter(n -> n % 2 == 0) // 中間操作：篩選偶數 (2, 8, 4, 6)
				.mapToInt(n -> n * n) // 中間操作：算出平方 (4, 64, 16, 36)
				.average();// 終端操作：計算總和
		
		System.out.println("總和 By sum: " + sumBySum);
		
//		List<Integer> Q4 = List.of(1, 2).stream().reduce(10, (a, b) -> a + b); // 這行會丟出 UnsupportedOperationException，因為 List.of 回傳的 List
		// 是不可變的
		
		List<Integer> Q5 = new ArrayList<>();
		Q5.add(1); Q5.add(2);
		int sum2 = Q5.stream().reduce(10, (a, b) -> a + b); // 這行會正常執行，因為 Q5 是可變的 ArrayList

//		System.out::println(sum2);
		
		System.out.println(sum2);
		
		List<Integer> nagtiveNumbers = Arrays.asList(-10, 5, -20, 30);

		// 使用方法參考 Math::abs
		List<Integer> absNumbers = nagtiveNumbers.stream().map(Math::abs).sorted().collect(Collectors.toList());

		System.out.println(absNumbers); // 輸出: [10, 5, 20, 30]
	}
}
