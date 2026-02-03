package com.example.lesson.sandbox.ch25;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class S11_StreamAPI {
	public static void main(String[] args) {
        // 1. 資料來源
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 3, 4, 6);

        // 2. Stream 流水線操作
        List<Integer> result = numbers.stream()  // 建立 Stream
            .filter(n -> n % 2 == 0)             // 中間操作：篩選偶數 (2, 8, 4, 6)
            .map(n -> n * n)                     // 中間操作：算出平方 (4, 64, 16, 36)
            .sorted()                            // 中間操作：排序 (4, 16, 36, 64)
            .collect(Collectors.toList());       // 終端操作：收集結果

        // 3. 輸出結果
        System.out.println(result); // 輸出: [4, 16, 36, 64]
        
        // 4. Reduce 範例：計算總和
        int sum = result.stream()
            .reduce(0, (a, b) -> a + b); // 0 是初始值，(a, b) -> a + b 是累加邏輯
            
        System.out.println("總和: " + sum); // 輸出: 120
    }
}
