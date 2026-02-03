package com.example.lesson.sandbox.ch14;

public class HR {
	public static void main(String[] args) {
		// 利用 Employee[] 管理所有員工
		Employee[] employees = { new Employee("張小明", 35000), new Manager("王大為", 60000, "研發部"),
				new Employee("李美華", 38000), new Manager("陳處長", 80000, "業務部") };

		System.out.println("=== 所有員工資訊 ===");
		for (Employee emp : employees) {
			System.out.println(emp.getDetails());
		}

		System.out.println("\n=== 找出誰是經理，並印出他的部門 ===");
		// 4. 找出誰是經理
		for (Employee emp : employees) {
			if (emp instanceof Manager) { // 檢查是否為 Manager 實例
				Manager mgr = (Manager) emp; // 強制轉型 (Downcasting)
				System.out.println(mgr.name + " 是經理，所屬部門為: " + mgr.getDept());
			}
		}
	}
}
