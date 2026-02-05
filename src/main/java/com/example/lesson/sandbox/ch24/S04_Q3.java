package com.example.lesson.sandbox.ch24;

public class S04_Q3 {
	class Box<T> {
	    // 定義一個 private 的泛型屬性 item
	    private T item;

	    // Getter 方法：回傳類型為 T 的物件
	    public T getItem() {
	        return item;
	    }

	    // Setter 方法：傳入類型為 T 的參數並賦值
	    public void setItem(T item) {
	        this.item = item;
	    }
	}
}
