package com.example.lesson.sandbox.ch13;

public class S02_CheckPhoneLogic {
    /**
     * 1. 教學目標
     * 讓學生感受到「沒有 Regex」時，驗證字串格式是多麼痛苦的事。強調程式碼冗長、邏輯破碎且難以維護 (The Hard Way)。
     *
     * 3. 講師講解重點 (Talking Points)
     * - 引導觀察 : 請學生看 taiwanPhone 方法的長度 (約 20-30 行)。
     * - 提問 : 如果今天老闆說格式改成 (09xx) xxx xxx，你們要改幾行程式碼? (答案: 幾乎要重寫)。
     * - 結論 : 這就是「Imperative Style」 (命令式) 的缺點，我們在告訴電腦「如何做 (How)」，而不是「要什麼 (What)」。
     */
    public static void main(String[] args) {
        System.out.println("I love Java : " + taiwanPhone("I love Java"));
        System.out.println("0952-909-090 : " + taiwanPhone("0952-909-090")); // true
        System.out.println("1111-1111111 : " + taiwanPhone("1111-1111111")); // 格式不符 (缺中間 dash)
    }

    // 傳統邏輯: 土法煉鋼驗證手機號碼 (09xx-xxx-xxx)
    public static boolean taiwanPhone(String str) {
        // 1. 先檢查總長度 (Rigid check)
        if (str.length() != 12)
            return false;

        // 2. 檢查前 4 碼是否為數字 (09xx)
        for (int i = 0; i <= 3; i++) {
            if (Character.isDigit(str.charAt(i)) == false)
                return false;
        }

        // 3. 檢查第 5 碼分隔符號
        if (str.charAt(4) != '-')
            return false;

        // 4. 檢查中間 3 碼數字
        for (int i = 5; i <= 7; i++) {
            if (Character.isDigit(str.charAt(i)) == false)
                return false;
        }

        // 5. 檢查第 9 碼分隔符號
        if (str.charAt(8) != '-')
            return false;

        // 6. 檢查最後 3 碼數字
        for (int i = 9; i <= 11; i++) {
            if (Character.isDigit(str.charAt(i)) == false)
                return false;
        }

        return true; // 過五關斬六將才回傳 true
    }
}
