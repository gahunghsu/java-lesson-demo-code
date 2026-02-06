package com.example.lesson.sandbox.ch24;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// 1. 定義 Product 類別
class Product {
    private String id;
    private String name;
    private int price;

    public Product(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // 實作 equals：視 ID 相同為同一商品
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    // 實作 hashCode：確保相同的 ID 產生相同的雜湊值
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("Product[ID=%s, Name=%s, Price=%d]", id, name, price);
    }
}

// 2. 實作 Cart 購物車
class Cart {
    // 使用 Map<Product, Integer> 儲存商品與數量
    private Map<Product, Integer> items = new HashMap<>();

    // 3. 實作 addProduct：若已存在則數量+1，否則新增
    public void addProduct(Product p) {
        items.put(p, items.getOrDefault(p, 0) + 1);
        System.out.println("新增商品: " + p.toString());
    }

    // 4. 實作 removeProduct：數量-1，若剩 0 則從 Map 移除
    public void removeProduct(Product p) {
        if (!items.containsKey(p)) {
            System.out.println("購物車內無此商品。");
            return;
        }

        int currentCount = items.get(p);
        if (currentCount > 1) {
            items.put(p, currentCount - 1);
        } else {
            items.remove(p);
        }
        System.out.println("移除商品 (或減量): " + p.toString());
    }

    // 顯示目前購物車狀態
    public void showCart() {
        System.out.println("\n--- 目前購物車內容 ---");
        if (items.isEmpty()) {
            System.out.println("購物車是空的。");
        } else {
            items.forEach((product, count) -> 
                System.out.println(product + " | 數量: " + count));
        }
        System.out.println("--------------------\n");
    }
}

// 測試執行
public class S25_ShoppingCartChallenge {
    public static void main(String[] args) {
        Cart myCart = new Cart();

        Product p1 = new Product("A001", "可樂", 25);
        Product p2 = new Product("A001", "可樂", 25); // ID 相同，視為同商品
        Product p3 = new Product("B002", "大麥克", 80);

        // 測試新增
        myCart.addProduct(p1);
        myCart.addProduct(p2); // 這應該會讓 A001 數量變成 2
        myCart.addProduct(p3);
        myCart.showCart();

        // 測試移除
        myCart.removeProduct(p1); // A001 剩 1
        myCart.showCart();

        myCart.removeProduct(p1); // A001 被移除
        myCart.showCart();
    }
}
