package com.example.lesson.sandbox.ch25;

import java.util.*;

public class S13_StreamReduce {
	/**
	 * 1. 教學目標 展示 Stream API 的標準流水線操作: Filter (過濾) -> Map (轉換) -> Reduce (歸納)。
	 *
	 * 3. 講師備課指引 - 流水線觀念 : 請在白板畫出流水線，數字 1 被過濾掉，數字 2 通過並變身為 4，最後掉進加總的桶子裡。 - mapToInt
	 * : 說明這裡用 mapToInt 可以直接呼叫 sum()，如果是普通 map 則需要用 reduce。
	 */
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		// 目標: 找出偶數 -> 平方 -> 加總
		int result = numbers.stream()
				// 1. Filter: 只保留偶數 (2, 4, 6)
				.filter(n -> n % 2 == 0)
				// 2. Map: 轉為平方 (4, 16, 36)
				.mapToInt(n -> n * n) // 使用 mapToInt 轉為 IntStream 以提升效能
				// 3. Reduce (Sum): 加總 (4+16+36 = 56)
				.sum();

		System.out.println("原始列表: " + numbers);
		System.out.println("偶數平方和: " + result);

		// 計算數字總和
		int sum = numbers.stream().reduce(0, (acc, cur) -> acc + cur);
		System.out.println("總和: " + sum);
	}
}
