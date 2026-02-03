package com.example.lesson.sandbox.ch12;

public class S23_ArrayToBuilderAddition {
    public static void main(String[] args) {
        int[] arr1 = {1, 9};
        int[] arr2 = {9, 9, 9};

        System.out.println("19 + 1 = " + plusOneWithBuilder(arr1));  // 輸出 20
        System.out.println("999 + 1 = " + plusOneWithBuilder(arr2)); // 輸出 1000
    }
    
    public static String plusOneWithBuilder(int[] digits) {
        // 1. 準備一個「結果紀錄本」，用來記下每一位數算出來的結果
        StringBuilder sb = new StringBuilder();

        // 2. 這就是我們要加的那「1」塊錢，我們先把它握在手心（進位）
        int carry = 1; 

        // 3. 【模擬直式加法】從最右邊（個位數）開始，往左邊一格一格計算
        // i 代表現在算到哪一個位數
        for (int i = digits.length - 1; i >= 0; i--) {
            // 把這一位數的數字，加上手心裡的進位
            int sum = digits[i] + carry;
            
            // 如果加起來是 10，這一位只能寫下 0 (sum % 10)
            sb.append(sum % 10); 

            // 如果加起來超過 10，手心裡就要握著「1」留給下一位 (sum / 10)
            // 如果沒超過 10，手心就會變回「0」
            carry = sum / 10;    
        }

        // 4. 【檢查最後一關】如果全部算完，手心還握著「1」（例如 99+1 變 100）
        // 我們要把這最後的 1 補在最前面
        if (carry > 0) {
            sb.append(carry);
        }

        // 5. 【校正順序】因為剛才是從個位數開始寫（倒著寫進紀錄本）
        // 像是 20 會被記成 "02"，所以最後要反轉回來變成 "20"
        return sb.reverse().toString();
    }
}
