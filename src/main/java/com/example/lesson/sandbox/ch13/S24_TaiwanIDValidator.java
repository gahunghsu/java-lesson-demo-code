package com.example.lesson.sandbox.ch13;

import java.util.regex.Pattern;

public class S24_TaiwanIDValidator {
	// 將 Pattern 宣告為 static final 提升效能
    // 邏輯：排除 A,B,D,E,F,H 後，剩餘的大寫字母 + 性別 [12] + 8位數字
    private static final String ID_REGEX = "[^ABDEFH&&[A-Z]][12]\\d{8}";
//	private static final String ID_REGEX = "[A-Z][12]\\d{8}";
    private static final Pattern ID_PATTERN = Pattern.compile(ID_REGEX);

    public static void main(String[] args) {
        String[] testCases = {"L123456789", "A123456789", "Y200000000", "B123"};

        for (String id : testCases) {
            boolean isValid = isValidNonMetroID(id);
            System.out.printf("身分證字號: %s -> 驗證結果: %s%n", id, isValid ? "通過" : "攔截");
        }
    }

    /**
     * 驗證身分證是否符合格式且排除六都碼
     */
    public static boolean isValidNonMetroID(String id) {
        if (id == null) return false;
        // String.matches() 或 Matcher.matches() 
        return ID_PATTERN.matcher(id).matches();
    }
}
