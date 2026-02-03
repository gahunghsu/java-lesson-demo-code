package com.example.lesson.sandbox.ch22;

import java.io.*;

public class S13_CharStreamWrite {
    /**
     * 1. 教學目標
     * 原檔 ch22_8.java 使用了 FileWriter，這是最簡單的寫文字方式。講師可藉此說明 FileWriter 其實就是繼承自 OutputStreamWriter，專門處理文字字碼。
     *
     * 3. 講師備課指引
     * - 亂碼預警 : 若學生在 Windows 記事本打開看到亂碼，解釋這是編碼問題。FileWriter 使用系統預設編碼，若要強制使用 UTF-8，需改用 new OutputStreamWriter(new FileOutputStream(...), "UTF-8")。
     */
    public static void main(String[] args) {
        try {
            // FileWriter 是字元串流，會依據系統預設編碼 (Windows 通常是 Big5 或 UTF-8) 寫入
            FileWriter fw = new FileWriter("S13_Output.txt"); // 建立檔案

            String str = "明志科技大學 MINGCHI University 歡迎你們";

            // // 直接寫入字串，不用像 FileOutputStream 還要轉 byte[]
            fw.write(str);

            fw.close();
            System.out.println("輸出成功!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
