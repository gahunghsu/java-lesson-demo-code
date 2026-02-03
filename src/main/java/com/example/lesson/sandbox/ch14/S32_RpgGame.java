package com.example.lesson.sandbox.ch14;

import java.util.ArrayList;
import java.util.List;

// 1. 定義 Role 類別 (可以是 abstract 或普通類別)
class Role {
	protected String name;

	public Role(String name) {
		this.name = name;
	}

	// 攻擊方法，由各職業實作
	public void attack() {
		System.out.println(name + " 發動一般攻擊！ 🗡️");
	}
}

// 2. 實作 Magician
class Magician extends Role {
	public Magician(String name) {
		super(name);
	}

	@Override
	public void attack() {
		System.out.println(name + " 施放火球術！ 🔥");
	}
}

// 2. 實作 Warrior
class Warrior extends Role {
	public Warrior(String name) {
		super(name);
	}

	@Override
	public void attack() {
		System.out.println(name + " 使用強力斬擊！ ⚔️");
	}
}

// 3. 設計 Team 類別觸發 allAttack()
class Team {
	private List<Role> members = new ArrayList<>();

	public void add(Role role) {
		members.add(role);
	}

	public void allAttack() {
		System.out.println("--- 團隊發動總攻擊！ ---");
		for (Role r : members) {
			r.attack();
		}
	}
}

public class S32_RpgGame {
	public static void main(String[] args) {
		Team myTeam = new Team();

		// 加入常規職業
		myTeam.add(new Magician("甘道夫"));
		myTeam.add(new Warrior("亞拉岡"));

		// Challenge: 使用「匿名內部類別」加入一個臨時的 Archer
		myTeam.add(new Role("匿名弓箭手") {
			@Override
			public void attack() {
				System.out.println(name + " 射出精準箭矢！ 🏹 (Shoot Arrow!)");
			}
		});

		// 觸發全體攻擊
		myTeam.allAttack();
	}
}
