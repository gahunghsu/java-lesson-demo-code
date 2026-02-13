package com.example.lesson.sandbox.ch20;

import java.util.HashMap;
import java.util.Map;

public class S20_StockManager {

	private static Map<String, Integer> inventory = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		inventory.put("手機", 10);
		try {
			new S20_StockManager().sellItem("手機", 5);
			System.out.println("售出手機 5 台");
			new S20_StockManager().sellItem("手機", 6);
		} catch (ItemNotFoundException e) {
			System.out.println("錯誤: " + e.getMessage());
		} catch (OutOfStockException e) {
			System.out.println("錯誤: " + e.getMessage() + "，目前庫存: " + e.getCurrentStock());
		}
		
		try {
			new S20_StockManager().sellItem("平板", 5);
		} catch (ItemNotFoundException e) {
			System.out.println("錯誤: " + e.getMessage());
		} catch (OutOfStockException e) {
			System.out.println("錯誤: " + e.getMessage() + "，目前庫存: " + e.getCurrentStock());
		}
	}

	// 自定義異常
	class ItemNotFoundException extends RuntimeException {
		public ItemNotFoundException(String msg) {
			super(msg);
		}
	}

	class OutOfStockException extends Exception {
		private int currentStock;

		public OutOfStockException(String msg, int stock) {
			super(msg);
			this.currentStock = stock;
		}

		public int getCurrentStock() {
			return currentStock;
		}
	}

	// 業務邏輯
	public void sellItem(String item, int qty) throws OutOfStockException {
		if (!inventory.containsKey(item))
			throw new ItemNotFoundException("商品不存在: " + item);
		int current = inventory.get(item);
		if (current < qty)
			throw new OutOfStockException("庫存不足", current);
		inventory.put(item, current - qty);
	}

}
