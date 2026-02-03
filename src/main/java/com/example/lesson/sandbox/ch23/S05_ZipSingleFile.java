package com.example.lesson.sandbox.ch23;

import java.io.*;
import java.util.zip.*;

public class S05_ZipSingleFile {
    /**
     * 1. 教學目標
     * 展示如何使用 ZipOutputStream 壓縮一個簡單的文字檔，並透過 putNextEntry 告訴壓縮流「我要開始寫這個檔案了」。
     *
     * 3. 講師備課指引
     * - 準備工作 : 確保專案目錄下有 "ch23_1.txt" 檔案，否則會報錯 FileNotFoundException。
     * - 關鍵動作 : 強調 putNextEntry(new ZipEntry(...)) 是必要的，這就像是在壓縮檔裡開一個新資料夾或檔案的動作。
     */
    public static void main(String[] args) throws IOException {
        // 0. 準備測試檔案 (若不存在則建立)
        File srcFile = new File("ch23_1.txt");
        if (!srcFile.exists()) {
            FileWriter fw = new FileWriter(srcFile);
            fw.write("Hello Zip World!");
            fw.close();
            System.out.println("已建立測試檔案: ch23_1.txt");
        }

        // 1. 準備來源檔案
        String fileToZip = "ch23_1.txt";
        FileInputStream fis = new FileInputStream(fileToZip);

        // 2. 建立輸出串流 (ZipOutputStream 包裹 FileOutputStream)
        FileOutputStream fos = new FileOutputStream("ch23_1.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        // 3. 關鍵動作: 建立 ZipEntry (壓縮檔內的檔案標籤)
        ZipEntry zipEntry = new ZipEntry(srcFile.getName());
        zipOut.putNextEntry(zipEntry);

        // 4. 讀寫資料 (Buffer Loop)
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length); // 寫入壓縮串流
        }

        // 5. 關閉資源
        zipOut.close();
        fis.close();
        fos.close();

        System.out.println("壓縮完成! ");
    }
}
