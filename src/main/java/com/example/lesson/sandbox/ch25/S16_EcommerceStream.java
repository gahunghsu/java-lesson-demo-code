package com.example.lesson.sandbox.ch25;

import java.util.*;
import java.util.stream.Collectors;

public class S16_EcommerceStream {
    /**
     * 1. 教學目標
     * 綜合運用 filter、sorted、map 與 forEach 來解決實際業務問題。
     *
     * 3. 講師備課指引
     * - 鏈式編程 : 強調這種寫法的可讀性極高，幾乎像是在寫 SQL 查詢語句 (Select Name From Products Where Category='Electronics' Order By Price Desc)。
     * - Comparator : 解釋 Comparator.comparingInt(...).reversed() 是現代 Java 做排序的標準優雅寫法。
     */
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("iPhone 15", "Electronics", 30000),
                new Product("T-Shirt", "Clothing", 500),
                new Product("TV", "Electronics", 15000),
                new Product("Jeans", "Clothing", 1200),
                new Product("Headphones", "Electronics", 2000)
        );

        System.out.println("=== 篩選 Electronics 類別並依價格由高到低排序 ===");

        List<String> result = products.stream()
                // 1. 篩選類別
                .filter(p -> "Electronics".equals(p.category))
                // 2. 排序 (依價格反序)
                .sorted(Comparator.comparingInt(Product::getPrice).reversed())
                // 3. 轉換 (只取產品名稱)
                .map(Product::getName)
                // 4. 收集結果
                .collect(Collectors.toList());

        result.forEach(System.out::println);

        // 進階: 計算總金額
        int total = products.stream()
                .filter(p -> "Electronics".equals(p.category))
                .mapToInt(Product::getPrice)
                .sum();
        System.out.println("總金額: $" + total);
    }

    static class Product {
        String name;
        String category;
        int price;

        public Product(String name, String category, int price) {
            this.name = name;
            this.category = category;
            this.price = price;
        }

        public String getName() { return name; }
        public String getCategory() { return category; }
        public int getPrice() { return price; }
    }
}
