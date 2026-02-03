package com.example.lesson.sandbox.ch23;

import java.io.*;
import java.util.zip.*;

public class S06_ZipMultipleFiles {
    /**
     * 1. 教學目標
     * 展示如何重複使用同一個 ZipOutputStream，透過多次呼叫 putNextEntry 來將多個檔案塞進同一個壓縮檔中。
     *
     * 3. 講師備課指引
     * - 迴圈結構 : 強調外層迴圈遍歷檔案清單，內層迴圈讀寫檔案內容。
     * - 變數重用 : 注意 fis (FileInputStream) 在每次迴圈都要重新 new，因為每個檔案來源不同。
     */
    public static void main(String[] args) throws IOException {
        // 0. 準備測試檔案
        createTestFile("ch23_1.txt", "File 1 Content");
        createTestFile("ch23_2.txt", "File 2 Content");

        String[] srcFiles = { "ch23_1.txt", "ch23_2.txt" };

        // 1. 建立壓縮輸出串流 (只建立一次)
        FileOutputStream fos = new FileOutputStream("ch23_2.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        // 2. 迴圈處理每個檔案
        for (String srcFile : srcFiles) {
            File fileToZip = new File(srcFile);
            FileInputStream fis = new FileInputStream(fileToZip);

            // 3. 為每個檔案建立獨立的 ZipEntry
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry); // 開始寫入當前檔案

            // 4. 讀寫內容
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close(); // 讀完一個關一個
        }

        // 5. 關閉資源
        zipOut.close();
        fos.close();

        System.out.println("多檔壓縮完成! ");
    }

    private static void createTestFile(String name, String content) throws IOException {
        File f = new File(name);
        if (!f.exists()) {
            FileWriter fw = new FileWriter(f);
            fw.write(content);
            fw.close();
        }
    }
}
