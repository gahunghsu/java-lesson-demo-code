package com.example.lesson.sandbox.ch24;

import java.util.ArrayList;
import java.util.List;

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
	
	public static void main(String[] args) {
	    // 創建 Box 的實例，指定泛型為 String
	    Box<String> stringBox = new S04_Q3().new Box<>();
	    stringBox.setItem("Hello, Generics!");
	    System.out.println("String Box contains: " + stringBox.getItem());

	    // 創建 Box 的實例，指定泛型為 Integer
	    Box<Integer> integerBox = new S04_Q3().new Box<>();
	    integerBox.setItem(123);
	    System.out.println("Integer Box contains: " + integerBox.getItem());
	    
	    Box<Boolean> booleanBox = new S04_Q3().new Box<>();
	    booleanBox.setItem(true);
	    System.out.println("Boolean Box contains: " + booleanBox.getItem());
	    
		ArrayList<String> stringList = new ArrayList<>();
	    stringList.add("Java");
	    stringList.add("Python");
	    System.out.println("ArrayList first element: " + stringList.get(0));
	    
	    System.out.println("ArrayList contains Angular?  " + stringList.contains("Angular"));
	    
	    System.out.println("ArrayList size: " + stringList.size());
	}
}
