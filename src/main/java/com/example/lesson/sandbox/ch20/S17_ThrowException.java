package com.example.lesson.sandbox.ch20;

public class S17_ThrowException {
    /**
     * 1. 教學目標
     * 展示 throw 關鍵字的用法，說明我們可以根據業務邏輯 (Business Logic) 主動產生異常，而不僅僅是被動等待系統報錯。
     *
     * 3. 講師備課指引
     * - 觀察點 : 當迴圈跑到 "123456789" (長度 9) 時，程式會拋出異常並停止，後面的 "12345" 就不會被檢查到了。這展示了 throw 具有中斷程式流程的能力。
     */
    public static void main(String[] args) {
        String[] pwd = { "123456", "123456789", "12345" }; // 第二個會失敗

        for (int i = 0; i < pwd.length; i++) {
            // 這裡沒有 try-catch，所以一旦拋出異常，程式就會中止
            pwdCheck(pwd[i]);
        }
    }

    public static void pwdCheck(String pwdStr) {
        // 業務規則: 密碼長度必須在 5-8 之間
        if (pwdStr.length() >= 5 && pwdStr.length() <= 8) {
            System.out.println("密碼檢查通過: " + pwdStr);
        } else {
            System.out.println("密碼檢查失敗: " + pwdStr);
            // 違規! 主動拋出異常
            throw new StringIndexOutOfBoundsException("密碼長度不符規定 (需 5-8 字元)");
        }
    }
}
