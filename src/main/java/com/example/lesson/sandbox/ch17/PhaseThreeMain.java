package com.example.lesson.sandbox.ch17;

//5. 結帳機：負責交易邏輯
class CheckoutMachine {
 
 // --- Overload 方法 A：原價結帳 ---
 // 參數只接受支付工具與金額
 public void process(Payable p, int amount) {
     System.out.println("--- [一般結帳模式] ---");
     System.out.println("偵測到支付工具: " + p.getDisplayInfo());
     
     // 多型呼叫：不管 p 是信用卡還是錢包，這裡都呼叫它的 pay()
     p.pay(amount);
     System.out.println("交易完成 (無折扣)\n");
 }

 // --- Overload 方法 B：折扣結帳 ---
 // 參數多了一個 discountCode (字串)
 // 這就是 Overload：方法名稱一樣 (checkout)，但參數列表不同
 public void process(Payable p, int amount, String discountCode) {
     System.out.println("--- [優惠結帳模式] ---");
     
     // 1. 解析折扣碼 (String 應用)
     // 假設折扣碼格式為 "SALE_50" (折50元) 或 "SALE_100"
     int discount = 0;
     
     int finalAmount = amount;
     
     if (discountCode != null && discountCode.startsWith("SALE_")) {
         // split("_") 會將字串切成 ["SALE", "50"]
         String[] parts = discountCode.split("_");
         if (parts.length == 2) {
             // 將字串 "50" 轉為數字 50
             discount = Integer.parseInt(parts[1]); 
         }
         finalAmount = amount - discount;
     }
     
     if (discountCode != null && discountCode.startsWith("OFF_")) {
         // split("_") 會將字串切成 ["SALE", "50"]
         String[] parts = discountCode.split("_");
         if (parts.length == 2) {
             // 將字串 "50" 轉為數字 50
             discount = amount * Integer.parseInt(parts[1]) / 100; 
         }
         finalAmount = amount - discount;
     }

     // 2. 計算最後金額
     
     if (finalAmount < 0) finalAmount = 0; // 避免負數

     // 3. 執行交易
     System.out.println("使用優惠碼 [" + discountCode + "]，折扣金額：$" + discount);
     System.out.println("偵測到支付工具: " + p.getDisplayInfo());
     p.pay(finalAmount);
     System.out.println("交易完成 (已折扣)\n");
 }
}

//6. 綜合主程式 (Grand Finale)
public class PhaseThreeMain {
 public static void main(String[] args) {
     // ==========================================
     // Step 1: 會員登入 (複習 Phase 1)
     // ==========================================
     System.out.println(">>> 步驟 1: 會員登入驗證");
     InputValidator emailVal = new EmailValidator();
     String inputEmail = "  Customer@Shop.com ";
     
     // 清理並驗證
     String email = emailVal.sanitize(inputEmail);
     if (!emailVal.validate(email)) {
         System.out.println("登入失敗：Email 格式錯誤");
         return; // 結束程式
     }
     System.out.println("歡迎回來, " + email + "!");

     // ==========================================
     // Step 2: 準備支付工具 (複習 Phase 2)
     // ==========================================
     System.out.println("\n>>> 步驟 2: 載入錢包");
     // 使用多型 (Polymorphism) 宣告
     Payable myCard = new CreditCard("9999888877776666");
     Payable myWallet = new DigitalWallet("0912345678");

     // ==========================================
     // Step 3: 進行結帳 (Phase 3 核心)
     // ==========================================
     System.out.println("\n>>> 步驟 3: 開始結帳");
     CheckoutMachine machine = new CheckoutMachine();

     // 情境 A: 買一般商品 (呼叫兩個參數的 checkout)
     // 傳入的是 CreditCard 物件
     machine.process(myCard, 2000); 

     // 情境 B: 買促銷商品 (呼叫三個參數的 checkout)
     // 傳入的是 DigitalWallet 物件，並附帶優惠碼
     // String.split 解析會發生在這裡
     machine.process(myWallet, 500, "SALE_50");
 }
}
