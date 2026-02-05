package com.example.lesson.sandbox.ch16;

public class S21_PaymentSystem {

	public static void main(String[] args) {
		Payment[] payments = { new CreditCard(100), new wallet(50) };
		for (Payment payment : payments) {
			payment.processPayment();
		}
	}

	abstract static class Payment {
		int amount;
		Payment(int amount) {
			this.amount = amount;
		}

		abstract void processPayment();
	}

	static class CreditCard extends Payment {
		CreditCard(int amount) {
			super(amount);
		}

		@Override
		void processPayment() {
			System.out.println("刷卡支付 $" + this.amount);
		}
	}

	static class wallet extends Payment {		
		wallet(int amount) {
			super(amount);
		}
		
		@Override
		void processPayment() {
			System.out.println("錢包扣款 $" + this.amount);
		}
	}
}
