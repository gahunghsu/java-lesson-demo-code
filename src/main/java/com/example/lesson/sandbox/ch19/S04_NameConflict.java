package com.example.lesson.sandbox.ch19;

import java.util.*;
import java.sql.*;

public class S04_NameConflict {
    /**
     * 1. 教學目標
     * 展示當同時匯入 java.util.* 與 java.sql.* 時，因為兩個套件都有 Date 類別，會導致編譯器混淆 (Ambiguous)。並展示使用「完整名稱」來解決此問題。
     *
     * 3. 講師備課指引
     * - 錯誤重現 : 務必在課堂上讓學生看到 "Ambiguous" 這個關鍵字，這是開發中極常見的錯誤。
     * - 解決策略 : 解釋這是為了「精確性」。當名字一樣時，我們必須連名帶姓 (套件名 + 類別名) 呼叫它。
     */
    public static void main(String[] args) {
        // === 步驟 1: 錯誤示範 (ch19_4) ===
        // 講師操作: 取消註解下列這行，展示編譯錯誤
        // Date date = new Date();
        // 錯誤訊息: reference to Date is ambiguous (模糊不清的參照)

        // === 步驟 2: 正確示範 (ch19_5) ===
        // 解決方案: 使用完整名稱 (Fully Qualified Name) 明確指定
        java.util.Date utilDate = new java.util.Date();
        System.out.println("Util Date: " + utilDate);

        // 若要用 SQL date，也必須寫完整
        // java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
    }
}
