package com.example.lesson.sandbox.ch17;

//1. 介面：定義「支付能力」的合約
//任何想成為支付工具的類別，都必須實作這些方法
interface Payable {
 void pay(int amount);           // 扣款行為
 String getDisplayInfo();        // 取得遮罩後的帳號資訊 (為了資安)
}

//2. 信用卡：實作 Payable
class CreditCard implements Payable {
 private String cardNumber; // 假設格式固定為 16 碼數字

 public CreditCard(String cardNumber) {
     this.cardNumber = cardNumber;
 }

 @Override
 public void pay(int amount) {
     // 模擬刷卡連線
     System.out.println("💳 信用卡刷卡中... 金額：$" + amount);
 }

 @Override
 public String getDisplayInfo() {
     // String 應用：遮罩處理
     // 格式目標：****-****-****-1234
     // substring(12) 代表從 index 12 取到最後 (即最後4碼)
     if (cardNumber != null && cardNumber.length() == 16) {
         String lastFour = cardNumber.substring(12);
         return "****-****-****-" + lastFour;
     }
     return "Invalid Card";
 }
}

//3. 電子錢包：實作 Payable
class DigitalWallet implements Payable {
 private String walletId; // 例如手機號碼 0912345678

 public DigitalWallet(String walletId) {
     this.walletId = walletId;
 }

 @Override
 public void pay(int amount) {
     // 模擬 API 扣款
     System.out.println("📱 電子錢包扣款中... 金額：$" + amount);
 }

 @Override
 public String getDisplayInfo() {
     // String 應用：前後保留，中間隱藏
     // 目標：091***678
     // substring(0, 3) 取前三碼 (index 0, 1, 2)
     // substring(length - 3) 取最後三碼
     if (walletId != null && walletId.length() >= 6) {
         String prefix = walletId.substring(0, 3);
         String suffix = walletId.substring(walletId.length() - 3);
         return prefix + "***" + suffix;
     }
     return walletId;
 }
}

//4. 主程式：模擬結帳準備
public class PhaseTwoMain {
 public static void main(String[] args) {
     // --- 準備資料 ---
     // 這些資料通常是 Phase 1 登入後從資料庫撈出來的
     String userCardNum = "1234567890123456";
     String userPhone = "0912345678";

     // --- 多型宣告 (Polymorphism) ---
     // ★ 關鍵點：我們用 Payable 介面來宣告變數，而不是用具體的類別
     // 這代表 p1 和 p2 對外界來說，都是「可以付錢的東西」
     Payable p1 = new CreditCard(userCardNum);
     Payable p2 = new DigitalWallet(userPhone);

     System.out.println("=== 選擇支付方式 ===");

     // --- 測試信用卡 ---
     System.out.println("方式 1: " + p1.getDisplayInfo());
     p1.pay(1000); // 買了一件衣服

     System.out.println("-------------------");

     // --- 測試電子錢包 ---
     System.out.println("方式 2: " + p2.getDisplayInfo());
     p2.pay(50);   // 買了一杯飲料
 }
}
