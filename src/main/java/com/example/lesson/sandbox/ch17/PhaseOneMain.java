package com.example.lesson.sandbox.ch17;

//1. 抽象類別：定義驗證器的基本規範
abstract class InputValidator {
 
 // 抽象方法：子類別必須自己決定怎麼驗證 (因為 Email 和 密碼 規則不同)
 public abstract boolean validate(String input);

 // 一般方法：共用的清理邏輯 (Template Method 概念)
 // 預設行為：去空白 + 轉小寫 (適合 Email 或一般帳號)
 public String sanitize(String input) {
     if (input == null) return "";
     return input.trim().toLowerCase();
 }
}

//2. Email 驗證器：繼承抽象類別
class EmailValidator extends InputValidator {
 
 // Regex 解釋：
 // ^        : 字串開始
 // [\w-\.]+ : 允許字母、數字、底線、減號、點 (使用者帳號部分)
 // @        : 必須有 @ 符號
 // ([\w-]+\.)+ : 網域部分 (例如 google.)，可以有多層
 // [\w-]{2,4}$ : 結尾必須是 2~4 個字母 (例如 .com, .tw)
 private static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

 @Override
 public boolean validate(String input) {
     if (input == null) return false;
     // String 的 matches 方法直接支援 Regex
     return input.matches(EMAIL_PATTERN); 
 }
}

//3. 密碼 驗證器：繼承抽象類別
class PasswordValidator extends InputValidator {

 // Regex 解釋：
 // ^          : 字串開始
 // (?=.*[0-9]) : Lookahead (預查)，檢查後面是否包含至少一個數字
 // (?=.*[A-Z]) : Lookahead，檢查後面是否包含至少一個大寫字母
 // .{8,}      : 任意字元，長度至少 8 碼
 // $          : 字串結束
 private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z]).{8,}$";

 @Override
 public boolean validate(String input) {
     if (input == null) return false;
     return input.matches(PASSWORD_PATTERN);
 }

 // ★ 關鍵 Override ★
 // 父類別的 sanitize 會轉小寫，但密碼區分大小寫，不能轉小寫！
 // 所以這裡我們要「覆寫」父類別的行為，只做 trim (去空白)
 @Override
 public String sanitize(String input) {
     if (input == null) return "";
     return input.trim(); // 不做 toLowerCase()
 }
}

//4. 主程式：模擬登入流程
public class PhaseOneMain {
 public static void main(String[] args) {
     // 準備測試資料 (包含髒亂的空白)
     String rawEmail = "  User123@Google.COM  "; 
     String rawPassword = "  MySecretPass1  ";    
     String weakPassword = "  password  ";

     // 建立驗證器物件 (多型宣告：宣告為父類別，實體化為子類別)
     InputValidator emailCheck = new EmailValidator();
     InputValidator passCheck = new PasswordValidator();

     System.out.println("=== 開始會員驗證流程 ===\n");

     // --- 測試 Email ---
     System.out.println("1. 處理 Email:");
     System.out.println("   原始輸入: [" + rawEmail + "]");
     
     // 呼叫 sanitize (父類別邏輯：去空白 + 轉小寫)
     String cleanEmail = emailCheck.sanitize(rawEmail); 
     System.out.println("   清理後  : [" + cleanEmail + "]");
     
     // 呼叫 validate (子類別 EmailValidator 邏輯)
     boolean isEmailOk = emailCheck.validate(cleanEmail);
     System.out.println("   驗證結果: " + (isEmailOk ? "通過 ✅" : "失敗 ❌"));

     System.out.println("-------------------------");

     // --- 測試正確密碼 ---
     System.out.println("2. 處理正確密碼:");
     System.out.println("   原始輸入: [" + rawPassword + "]");
     
     // 呼叫 sanitize (子類別 PasswordValidator 覆寫過的邏輯：只去空白，不轉小寫)
     String cleanPass = passCheck.sanitize(rawPassword); 
     System.out.println("   清理後  : [" + cleanPass + "]");
     
     boolean isPassOk = passCheck.validate(cleanPass);
     System.out.println("   驗證結果: " + (isPassOk ? "通過 ✅" : "失敗 ❌"));

     // --- 測試弱密碼 ---
     System.out.println("\n(測試弱密碼: " + weakPassword.trim() + ")");
     System.out.println("   驗證結果: " + (passCheck.validate(passCheck.sanitize(weakPassword)) ? "通過" : "失敗 ❌ (缺少大寫或數字)"));
 }
}
