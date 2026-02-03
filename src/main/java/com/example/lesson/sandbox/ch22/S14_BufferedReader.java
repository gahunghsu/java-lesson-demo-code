package com.example.lesson.sandbox.ch22;

import java.io.*;

public class S14_BufferedReader {
    /**
     * 1. 教學目標
     * 展示 BufferedReader 的最強功能 readLine()，這是處理文字檔最常用的方法。
     *
     * 3. 講師備課指引
     * - 重點差異 : 原檔程式碼是用 read() 一個字一個字讀，這在 BufferedReader 上有點大材小用。強烈建議講師展示註解中的 readLine() 写法，這才是 BufferedReader 的靈魂。
     */
    public static void main(String[] args) throws IOException {
        // 為了演示，我們先確保有檔案可以讀 (依賴上一個範例產生的檔案)
        File file = new File("S13_Output.txt");
        if (!file.exists()) {
            System.out.println("找不到檔案 S13_Output.txt，請先執行 S13_CharStreamWrite");
            return;
        }

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        System.out.println("=== 使用 readLine() 逐行讀取 ===");
        
        String line;
        // 迴圈讀取，直到 null (檔案結束)
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        fr.close();
        br.close();
    }
}
